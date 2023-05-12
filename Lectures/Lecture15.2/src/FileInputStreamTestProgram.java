import java.io.*;
public class FileInputStreamTestProgram {
  public static void main(String[] args) {
    try {
      FileInputStream in = new FileInputStream("resources" + File.separator + "myFile.dat");
      
      while(in.available() > 0){
        System.out.print((char)in.read() + " ");
      }
      
      in.close();
    } catch (FileNotFoundException e) {
      System.out.println("Error: Cannot open file for reading");
    } catch (IOException e) {
      System.out.println("Error: Cannot read from file");
    }
  }
}