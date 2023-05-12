package Business;
public abstract class Person implements Insurable{
 private String name;
 
 public Person(String initName){
   name = initName;
 }
 
 public String getName(){
   return name;
 }

 //this is not a good implementation
 //the details of the implmentation are not important for the example
 public int getPolicyNumber(){
   return (int)(Math.random() * 100000);
 }

 //this is not a good implementation
 //the details of the implmentation are not important for the example
 public double getCoverageAmount(){
   return name.length() * 275.99;
 }
 
 public String toString(){
   return getName() + " is a person.";
 }
}