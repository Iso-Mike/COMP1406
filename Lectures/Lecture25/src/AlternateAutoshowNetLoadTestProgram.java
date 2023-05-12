import java.net.*;
import java.io.*;
public class AlternateAutoshowNetLoadTestProgram {
  // This method tests the reading of an autoshow from a file
  private static void readTest() {
    URL webpage = null;
    BufferedReader in = null;
    
    //First create the URL
    try {
      webpage = new URL("http://davemckenney.ca/javafiles/autoshow.txt");
    } catch(MalformedURLException e) {
      System.out.println("Cannot find webpage " + webpage);
      System.exit(-1);
    }
    
    //Then open a connection and create the stream
    try {
      URLConnection aConnection = webpage.openConnection();
      in = new BufferedReader(new InputStreamReader(aConnection.getInputStream()));
    }
    catch (IOException e) {
      System.out.println("Cannot connect to webpage " + webpage);
      System.exit(-1);
    }
    
    //Then read the contents
    try {
      Autoshow aShow = Autoshow.loadFrom(in);
      aShow.showCars();
      in.close();
    } catch(IOException e) {
      System.out.println("Cannot read from webpage " + webpage);
    }   
  }
  
  public static void readURL(String url){
    URL webpage = null;
    BufferedReader in = null;
    
    //First create the URL
    try {
      webpage = new URL(url);
    } catch(MalformedURLException e) {
      System.out.println("Cannot find webpage " + webpage);
      return;
    }
    
    //Then open a connection and create the stream
    try {
      URLConnection aConnection = webpage.openConnection();
      in = new BufferedReader(new InputStreamReader(aConnection.getInputStream()));
    }
    catch (IOException e) {
      System.out.println("Cannot connect to webpage " + webpage);
      System.exit(-1);
    }
    
    //Then read the contents
    try {
      while(in.ready()){
        System.out.println(in.readLine());
      }
    } catch(IOException e) {
      System.out.println("Cannot read from webpage " + webpage);
    }   
  }
  public static void main(String[] args) {
    readTest(); // Read an autoshow from the file
   // readURL("http://www.google.ca");
  }
} 