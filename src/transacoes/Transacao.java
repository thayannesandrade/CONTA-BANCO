package transacoes;

import conta.Conta;
import exception.*;

public interface Transacao {

    boolean pix(double valor, Conta conta) throws OperacaoContaException;

    boolean transferir(double valor, Conta conta) throws OperacaoContaException;

    boolean depositar(double valor);

    boolean sacar(double valor);
    
}
