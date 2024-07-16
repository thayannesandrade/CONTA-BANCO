package fee;

import account.*;

public class AdministrationFeePlus implements IAdministrationFeeStrategy {
    private static final double FEE = 22.0;

    @Override
    public void debitFee(Account account){
        account.withdraw(FEE);
    }  
}
