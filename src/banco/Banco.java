package banco;

import java.util.HashSet;
import java.util.Set;

import conta.Conta;

public class Banco {
    private Set<Conta> contas;

    public Banco(){
        contas = new HashSet<>();
    }

    public void adicionarConta(Conta conta){
        contas.add(conta);
    } 

    public boolean verificarConta(Conta conta){
        return contas.contains(conta);
    }
    
}
