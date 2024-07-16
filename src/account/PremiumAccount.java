package account;

import client.Client;
import creditcard.EligibleCreditCard;
import exception.AccountOperationException;
import exception.InsufficientFundsException;
import exception.TransferException;
import fee.AdministrationFeePremium;
import fee.AccountWithFee;


public class PremiumAccount extends Account implements EligibleCreditCard, AccountWithFee {
    private AdministrationFeePremium administrationFeePremium = new AdministrationFeePremium();

    public PremiumAccount(String number, Client client) {
        super(number, client);
    }

    @Override
    public void debitMonthlyRate() {
        administrationFeePremium.debitFee(this);
    }

    @Override
    public boolean canRequestCreditCard(String cpf) {
        return this.balance >= 50000;
    }

    @Override
    public boolean transfer(double value, Account targetAccount) throws AccountOperationException{
        try {
            if (super.transfer(value, targetAccount)) {
                super.withdraw(value);
            }
            
        } catch (InsufficientFundsException e) {
            throw new AccountOperationException("Saldo insuficiente para realizar a transferência.", e);

        }catch(TransferException e){
            throw new AccountOperationException("Erro ao realizar transferência.", e);
        }
        return false;
    }
    
}
