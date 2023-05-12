
public class Person implements Insurable {
 String name;
 int age;
 boolean healthy;
 int policyNumber;
 boolean isPremium;
 static int nextPolicyNumber = 200000;
 
 public Person(String initName, int initAge, boolean initHealthy){
   name = initName;
   age = initAge;
   healthy = initHealthy;
   policyNumber = nextPolicyNumber++;
   isPremium = false;
 }

 public String toString(){
   return "A person named " + name;
 }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public int getCoverageAmount() {
        if(isPremium){
            return 10000000;
        }else{
            return 6;
        }
    }

    public double calculatePremium() {
        double base = 10;
        if(isPremium){
            base = base * 1.05;
        }

        if(!healthy){
            base = base * 1.1;
        }

        return base;
    }

    public String getExpiryDate() {
        return "January";
    }
}