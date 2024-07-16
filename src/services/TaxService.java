package services;

import java.util.Scanner;
import account.Account;

public class TaxService {
    private static TaxService instance;
    private static Scanner scanner = new Scanner(System.in);

    private TaxService(){}

    public static synchronized TaxService getInstance(){
        if (instance == null) {
            instance = new TaxService();
        }
        return instance;
    }

    public boolean confirmAdditionalTransfer(Account account, double tax){
        System.out.println("A transferência excederá o seu limite de transferências gratuitas e será cobrada uma taxa adicional de R$ " + tax + "\nDeseja continuar a transferência? (s/n)");

        String response = scanner.nextLine().trim().toLowerCase();
        if (response.equals("s") || response.equals("sim")){
            if (account.getBalance() >= tax) {
                account.withdraw(tax);
                System.out.println("Foi cobrada uma taxa adicional de R$ " + tax);

                return true;
            }else{
                System.out.println("Saldo insuficiente para debitar a taxa.");
            }
        }
        return false;
    }    
}
