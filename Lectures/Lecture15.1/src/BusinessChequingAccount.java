//A special chequing account that expedites cheque clearing
//Should not charge a fee for withdrawals
//No charge for writing cheques
//Should be charged a monthly fee
//Does not collect monthly interest
//Faster cheque clearing
public class BusinessChequingAccount extends ChequingAccount{
 public BusinessChequingAccount(String initOwner){
  super(initOwner);
 }
 
 //For now, we will assume writing a cheque is the same as withdrawing
 //We could add more logic for a real chequing account
 //For example, recording the cheque number and amount, placing the cheque into a hold, etc.
 public boolean writeCheque(double amount) throws WithdrawException{
   //no delay period (as opposed to longer delay period in ChequingAccount)
   //No fee for cheque
   System.out.println("Cashing cheque quickly (for business account)");
   return withdraw(amount);
 }
 
 
 public String toString(){
  return getOwner() + "'s BUSINESSCHEQUING account with balance $" + checkBalance(); 
 }
}