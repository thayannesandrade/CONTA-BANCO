package account;

import client.Client;
import creditcard.IEligibleCreditCard;
import exception.*;
import fee.*;
import services.*;

public class PlusAccount extends Account implements IEligibleCreditCard, IAccountWithFee{
    private int freeTransfer = 5;
    private AdministrationFeePlus administrationFeePlus = new AdministrationFeePlus();
    private static final double ADDITIONAL_TRANSFER_FEE = 7.50;

    public PlusAccount(String number, Client client) {
        super(number, client);
    }

    @Override
    public void debitMonthlyRate(){
        administrationFeePlus.debitFee(this);
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

    @Override
    public boolean canRequestCreditCard(String cpf){
        return ServiceScore.consultScore(cpf) >= 550;
    }
}
