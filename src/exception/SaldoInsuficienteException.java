package exception;

public class SaldoInsuficienteException extends OperacaoContaException {

    public SaldoInsuficienteException(String mensagem){
        super(mensagem);
    }

    public SaldoInsuficienteException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}