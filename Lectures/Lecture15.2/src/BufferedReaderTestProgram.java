import java.io.*;
public class BufferedReaderTestProgram {
  public static void main(String args[]) {
    try {
      BankAccount aBankAccount;
      BufferedReader in;
      in = new BufferedReader(new FileReader("resources" + File.separator + "myAccount2.txt"));
      
      aBankAccount = BankAccount.loadAccount(in);
      
      System.out.println(aBankAccount);
      in.close();
    } catch (FileNotFoundException e) {
      System.out.println("Error: Cannot open file for reading");
    } catch (IOException e) {
      System.out.println("Error: Cannot read from file");
    }
  }
}