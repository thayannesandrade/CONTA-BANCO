package taxas;

import java.util.Scanner;

public class TransacaoAdicional {
    private static Scanner scanner = new Scanner(System.in);
    public static boolean confirmaTransferenciaAdicional(double taxaAdicional){
        System.out.println("A transferência excederá o seu limite de transferências gratuitas e será cobrada uma taxa adicional de RS" + taxaAdicional + "\n Deseja continuar a transferência? (s/n)");
        
        String resposta = scanner.nextLine().trim().toLowerCase();
        return resposta.equals("s") || resposta.equals("sim"); 
    }    
}
