/*
Savings account with no withdrawal, pays interest twice
 */
public class SuperSavingsAccount extends SavingsAccount{

    public SuperSavingsAccount(Person owner, Bank inst){
        super(owner, inst);
    }

    /*
    Pay interest once, then perform savings account monthly upkeep
     */
    public void monthlyUpkeep(){
        balance += balance * interestRate;
        balance += balance * interestRate;
        if(balance >= monthlyFee){
            balance -= monthlyFee;
        }
    }

    public boolean withdraw(double amount){
        return false;
    }

    public String toString(){
        return owner + "'s super savings account with $" + balance + " (Account #" + accountNumber + ")";
    }
}