import java.net.*;
import java.io.*;

public class Client{
  public static int SERVER_PORT = 5000;
  public static void main(String[] args){
    
    try {
      //Create the socket connection to server
      InetAddress address = InetAddress.getLocalHost();
      Socket socket = new Socket(address, SERVER_PORT);
      
      //Get the streams
      InputStream in = socket.getInputStream();
      OutputStream out = socket.getOutputStream();
      
      
      //Do processing
      System.out.println("Connected to server!");
      
      
      //close the socket
      socket.close();
    }
    catch(UnknownHostException e) {
      System.out.println("Host Unknown");
    }
    catch(IOException e) {
      System.out.println("Cannot connect to server");
    } 
  }
}