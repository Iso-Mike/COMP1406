import java.net.*;
import java.io.*;
public class DistributedProducer extends Thread{
  private static String[] jobNames = {"Add things", "Subtract things", "Do recursion", "Search tree", "Contemplate"};
  private int num;
  private int maxLength = 10000;
  private int jobsToCreate = 3;
  
  public DistributedProducer(int n){
    num = n;
  }
  
  public void run(){
    try {
      InetAddress address = InetAddress.getLocalHost();
      Socket socket = new Socket(address, DistributedServer.SERVER_PORT);
      ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
      
      for(int i = 0; i < jobsToCreate; i++){
        String name = jobNames[(int)(Math.random()*jobNames.length)];
        int time = (int)(Math.random() * maxLength);
        Job j = new Job(name, time);
        out.writeByte(DistributedServerThread.ADDJOB);
        out.flush();
        out.writeObject(j);
        System.out.println("Producer #" + num + " added a new job.");        
        try{
          sleep((int)(Math.random() * maxLength));
        }catch(InterruptedException e){
          System.out.println("Producer #" + num + " interrupted.");
        }
      }
      out.writeByte(DistributedServerThread.QUIT);
      out.flush();
      in.close();
      out.close();
      socket.close();
    }catch(UnknownHostException e) {
      System.out.println("Host Unknown");
    }
    catch(IOException e) {
      System.out.println("Cannot connect to server");
    } 
  }
}