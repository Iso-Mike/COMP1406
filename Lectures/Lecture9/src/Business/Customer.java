package Business;
public class Customer extends Person{
  public double money;
  
  public Customer(String initName, double initMoney){
    super(initName);
    money = initMoney;
  }
  
  public void spend(double amount){
    if(amount <= money){
      money -= amount;
    }
  }
  
  public double getMoney(){
    return money;
  }
 
 public String toString(){
   return getName() + " is a customer.";
 }
}