import java.net.*;
import java.io.*;
import java.util.*;
public class ArithmeticClient{
  public static int SERVER_PORT = 5000;
  public static void main(String[] args){
    
    try {
      InetAddress address = InetAddress.getLocalHost();
      Socket socket = new Socket(InetAddress.getByName("172.17.30.34"), SERVER_PORT);
      DataInputStream in = new DataInputStream(socket.getInputStream());
      DataOutputStream out = new DataOutputStream(socket.getOutputStream());
      
      
      //Everything here is the same as our basic client  
      //We need to get necessary information from user and send it to server
      //We can then read the result from the server
      
      Scanner scan = new Scanner(System.in);
      
      System.out.println("Enter the first number: ");
      out.writeDouble(scan.nextDouble());
      System.out.println("Enter the second number: ");
      out.writeDouble(scan.nextDouble());
      System.out.println("Enter the operation (1 for add, 2 for subtract): ");
      out.writeInt(scan.nextInt());
      
      boolean success = in.readBoolean();
      double result = in.readDouble();

      if(!success){
        System.out.println("Calculation failed, try again.");
      }else{
        System.out.println("The result of the calculation was: " + result);
      }
      
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