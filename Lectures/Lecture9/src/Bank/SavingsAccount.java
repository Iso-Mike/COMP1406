package Bank;
//A standard Savings account with deposit, withdraw and balance checking functionality
//Should collect interest every month
//Should not be charged a monthly fee
public class SavingsAccount extends BankAccount{
 private double interestRate; //new variable not contained in BankAccount
 private double withdrawFee;
 
 
 public SavingsAccount(String initOwner){
 super(initOwner);
 interestRate = 0.01;
  withdrawFee = 1.0;
 }
 
 public boolean withdraw(double amount){
   return super.withdraw(amount + withdrawFee);
 }
 
 public void monthlyUpkeep(){
  setBalance(getBalance() + (getBalance() * interestRate)); 
 }
 
 public String toString(){
  return getOwner() + "'s SAVINGS account with balance $" + getBalance(); 
 }
}