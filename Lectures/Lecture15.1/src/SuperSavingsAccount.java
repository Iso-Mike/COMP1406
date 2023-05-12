//A special Savings account
//Cannot make withdrawals
//Should collect interest two times every month
//Should not be charged a monthly fee
public class SuperSavingsAccount extends SavingsAccount{
 public SuperSavingsAccount(String initOwner){
  super(initOwner);
 }
 
 public boolean withdraw(double amount){
   //No withdraws allows, so should do nothing
   System.out.println("Cannot withdraw from SuperSavingsAccount");
   return false;
 }
 
 public void monthlyUpkeep(){
  deposit(checkBalance() * getInterestRate()); 
  deposit(checkBalance() * getInterestRate()); 
 }
 
 public String toString(){
  return getOwner() + "'s SUPERSAVINGS account with balance $" + checkBalance(); 
 }
}