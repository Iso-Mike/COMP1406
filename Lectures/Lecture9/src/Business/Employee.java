package Business;
public class Employee extends Person{
 private int employeeID;
 private double payAmount;
 private double totalEarnings;
 
 public Employee(String initName, int initID, double initPay){
   super(initName);
   employeeID = initID;
   payAmount = initPay;
   totalEarnings = 0.0;
 }
 
 public int getEmployeeID(){
   return employeeID;
 }
 
 public double getPayAmount(){
   return payAmount;
 }
 
 public double getEarnings(){
   return totalEarnings;
 }
 
 public void pay(){
   totalEarnings += payAmount;
 }
 
 public String toString(){
   return getName() + " is an employee.";
 }
}