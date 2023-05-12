package Bank;
//A special Savings account
//Can make withdrawals with a fee
//Should collect interest every month
//Should not have a monthly fee
public class PowerSavingsAccount extends SavingsAccount{
 public PowerSavingsAccount(String initOwner){
  super(initOwner);
 }
 
 public String toString(){
  return getOwner() + "'s POWERSAVINGS account with balance $" + getBalance(); 
 }
}