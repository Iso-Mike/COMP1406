import java.net.*;
import java.io.*;
public class Server{
  public static int SERVER_PORT = 5000;
  
  public static void main(String[] args){
    //Create a server socket
    ServerSocket serverSocket = null;
    try {
      serverSocket = new ServerSocket(SERVER_PORT);
    }
    catch(IOException e) {
      System.out.println("Cannot open server connection");
    } 
    
    //Start listening for connection and create socket connection with client
    Socket aClientSocket;
    try {
      aClientSocket = serverSocket.accept();
      
      //Open the streams
      InputStream in = aClientSocket.getInputStream();
      OutputStream out = aClientSocket.getOutputStream();
      
      
      //Do processing
      System.out.println("Connected to client!");
      
      
      //Close socket
      aClientSocket.close();
    }
    catch(IOException e) {
      System.out.println("Cannot connect to client");
    }  
  }  
}