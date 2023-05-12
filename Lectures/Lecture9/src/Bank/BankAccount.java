package Bank;
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
 protected final double MONTHLY_FEE = 1.00;
 
 public BankAccount(String initOwner){
  balance = 0.0;
  accountNumber = newAccountNumber;
  newAccountNumber++;
  owner = initOwner;
  institution = "Iron Bank of Braavos";
 } 
 
 public boolean withdraw(double amount){
   if(amount <= balance){
     balance -= amount;
     return true;
   }
   return false;
 }
 
 protected void setBalance(double newBalance){
   if(newBalance >= 0){
     balance = newBalance;
   }
 }
 
 public double getBalance(){
   return balance;
 }
 
 public String getOwner(){
   return owner;
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
 
 public void monthlyUpkeep(){
  withdraw(MONTHLY_FEE); 
 }
 
 public String toString(){
  return owner + "'s BANK account with balance $" + balance; 
 }
}