import java.net.*;
import java.io.*;
public class DistributedServer{
  public static int SERVER_PORT = 5000;
  
  public static void main(String[] args){
    SyncQueue queue = new SyncQueue();
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
        new DistributedServerThread(aClientSocket, queue).start();
        
        //Potential extension: have the socket communicate what TYPE of client is connected
        //Start the corresponding type of thread
        
      }
    }
    catch(IOException e) {
      System.out.println("Cannot connect to client");
    }  
  }  
}