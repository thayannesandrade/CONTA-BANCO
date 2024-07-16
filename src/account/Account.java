package account;

import client.Client;
import exception.AccountOperationException;
import transactions.Transaction;

public abstract class Account implements Transaction{
    protected String number;
    protected double balance;
    protected Client client;

    public Account(String number, Client client){
        this.number = number;
        this.client = client;
        this.balance = 0.0;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean deposit(double value){
        if (value > 0) {
            this.balance += value;
            System.out.println("Depósito realizado com sucesso.");
            return true;
        }
        System.out.println("Não foi possível concluir a operação. Tente novamente.");
        return false;
    }

    @Override
    public boolean withdraw(double value){
        if (this.balance >= value && value > 0) {
            this.balance -= value;
            System.out.println("Saque realizado com sucesso.");
            return true;
        }
        System.out.println("Não foi possível concluir a operação. Tente novamente.");
        return false;
    }

    @Override
    public boolean pix(double value, Account targetAccount) throws AccountOperationException{
        if (this.balance > 0 && value <= this.balance) {
            System.out.println("Pix realizado com sucesso.");
            return this.transfer(value, targetAccount);   
        }
        System.out.println("Não foi possível concluir a operação. Saldo insuficiente.");
        return false;  
    }

    @Override
    public boolean transfer(double value, Account targetAccount) throws AccountOperationException{
        if (this.balance > 0 && value <= this.balance) {
            if (this.withdraw(value)) {
                return targetAccount.withdraw(value);
            }
        }
        return false;
    }   
}
