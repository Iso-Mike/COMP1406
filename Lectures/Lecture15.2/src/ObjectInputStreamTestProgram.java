import java.io.*;
public class ObjectInputStreamTestProgram {
  public static void main(String[] args) {
    try {
      BankAccount aBankAccount;
      ObjectInputStream in;
      
      in = new ObjectInputStream(new FileInputStream("resources" + File.separator + "myAcc.txt"));
      
      aBankAccount = (BankAccount)in.readObject();
      System.out.println(aBankAccount);

      in.close();
    } catch (ClassNotFoundException e) {
      System.out.println("Error: Object's class does not match");
    } catch (FileNotFoundException e) {
      System.out.println("Error: Cannot open file for writing");
    } catch (IOException e) {
      System.out.println("Error: Cannot read from file");
    }
  }
} 