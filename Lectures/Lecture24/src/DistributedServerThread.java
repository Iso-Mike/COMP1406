import java.net.*;
import java.io.*;
public class DistributedServerThread extends Thread{
  private Socket socket;
  private SyncQueue queue;
  public static final byte ADDJOB = 0;
  public static final byte GETJOB = 1;
  public static final byte QUIT = 2;
  
  
  public DistributedServerThread(Socket sock, SyncQueue q){
    socket = sock;
    queue = q;
  }
  
  public void run(){
    try{
      //open streams
      ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
      ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
      
      //repeatedly read a byte and handle client request 
      byte operation = in.readByte();
      while(operation == ADDJOB || operation == GETJOB){
        if(operation == ADDJOB){
          Job j = (Job)in.readObject();
          queue.addJob(j);
        }else{
          Job j = queue.getJob();
          out.writeObject(j);
        }
        operation = in.readByte();
      }
      out.close();
      in.close();
      socket.close();
    }catch(Exception e){
      e.printStackTrace();
    }
  }
}