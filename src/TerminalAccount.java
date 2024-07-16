import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class TerminalAccount {
    public static void main(String[] args) throws Exception {
        try{
        String agency, clientName;
        int numberAccount;
        float balanceAccount;

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.println("Por favor, digite o seu nome:");
        clientName = scanner.nextLine();

        System.out.println("Por favor, digite o número da agência:");
        agency = scanner.nextLine();

        System.out.println("Por favor, digite o número da conta:");
        numberAccount = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Por favor, digite o saldo em sua conta:");
        balanceAccount = scanner.nextFloat();
        scanner.nextLine();

        System.out.println("Olá " + clientName + ",obrigado por criar uma conta em nosso banco. Sua agência é: " + agency + ", o número da sua conta é: " + numberAccount + " e seu saldo é de R$: " + String.format("%.2f",balanceAccount) + " e já se encontra disponível para saque");

        scanner.close();
        }catch(InputMismatchException e){
            System.err.println("Os campos número da conta e saldo em conta precisam ser numéricos");
        }
    }
}