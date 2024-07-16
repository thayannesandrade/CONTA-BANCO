package account;

import client.Client;
import creditcard.EligibleCreditCard;
import exception.OperacaoContaException;
import exception.SaldoInsuficienteException;
import exception.TransferenciaException;
import fee.AdministrationFeePremium;
import fee.ContaComTaxa;


public class ContaPremium extends Account implements EligibleCreditCard, ContaComTaxa {
    private AdministrationFeePremium administrationFeePremium = new AdministrationFeePremium();

    public ContaPremium(String number, Client client) {
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
    public boolean transfer(double value, Account targetAccount) throws OperacaoContaException{
        try {
            if (super.transfer(value, targetAccount)) {
                super.withdraw(value);
            }
            
        } catch (SaldoInsuficienteException e) {
            throw new OperacaoContaException("Saldo insuficiente para realizar a transferência.", e);

        }catch(TransferenciaException e){
            throw new OperacaoContaException("Erro ao realizar transferência.", e);
        }
        return false;
    }
    
}
