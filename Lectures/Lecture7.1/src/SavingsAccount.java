/*
State: all from BankAccount, interest rate
Behaviour: all from BankAccount, fee for withdraw
 */
public class SavingsAccount extends BankAccount{
    protected double interestRate;
    public static final double WITHDRAW_FEE = 5;

    public SavingsAccount(Person owner, Bank inst){
        super(owner, inst);
        interestRate = 0.05;
    }

    /*
    Pay interest in the account, and then perform regular bank account monthly upkeep
     */
    public void monthlyUpkeep(){
        setBalance(getBalance() + (getBalance() * interestRate));
        super.monthlyUpkeep();
    }

    /*
    Perform a regular bank account withdraw, but include a fee
     */
    public boolean withdraw(double amount){
        return super.withdraw(amount + WITHDRAW_FEE);
    }

    public String toString(){
        return getOwner() + "'s savings account with $" + getBalance() + " (Account #" + getAccountNumber() + ")";
    }
}