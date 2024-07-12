package exception;

public class OperacaoContaException extends Exception {

    public OperacaoContaException(String mensagem){
        super(mensagem);
    }

    public OperacaoContaException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
    
}
