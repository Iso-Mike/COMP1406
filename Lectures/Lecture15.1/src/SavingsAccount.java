//A standard Savings account with deposit, withdraw and balance checking functionality
//Should collect interest every month
//Has a withdraw fee
//Should not be charged a monthly fee
public class SavingsAccount extends BankAccount{
 private double interestRate; //new variable not contained in BankAccount
 private double withdrawFee; //new variable not contained in BankAccount
  
 public SavingsAccount(String initOwner){
  super(initOwner);
  interestRate = 0.01;
  withdrawFee = 1.0;
 }
 
 public double getInterestRate(){
   return interestRate;
 }
 
 public boolean withdraw(double amount) throws WithdrawException{
   return super.withdraw(amount + withdrawFee);
 }
 
 public void monthlyUpkeep(){
  super.deposit(checkBalance() * interestRate); 
 }
 
 public String toString(){
  return getOwner() + "'s SAVINGS account with balance $" + checkBalance(); 
 }
}