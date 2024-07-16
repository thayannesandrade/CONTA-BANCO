package client;

import account.Account;

public class Client {
    private String name;
    private String cpf;
    private Account account;

    public Client(String name, String cpf, Account account) {
        this.name = name;
        this.cpf = cpf;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Account getAccount() {
        return account;
    }
}