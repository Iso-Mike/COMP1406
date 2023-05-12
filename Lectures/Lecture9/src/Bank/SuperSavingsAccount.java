package Bank;
//A special Savings account
//Cannot make withdrawals
//Should collect interest two times every month
//Should not be charged a monthly fee
public class SuperSavingsAccount extends SavingsAccount{
 public SuperSavingsAccount(String initOwner){
   super(initOwner);
 }
 
 public void monthlyUpkeep(){
  super.monthlyUpkeep();
  super.monthlyUpkeep();
 }
 
 public boolean withdraw(double amount){
  return false; 
 }
 
 public String toString(){
  return getOwner() + "'s SUPERSAVINGS account with balance $" + getBalance(); 
 }
}