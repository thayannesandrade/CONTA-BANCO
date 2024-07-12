package conta;

import cartaocredito.CartaoCreditoElegivel;
import cliente.Cliente;
import servicos.*;
import taxas.*;
import exception.*;

public class ContaPlus extends Conta implements CartaoCreditoElegivel, ContaComTaxa{
    private int transferenciasGratuitas = 5;
    private static final double TAXA_ADMINISTRACAO = 22.0;
    private static final double TAXA_TRANSFERENCIA_ADICIONAL = 7.50;

    public ContaPlus(String numero, Cliente cliente) {
        super(numero, cliente);
    }

    @Override
    public void debitarTaxaMensal(){
        super.sacar(TAXA_ADMINISTRACAO);
    }

    @Override
    public boolean transferir(double valor, Conta contaDestino) throws OperacaoContaException{
        try {
            if (super.transferir(valor, contaDestino)) {
                if (transferenciasGratuitas > 0) {
                    transferenciasGratuitas --;
                }else{
                    boolean continuar = TransacaoAdicional.confirmaTransferenciaAdicional(TAXA_TRANSFERENCIA_ADICIONAL);
                    if (!continuar) {
                        super.sacar(valor);
                        return false;  
                    }
                    super.sacar(TAXA_TRANSFERENCIA_ADICIONAL);
                    System.out.println("Limite de transferências gratuitas excedido. Foi cobrada uma taxa adicional de R$ " + TAXA_TRANSFERENCIA_ADICIONAL);
                }
                return true;  
            }

        } catch (SaldoInsuficienteException e) {
            throw new OperacaoContaException("Saldo insuficiente para realizar a transferência.", e);

        }catch(TransferenciaException e){
            throw new OperacaoContaException("Erro ao realizar transferência.", e);
        }
        return false;
    }

    @Override
    public boolean podeSolicitarCartaoCredito(String cpf){
        return ServicoScore.consultarScore(cpf) >= 550;
    }
}
