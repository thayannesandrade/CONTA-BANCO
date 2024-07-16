package exception;

public class TransferException extends AccountOperationException {

    public TransferException(String message){
        super(message);
    }

    public TransferException(String message, Throwable cause){
        super(message, cause);
    }   
}
