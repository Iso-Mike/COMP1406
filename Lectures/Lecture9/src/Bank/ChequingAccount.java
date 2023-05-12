package Bank;
//A standard chequing account with deposit, withdraw, check writing and balance checking functionality
//Should not charge a fee for withdrawals
//Should be charged a monthly fee
//Does not collect monthly interest
//Can write cheques without a fee
public class ChequingAccount extends BankAccount{
 public ChequingAccount(String initOwner){
  super(initOwner);
 }
 
 //For now, we will assume writing a cheque is the same as withdrawing
 //We could add more logic for a real chequing account
 //For example, recording the cheque number and amount, placing the cheque into a hold, etc.
 public boolean writeCheque(double amount){
   //longer delay period (as opposed to no delay period in BusinessChequingAccount)
   return withdraw(amount);
 }
 
 public void monthlyUpkeep(){
  withdraw(MONTHLY_FEE); 
 }
 
 public String toString(){
  return getOwner() + "'s CHEQUING account with balance $" + getBalance(); 
 }
}