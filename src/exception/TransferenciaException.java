package exception;

public class TransferenciaException extends OperacaoContaException {

    public TransferenciaException(String mensagem){
        super(mensagem);
    }

    public TransferenciaException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }   
}
