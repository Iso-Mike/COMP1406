package Insurance;

public class Person implements FixedInsurable{
 String name;
 int age;
 boolean healthy;
 
 public Person(String initName, int initAge, boolean initHealthy){
   name = initName;
   age = initAge;
   healthy = initHealthy;
 }
 
 public int getPolicyNumber(){
   return age; //we would return a real policy number, in general
 }
  
 public int getCoverageAmount(){
   return 1000000;
 }
    
 public double calculatePremium(){
   if(healthy){
     return age;
   }
   return age * 1.5;
 }
 public String getExpiryDate(){
   return "September";
 }
 
 public int getEvaluationPeriod(){
   return 12;
 }
 
 public String toString(){
   return "A person named " + name;
 }
}