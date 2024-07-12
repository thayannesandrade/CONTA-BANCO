import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        try{
        String agencia, nomeCliente;
        int numeroConta;
        float saldoConta;

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.println("Por favor, digite o seu nome:");
        nomeCliente = scanner.nextLine();

        System.out.println("Por favor, digite o número da agência:");
        agencia = scanner.nextLine();

        System.out.println("Por favor, digite o número da conta:");
        numeroConta = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Por favor, digite o saldo em sua conta:");
        saldoConta = scanner.nextFloat();
        scanner.nextLine();

        System.out.println("Olá " + nomeCliente + ",obrigado por criar uma conta em nosso banco. Sua agência é: " + agencia + ", o número da sua conta é: " + numeroConta + " e seu saldo é de R$: " + String.format("%.2f",saldoConta) + " e já se encontra disponível para saque");

        scanner.close();
        }catch(InputMismatchException e){
            System.err.println("Os campos número da conta e saldo em conta precisam ser numéricos");
        }
    }
}