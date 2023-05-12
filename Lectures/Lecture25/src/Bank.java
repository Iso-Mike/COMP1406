import java.util.*;
import java.io.*;
public class Bank{
 private String name;
 private ArrayList<BankAccount> accounts;
 
 public Bank(String iName){
   name = iName;
   accounts = new ArrayList<BankAccount>();
 }
 
 public void addAccount(String owner){
   accounts.add(new BankAccount(owner, name));           
 }
 
 public boolean deposit(double amount, int accountNum){
  BankAccount acc = getAccount(accountNum); 
  if(acc != null){
    acc.deposit(amount);
    return true;
  }
  return false;
 }
 
 public double checkBalance(int accountNum){
   BankAccount acc = getAccount(accountNum); 
   if(acc != null){
     return acc.getBalance();
   }
   return -1.0;
 }
 
 public boolean withdraw(double amount, int accountNum){
   BankAccount acc = getAccount(accountNum); 
   if(acc != null){
     return acc.withdraw(amount);
   }
   return false;
 }
 
 public BankAccount getAccount(int accountNum){
   for(BankAccount b: accounts){
     if(b.getAccountNumber() == accountNum){
       return b;
     }
   }
   return null;
 }
 
 public void saveTo(PrintWriter aFile) {
   aFile.println(name);
   for (BankAccount b: accounts) {
     aFile.println(); 
     b.saveTo(aFile);
   }
 }
 
 public boolean save(String file){
   try{
     PrintWriter out = new PrintWriter(new FileWriter(file));
     
     saveTo(out);
     
     out.close();
     return true;     
   }catch(Exception e){
     e.printStackTrace();
   }
   return false;
 }
 
 public Bank load(String file){
   try{
     BufferedReader in = new BufferedReader(new FileReader(file));
     
     Bank b = loadFrom(in);
     
     in.close();
     return b;     
   }catch(Exception e){
     e.printStackTrace();
   }
   return null;
 }
 
 public static Bank loadFrom(BufferedReader aFile) throws IOException {
   Bank aBank = new Bank(aFile.readLine());
   
   while (aFile.ready()) { 
     aFile.readLine();
     aBank.accounts.add(BankAccount.loadFrom(aFile)); 
   }
   return aBank;
 }
 
 public String list(){
   String result = name + "\n\n";
   for(BankAccount b: accounts){
     result += b + "\n";
   }
   return result;
 }
 
}