package fee;

import account.*;

public interface IAdministrationFeeStrategy {
    void debitFee(Account account);
} 
