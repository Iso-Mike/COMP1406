/*
Checuing account with faster processing, no cheque fee
 */
public class BusinessChequingAccount extends ChequingAccount{

    public BusinessChequingAccount(Person owner, Bank inst){
        super(owner, inst);
    }

    public void writeCheque(double amount){
        System.out.println("Fast cheque processing.");
        if(!withdraw(amount)){
            invalidCheques++;
        }
    }

    public String toString(){
        return owner + "'s business chequing account with $" + balance + " (Account #" + accountNumber + ")";
    }
}