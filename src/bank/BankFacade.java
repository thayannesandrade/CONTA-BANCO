package bank;

import account.Account;
import account.BasicAccount;
import account.ContaPremium;
import account.PlusAccount;
import client.Client;
import exception.OperacaoContaException;

public class BankFacade {
    public BasicAccount openBasicAccount(String number, Client client) {
        return new BasicAccount(number, client);
    }

    public PlusAccount openPlusAccount(String number, Client client) {
        return new PlusAccount(number, client);
    }

    public ContaPremium openPremiumAccount(String number, Client client) {
        return new ContaPremium(number, client);
    }

    public boolean transfer(Account origin, double value, Account target) throws OperacaoContaException {
        return origin.transfer(value, target);
    }

    public boolean deposit(Account account, double value) {
        return account.deposit(value);
    }

    public boolean withdraw(Account account, double value) {
        return account.withdraw(value);
    }
}