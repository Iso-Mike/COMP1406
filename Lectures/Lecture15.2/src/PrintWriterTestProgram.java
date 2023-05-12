import java.io.*;
public class PrintWriterTestProgram {
  public static void main(String[] args) {
    try {
      BankAccount aBankAccount;
      PrintWriter out;
      aBankAccount = new BankAccount("Rob Banks");
      aBankAccount.deposit(300);
      
      out = new PrintWriter(new FileWriter("resources" + File.separator + "myAccount2.txt"));
      aBankAccount.saveAccount(out);
      
      out.close();
    } catch (FileNotFoundException e) {
      System.out.println("Error: Cannot open file for writing");
    } catch (IOException e) {
      System.out.println("Error: Cannot write to file");
    }
  }
} 