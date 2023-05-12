//A standard bank account with deposit, withdraw, and balance checking functionality
//Should not charge a fee for withdrawals
//Should be charged a monthly fee
//Does not collect monthly interest
import java.io.*;
public class BankAccount implements Serializable{
  private static int newAccountNumber = 0;
  private String owner;
  private String institution;
  private double balance;
  private int accountNumber;
  public final double MONTHLY_FEE = 1.00;
  
  public BankAccount(String initOwner, String inst){
    balance = 0.0;
    accountNumber = newAccountNumber;
    newAccountNumber++;
    owner = initOwner;
    institution = inst;
  }
  
  public BankAccount(String initOwner, double b, int num, String initI){
    balance = b;
    accountNumber = num;
    if(accountNumber >= newAccountNumber){
      newAccountNumber = accountNumber + 1;
    }
    owner = initOwner;
    institution = initI;
  }
  
  public int getAccountNumber(){
    return accountNumber;
  }
  
  public float getBalance(){
    return (float)balance;
  }
  
  public String getOwner(){
    return owner;
  }
  
  public boolean withdraw(double amount){
    if(amount <= balance){
      balance -= amount;
      return true;
    }
    return false;
  }
  
  public boolean deposit(double amount){
    if(amount >= 0){
      balance += amount;
      return true;
    }
    return false;
  }  
  
  public double checkBalance(){
    return balance;
  }
  
  public void monthlyUpkeep(){
    withdraw(MONTHLY_FEE); 
  }
  
  public String toString(){
    return owner + "'s BANK account (" + accountNumber + ") with balance $" + balance; 
  }
  
  public void saveTo(PrintWriter aFile) {
    aFile.println(institution);
    aFile.println(accountNumber);
    aFile.println(owner);
    aFile.println(balance);
  }
  
  public static BankAccount loadFrom(BufferedReader aFile) throws IOException {
    String inst = aFile.readLine();
    int num = Integer.parseInt(aFile.readLine());
    String owner = aFile.readLine();
    double balance = Double.parseDouble(aFile.readLine());
    BankAccount b = new BankAccount(owner, balance, num, inst);
    return b;
  }
}