package Insurance;

import java.util.Random;
public class Car implements DepreciatingInsurable{
  Person owner;
  int year;
  double stickerPrice;
  int policyNum;
  double premiumAmount;
  String expiryDate;
  int age;
  
  public Car(Person initOwner, int initYear, double initPrice){
    owner = initOwner;
    year = initYear;
    stickerPrice = initPrice;
    Random rand = new Random();
    policyNum = rand.nextInt();
    premiumAmount = stickerPrice / 60;
    expiryDate = "August 7th";
    age = 2018 - year;
  }
  
  public String toString(){
    return "A " + age + " year old car owned by " + owner.toString();
  }
  
  public int getPolicyNumber(){
    return policyNum;
  }
  
  public int getCoverageAmount(){
    return (int)stickerPrice;
  }
  
  public double calculatePremium(){
    return premiumAmount;
  }
  
  public String getExpiryDate(){
    return expiryDate;
  }
  
  public double computeFairMarketValue(){
    double value = stickerPrice - (age * 10);
    return value;
  }
  
  public void amortizePayments(){
    premiumAmount -= 1;
  }
  
  public double getSalePrice(){
    return stickerPrice * 0.90;
  }
  
  public void changeOwner(Person newOwner){
    owner = newOwner;
  }
}