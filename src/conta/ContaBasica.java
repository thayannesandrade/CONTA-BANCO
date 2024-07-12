package conta;

import cliente.Cliente;
import taxas.TransacaoAdicional;
import exception.*;

public class ContaBasica extends Conta {
    private int transferenciasGratuitas = 1;
    private static final double TAXA_TRANSFERENCIA_ADICIONAL = 15.0;

    public ContaBasica(String numero, Cliente cliente) {
        super(numero, cliente);
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
}
