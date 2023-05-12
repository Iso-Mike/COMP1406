import java.io.*;
public class DataOutputStreamTestProgram {
  public static void main(String[] args) {
    try {
      BankAccount aBankAccount;
      DataOutputStream out;
      aBankAccount = new BankAccount("Rob Banks");
      aBankAccount.deposit(150);
      FileOutputStream fileOut = new FileOutputStream("resources" + File.separator + "myAccount.dat");
      out = new DataOutputStream(fileOut);
      
      out.writeUTF(aBankAccount.getOwner());
      out.writeInt(aBankAccount.getAccountNumber());
      out.writeDouble(aBankAccount.getBalance());

      out.close();
    } catch (FileNotFoundException e) {
      System.out.println("Error: Cannot open file for writing");
    } catch (IOException e) {
      System.out.println("Error: Cannot write to file");
    }
  }
}