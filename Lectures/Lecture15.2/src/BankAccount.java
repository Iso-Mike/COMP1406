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
  
  public BankAccount(String initOwner){
    balance = 0.0;
    accountNumber = newAccountNumber;
    newAccountNumber++;
    owner = initOwner;
    institution = "Iron Bank of Braavos";
  }
  
  public BankAccount(String initOwner, double b, int num){
    balance = b;
    accountNumber = num;
    owner = initOwner;
    institution = "Iron Bank of Braavos";
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
    return owner + "'s BANK account with balance $" + balance; 
  }

  public void saveAccount(DataOutputStream out) throws IOException {
    out.writeUTF(getOwner());
    out.writeInt(getAccountNumber());
    out.writeDouble(getBalance());
  }

  public void saveAccount(PrintWriter out) throws IOException{
    out.println(owner);
    out.println(accountNumber);
    out.println(balance);
    out.println(this.toString());
  }

  public static BankAccount loadAccount(DataInputStream in) throws IOException{
    String name = in.readUTF();
    int acc = in.readInt();
    double bal = in.readDouble();
    return new BankAccount(name, bal, acc);
  }

  public static BankAccount loadAccount(BufferedReader in) throws IOException{
    String name = in.readLine();
    int acc = Integer.parseInt(in.readLine());
    double bal = Double.parseDouble(in.readLine());
    return new BankAccount(name, bal, acc);
  }
}