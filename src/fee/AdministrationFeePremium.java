package fee;

import account.Account;

public class AdministrationFeePremium implements IAdministrationFeeStrategy{
    private static final double FEE = 50.0;

    @Override
    public void debitFee(Account account){
        account.withdraw(FEE);
    }
    
}
