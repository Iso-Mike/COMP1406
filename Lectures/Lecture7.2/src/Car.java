
import java.util.Random;
public class Car implements Insurable, Sellable{
  Person owner;
  int year;
  double stickerPrice;
  int age;
  int policyNumber;
  static int nextPolicyNumber = 100000;

  public Car(Person initOwner, int initYear, double initPrice){
    owner = initOwner;
    year = initYear;
    stickerPrice = initPrice;
    age = 2018 - year;
    policyNumber = nextPolicyNumber;
    nextPolicyNumber++;
  }
  
  public String toString(){
    return "A " + age + " year old car owned by " + owner.toString();
  }

  public int getPolicyNumber() {
    return policyNumber;
  }

  public int getCoverageAmount() {
    return (int)(stickerPrice - (age * 100));
  }

  public double calculatePremium() {
    return stickerPrice/1000;
  }

  public String getExpiryDate() {
    return "November";
  }

  @Override
  public double getSalePrice() {
    return stickerPrice*6;
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