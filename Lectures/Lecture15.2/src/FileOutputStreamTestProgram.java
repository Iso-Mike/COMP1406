import java.io.*; // Need to import since all Streams are in this package
public class FileOutputStreamTestProgram {
  public static void main(String[] args) {
    try {
      FileOutputStream out;
      out = new FileOutputStream("resources" + File.separator + "myFile.dat");
      
      out.write('H');
      out.write(69);
      out.write(76); 
      out.write('L');
      out.write('O'); 
      out.write('!');
      
      out.close();
    } catch (FileNotFoundException e) {
      System.out.println("Error: Cannot open file for writing");
    } catch (IOException e) {
      System.out.println("Error: Cannot write to file");
    }
  }
} 