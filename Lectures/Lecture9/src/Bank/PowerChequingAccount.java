package Bank;
//A special chequing account
//Should not charge a fee for withdrawals
//Is not charged a monthly fee
//Has a fee for writing cheques
//Does not collect monthly interest
//Slower cheque clearing
public class PowerChequingAccount extends ChequingAccount{
 private double chequeFee;
 
 public PowerChequingAccount(String initOwner){
  super(initOwner);
  chequeFee = 1.0;
 }
 
 //For now, we will assume writing a cheque is the same as withdrawing
 //We could add more logic for a real chequing account
 //For example, recording the cheque number and amount, placing the cheque into a hold, etc.
 public boolean writeCheque(double amount){
   //longer delay period (as opposed to no delay period in BusinessChequingAccount)
   //Charged a fee for writing cheque
   return withdraw(amount + chequeFee);
 }
 
 public void monthlyUpkeep(){
  //Nothing required 
 }
 
 public String toString(){
  return getOwner() + "'s POWERCHEQUING account with balance $" + getBalance(); 
 }
}