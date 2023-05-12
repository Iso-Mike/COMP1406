import java.io.*;
public class DataInputStreamTestProgram {
  public static void main(String[] args) {
    try {
      DataInputStream in;
      in = new DataInputStream(new FileInputStream("resources" + File.separator + "myAccount.dat"));

      BankAccount a = BankAccount.loadAccount(in);
      System.out.println(a);

      in.close();
    } catch (FileNotFoundException e) {
      System.out.println("Error: Cannot open file for reading");
    } catch (IOException e) {
      System.out.println("Error: Cannot read from file");
    }
  }
}