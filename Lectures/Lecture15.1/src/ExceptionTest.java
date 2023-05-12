import java.io.*;
public class ExceptionTest{
  public static void main(String[] args) throws FileNotFoundException{
    ExceptionTest t = new ExceptionTest();
    t.doSomeFileReading();
    System.out.println("Done!");
  }

  public void doSomeFileReading() throws FileNotFoundException{
    try {
      this.openFile();
      System.out.println("Success!");
    }catch(FileNotFoundException e){
      System.out.println("Error: The file was not found");
    }
  }
  
  public void openFile() throws FileNotFoundException{
    //Create a new exception and throw it
    if(Math.random() < 0.1) {
      throw new FileNotFoundException();
    }
  }
}