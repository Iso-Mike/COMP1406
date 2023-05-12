import java.net.*;
import java.io.*;
import java.util.*;
public class ArithmeticClient{
  public static int SERVER_PORT = 5000;
  public static void main(String[] args){
    
    try {
      InetAddress address = InetAddress.getLocalHost();
      Socket socket = new Socket(address, SERVER_PORT);
      DataInputStream in = new DataInputStream(socket.getInputStream());
      DataOutputStream out = new DataOutputStream(socket.getOutputStream());
      
      //Everything here is the same as our basic client  
      //We need to get necessary information from user and send it to server
      //We can then read the result from the server
      int x = 5;
      int y = 10;
      int op = 1; // 0 = add, 1 = subtract
      out.writeInt(x);
      out.writeInt(y);
      out.writeInt(op);
      int result = in.readInt();
      System.out.println("The result was: " + result);
      
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