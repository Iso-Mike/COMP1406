import java.io.*;
public class ObjectOutputStreamTestProgram {
  public static void main(String args[]) {
    try {
      BankAccount aBankAccount;
      ObjectOutputStream out;
      aBankAccount = new BankAccount("Rob Banks");
      aBankAccount.deposit(175);
      
      out = new ObjectOutputStream(new FileOutputStream("resources" + File.separator + "myAcc.txt"));
      out.writeObject(aBankAccount);
      
      out.close();
    } catch (FileNotFoundException e) {
      System.out.println("Error: Cannot open file for writing");
    } catch (IOException e) {
      System.out.println("Error: Cannot write to file");
    }
  }
} 