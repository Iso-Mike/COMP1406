/*
Savings account with deposit bonus when > 1000 is deposited
 */
public class PowerSavingsAccount extends SavingsAccount{
    public static final double DEPOSIT_BONUS = 25;

    public PowerSavingsAccount(Person owner, Bank inst){
        super(owner, inst);
    }

    public boolean deposit(double amount){
        if(amount > 0) {
            if(amount >= 1000){
                amount += DEPOSIT_BONUS;
            }
            balance += amount;
            return true;
        }
        return false;
    }

    public String toString(){
        return owner + "'s power savings account with $" + balance + " (Account #" + accountNumber + ")";
    }
}