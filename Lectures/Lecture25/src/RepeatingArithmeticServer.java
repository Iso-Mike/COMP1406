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
        
        DataInputStream in = new DataInputStream(aClientSocket.getInputStream());
        DataOutputStream out = new DataOutputStream(aClientSocket.getOutputStream());
        
        
        //Everything else is the same as the repeating server
        //We just need to add handling for an actual request following our protocol
        int x = in.readInt();
        int y = in.readInt();
        int op = in.readInt();
        
        int result = 0;
        if(op == 0){
          result = x + y;
        }else{
          result = x - y;
        }
        out.writeInt(result);
        
        
        
        aClientSocket.close();
      }
    }
    catch(IOException e) {
      System.out.println("Cannot connect to client");
    }  
  }  
}