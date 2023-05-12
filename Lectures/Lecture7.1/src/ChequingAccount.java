/*
State: all from BankAccount, cheque fee, # invalid cheques
Behaviour: all from BankAccount, write cheque
 */
public class ChequingAccount extends BankAccount{
    protected int invalidCheques;
    public static final int CHEQUE_FEE = 1;

    public ChequingAccount(Person owner, Bank inst){
        super(owner, inst);
        invalidCheques = 0;
    }

    public void writeCheque(double amount){
        if(!withdraw(amount + CHEQUE_FEE)){
            invalidCheques++;
        }
    }

    public String toString(){
        return owner + "'s chequing account with $" + balance + " (Account #" + accountNumber + ")";
    }
}