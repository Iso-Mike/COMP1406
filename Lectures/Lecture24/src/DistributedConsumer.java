import java.net.*;
import java.io.*;
public class DistributedConsumer extends Thread{
  private static String[] jobNames = {"Add things", "Subtract things", "Do recursion", "Search tree", "Contemplate"};
  private int num;
  private int maxLength = 10000;
  
  public DistributedConsumer(int n){
    num = n;
  }
  
  public void run(){
    try {
      InetAddress address = InetAddress.getLocalHost();
      Socket socket = new Socket(address, DistributedServer.SERVER_PORT);
      ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
       
      while(true){
        try{
          out.writeByte(DistributedServerThread.GETJOB);
          out.flush();
          Job j = (Job)in.readObject();
          System.out.println("Consumer #" + num + " processing job: " + j.getName());
          sleep(j.getLength());
        }catch(InterruptedException e){
          System.out.println("Consumer #" + num + " interrupted."); 
          break;
        }catch(ClassNotFoundException e){
          System.out.println("Class error.");
          break;
        }
      }
      socket.close();
    }catch(UnknownHostException e) {
      System.out.println("Host Unknown");
    }
    catch(IOException e) {
      System.out.println("Cannot connect to server");
    } 
  }
}