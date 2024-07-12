package conta;

import cartaocredito.CartaoCreditoElegivel;
import cliente.Cliente;
import exception.OperacaoContaException;
import exception.SaldoInsuficienteException;
import exception.TransferenciaException;
import taxas.ContaComTaxa;


public class ContaPremium extends Conta implements CartaoCreditoElegivel, ContaComTaxa {
    private static final double TAXA_ADMINISTRAÇÃO = 50.0;

    public ContaPremium(String numero, Cliente cliente) {
        super(numero, cliente);
    }

    @Override
    public void debitarTaxaMensal() {
        super.sacar(TAXA_ADMINISTRAÇÃO);
    }

    @Override
    public boolean podeSolicitarCartaoCredito(String cpf) {
        return this.saldo >= 50000;
    }

    @Override
    public boolean transferir(double valor, Conta contaDestino) throws OperacaoContaException{
        try {
            if (super.transferir(valor, contaDestino)) {
                super.sacar(valor);
            }
            
        } catch (SaldoInsuficienteException e) {
            throw new OperacaoContaException("Saldo insuficiente para realizar a transferência.", e);

        }catch(TransferenciaException e){
            throw new OperacaoContaException("Erro ao realizar transferência.", e);
        }
        return false;
    }
    
}
