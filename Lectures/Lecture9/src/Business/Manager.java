package Business;
public class Manager extends Employee{
 private Employee[] subordinates;
 public final int MAX_SUBORDINATES = 25;
 private int currentSubordinates;
 
 public Manager(String initName, int initID, double initPay){
   super(initName, initID, initPay);
   subordinates = new Employee[MAX_SUBORDINATES];
   currentSubordinates = 0;
 }
 
 public boolean addSubordinate(Employee e){
   if(currentSubordinates < MAX_SUBORDINATES){
     subordinates[currentSubordinates] = e;
     currentSubordinates++;
     return true;
   }
   return false;
 }
 
 public Employee[] getSubordinates(){
   return subordinates;
 }
 
 public String toString(){
   return getName() + " is a manager.";
 }
}