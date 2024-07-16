package exception;

public class AccountOperationException extends Exception {

    public AccountOperationException(String message){
        super(message);
    }

    public AccountOperationException(String message, Throwable cause){
        super(message, cause);
    }
    
}
