import java.net.*;
import java.io.*;
public class ServerThread extends Thread{
  private Socket socket;
  
  public ServerThread(Socket sock){
    socket = sock;
  }
  
  public void run(){
    try{
      DataInputStream in = new DataInputStream(socket.getInputStream());
      DataOutputStream out = new DataOutputStream(socket.getOutputStream());
      
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
      
      
      
      socket.close();
    }catch(Exception e){
      e.printStackTrace();
    }
  }
}