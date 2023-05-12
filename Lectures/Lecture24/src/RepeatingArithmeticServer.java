import java.net.*;
import java.io.*;
public class RepeatingArithmeticServer{
  public static int SERVER_PORT = 5000;
  
  public static void main(String[] args){
    ServerSocket serverSocket = null;
    try {
      serverSocket = new ServerSocket(SERVER_PORT);
    }
    catch(IOException e) {
      System.out.println("Cannot open server connection");
    } 
    
    Socket aClientSocket;
    try {
      while(true){
        aClientSocket = serverSocket.accept();
        
        try{
          DataInputStream in = new DataInputStream(aClientSocket.getInputStream());
          DataOutputStream out = new DataOutputStream(aClientSocket.getOutputStream());
          
          //Everything else is the same as the repeating server
          //We just need to add handling for an actual request following our protocol
          double x = in.readDouble();
          double y = in.readDouble();
          int op = in.readInt();
          
          boolean success = false;
          double result = 0.0;
          if(op == 1){
            result = x + y;
            success = true;
          }else if(op == 2){
            result = x - y;
            success = true;
          }
          
          out.writeBoolean(success);
          out.writeDouble(result);
          
          
          
          aClientSocket.close();
        }catch(Exception e){
          e.printStackTrace();
        }
        
      }
    }
    catch(IOException e) {
      System.out.println("Cannot connect to client");
    }  
  }  
}