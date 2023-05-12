/*
Chequing account with 5 free cheques per month
 */
public class PowerChequingAccount extends ChequingAccount{
    protected int freeCheques;

    public PowerChequingAccount(Person owner, Bank inst){
        super(owner, inst);
        freeCheques = 5;
    }

    public void monthlyUpkeep(){
        freeCheques += 5;
        super.monthlyUpkeep();
    }

    public void writeCheque(double amount){
        if(freeCheques > 0){
            freeCheques--;
        }else{
            amount += CHEQUE_FEE;
        }
        if(!withdraw(amount)){
            invalidCheques++;
        }
    }

    public String toString(){
        return owner + "'s power chequing account with $" + balance + " (Account #" + accountNumber + ")";
    }
}