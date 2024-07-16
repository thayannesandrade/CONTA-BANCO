package transactions;

import account.Account;
import exception.*;

public interface Transaction {

    boolean pix(double value, Account account) throws AccountOperationException;

    boolean transfer(double value, Account account) throws AccountOperationException;

    boolean deposit(double value);

    boolean withdraw(double value);
    
}