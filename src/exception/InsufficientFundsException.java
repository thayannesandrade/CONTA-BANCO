package exception;

public class InsufficientFundsException extends AccountOperationException {

    public InsufficientFundsException(String message){
        super(message);
    }

    public InsufficientFundsException(String message, Throwable cause){
        super(message, cause);
    }
}