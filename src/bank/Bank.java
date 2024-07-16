package bank;

import java.util.HashSet;
import java.util.Set;
import account.Account;

public class Bank {
    private Set<Account> accounts;

    public Bank(){
        accounts = new HashSet<>();
    }

    public void adicionarConta(Account account){
        accounts.add(account);
    } 

    public boolean verificarConta(Account account){
        return accounts.contains(account);
    }    
}
