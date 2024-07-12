/* import banco.Banco;
import conta.Conta;
import conta.ContaBasica;
import conta.ContaPlus;

public class DesafioContaDigital {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Conta contaCorrente = new ContaBasica("252547", 152.0);
        Conta contaPoupanca = new ContaPlus("262428", 0.1);

        banco.adicionarConta(contaCorrente);
        banco.adicionarConta(contaPoupanca);

        contaCorrente.depositar(1000.0);
        contaPoupanca.depositar(3000.0);

        contaCorrente.sacar(300.0);
        contaPoupanca.sacar(150.0);

        contaCorrente.transferir(contaPoupanca, 200.0, banco);

        System.out.println("Saldo da conta poupança: " + contaPoupanca.getSaldo());
        ((ContaPlus) contaPoupanca).aplicarRendimento();
        
        System.out.println("Saldo conta corrente: " + contaCorrente.getSaldo());
    }
}*/