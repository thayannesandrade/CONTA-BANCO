package conta;

import transacoes.Transacao;
import cliente.Cliente;
import exception.OperacaoContaException;

public abstract class Conta implements Transacao{
    protected String numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(String numero, Cliente cliente){
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean depositar(double valor){
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito realizado com sucesso.");
            return true;
        }
        System.out.println("Não foi possível concluir a operação. Tente novamente.");
        return false;
    }

    @Override
    public boolean sacar(double valor){
        if (this.saldo >= valor && valor > 0) {
            this.saldo -= valor;
            System.out.println("Saque realizado com sucesso.");
            return true;
        }
        System.out.println("Não foi possível concluir a operação. Tente novamente.");
        return false;
    }

    @Override
    public boolean pix(double valor, Conta contaDestino) throws OperacaoContaException{
        if (this.saldo > 0 && valor <= this.saldo) {
            System.out.println("Pix realizado com sucesso.");
            return this.transferir(valor, contaDestino);   
        }
        System.out.println("Não foi possível concluir a operação. Saldo insuficiente.");
        return false;  
    }

    @Override
    public boolean transferir(double valor, Conta contaDestino) throws OperacaoContaException{
        if (this.saldo > 0 && valor <= this.saldo) {
            if (this.sacar(valor)) {
                return contaDestino.depositar(valor);
            }
        }
        return false;
    }   
}
