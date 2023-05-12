import java.net.*;
import java.io.*;
public class MultiThreadArithmeticServer{
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
        new ServerThread(aClientSocket).start();
      }
    }
    catch(IOException e) {
      System.out.println("Cannot connect to client");
    }  
  }  
}