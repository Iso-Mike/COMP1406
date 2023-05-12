package Insurance;

public class Building implements FixedInsurable{
 String address;
 int squareFeet;
 boolean sketchyNeighbourhood;
 Person owner;
 
 public Building(String initAdd, int initFeet, boolean initNeighbour, Person initOwner){
   address = initAdd;
   squareFeet = initFeet;
   sketchyNeighbourhood = initNeighbour;
   owner = initOwner;
 }
 
 public String toString(){
  return "A building at " + address + " owned by " + owner.toString(); 
 }
 
 public int getPolicyNumber(){
   return 6;
 }
  
 public int getCoverageAmount(){
   return 100 * squareFeet;
 }
    
 public double calculatePremium(){
   if(sketchyNeighbourhood){
     return 2 * squareFeet;
   }
   return 1 * squareFeet;
 }
 public String getExpiryDate(){
   return "September";
 }
 
 public int getEvaluationPeriod(){
   return 12;
 }
 
 public double getSalePrice(){
   if(sketchyNeighbourhood){
     return 5 * squareFeet;
   }else{
     return 10 * squareFeet;
   }
 }
 public void changeOwner(Person newOwner){
   owner = newOwner;
 }
}