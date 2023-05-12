import java.io.*;
import java.util.*; // Needed for use of Scanner and NoSuchElementException
public class BufferedReaderTestProgram2 {
  public static void main(String[] args) {
    try {
      BankAccount aBankAccount;
      Scanner in = new Scanner(new FileReader("resources" + File.separator + "myAccount2.txt"));
      
      String name = in.nextLine();
      int acc = in.nextInt();
      float bal = in.nextFloat();
      aBankAccount = new BankAccount(name, bal, acc);
      
      System.out.println(aBankAccount);
      in.close();
    } catch (FileNotFoundException e) {
      System.out.println("Error: Cannot open file for reading");
    } catch (NoSuchElementException e) {
      System.out.println("Error: EOF encountered, file may be corrupt");
    } 
  }
} 