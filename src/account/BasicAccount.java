package account;

import client.Client;
import exception.*;
import services.TaxService;

public class BasicAccount extends Account {
    private int freeTransfer = 1;
    private static final double ADDITIONAL_TRANSFER_FEE = 15.0;

    public BasicAccount(String number, Client client) {
        super(number, client);
    }

    @Override
    public boolean transfer(double value, Account targetAccount) throws AccountOperationException{
        try {
            if (super.transfer(value, targetAccount)) {
                if (freeTransfer > 0) {
                    freeTransfer --;
                }else{
                    boolean proceed = TaxService.getInstance().confirmAdditionalTransfer(this, ADDITIONAL_TRANSFER_FEE);
                    if (!proceed) {
                        super.withdraw(value);
                        return false;  
                    }
                    super.withdraw(ADDITIONAL_TRANSFER_FEE);
                    System.out.println("Limite de transferências gratuitas excedido. Foi cobrada uma taxa adicional de R$ " + ADDITIONAL_TRANSFER_FEE);
                }
                return true;  
            }

        } catch (InsufficientFundsException e) {
            throw new AccountOperationException("Saldo insuficiente para realizar a transferência.", e);

        }catch(TransferException e){
            throw new AccountOperationException("Erro ao realizar transferência.", e);
        }
        return false;
    }
}
