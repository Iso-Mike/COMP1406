
public class Building implements Insurable, Sellable {
 String address;
 int squareFeet;
 boolean sketchyNeighbourhood;
 Person owner;
 int policyNumber;
 static int nextPolicyNumber = 300000;
 
 public Building(String initAdd, int initFeet, boolean initNeighbour, Person initOwner){
   address = initAdd;
   squareFeet = initFeet;
   sketchyNeighbourhood = initNeighbour;
   owner = initOwner;
   policyNumber = nextPolicyNumber++;
 }
 
 public String toString(){
  return "A building at " + address + " owned by " + owner.toString(); 
 }

    @Override
    public int getPolicyNumber() {
        return policyNumber;
    }

    @Override
    public int getCoverageAmount() {
        return squareFeet * 100;
    }

    @Override
    public double calculatePremium() {
        double base = 0.25 * squareFeet;
        if(sketchyNeighbourhood){
            base *= 1.25;
        }
        return base;
    }

    @Override
    public String getExpiryDate() {
        return "October";
    }

    @Override
    public double getSalePrice() {
     if(sketchyNeighbourhood){
         return squareFeet * 75000;
     }else{
         return squareFeet * 100000;
     }
    }

    @Override
    public void changeOwner(Person newOwner) {
        owner = newOwner;
    }

    @Override
    public Person getCurrentOwner() {
        return owner;
    }
}