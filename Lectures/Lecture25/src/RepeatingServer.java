import java.net.*;
import java.io.*;
public class RepeatingServer{
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
      //Everything else is the same, except we repeatedly listen/accept connect
      //and handle a request (in this case, print to console)
      while(true){
        aClientSocket = serverSocket.accept();
        
        InputStream in = aClientSocket.getInputStream();
        OutputStream out = aClientSocket.getOutputStream();
        System.out.println("Connected to client!");
        
        aClientSocket.close();
      }
    }
    catch(IOException e) {
      System.out.println("Cannot connect to client");
    }  
  }  
}