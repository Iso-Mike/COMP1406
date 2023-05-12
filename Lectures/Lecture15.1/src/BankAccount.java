//A standard bank account with deposit, withdraw, and balance checking functionality
//Should not charge a fee for withdrawals
//Should be charged a monthly fee
//Does not collect monthly interest
public class BankAccount{
 private static int newAccountNumber = 0;
 private String owner;
 private String institution;
 private double balance;
 private int accountNumber;
 public final double MONTHLY_FEE = 1.00;
 
 public BankAccount(String initOwner){
  balance = 0.0;
  accountNumber = newAccountNumber;
  newAccountNumber++;
  owner = initOwner;
  institution = "Iron Bank of Braavos";
 }
 
 public String getOwner(){
   return owner;
 }
 
 public boolean withdraw(double amount) throws WithdrawException{
     if (amount <= balance) {
         balance -= amount;
         return true;
     }
     throw new WithdrawException("You're broke.");
 }
 
 public boolean deposit(double amount){
   if(amount >= 0){
    balance += amount;
    return true;
   }
   return false;
 }  
 
 public double checkBalance(){
   return balance;
 }
 
 public void monthlyUpkeep() throws WithdrawException{
   try{
     withdraw(MONTHLY_FEE); 
   }catch(WithdrawException e){
       e.printStackTrace();
     throw new WithdrawException("You're so broke.");
   }
 }
 
 public String toString(){
  return owner + "'s BANK account with balance $" + balance; 
 }
}