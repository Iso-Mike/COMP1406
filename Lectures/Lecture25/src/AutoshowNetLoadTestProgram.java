import java.net.*;
import java.io.*;
public class AutoshowNetLoadTestProgram {
  // This method tests the reading of an autoshow from a file
  private static void readTest() throws IOException {
    URL webpage = new URL("http://davemckenney.ca/javafiles/autoshow.txt");
    BufferedReader in = new BufferedReader(new InputStreamReader(webpage.openStream()));
    Autoshow aShow = Autoshow.loadFrom(in);
    aShow.showCars();
    in.close();
  }
  public static void main(String[] args) throws IOException {
    readTest(); // Read an autoshow from the file
  }
} 

