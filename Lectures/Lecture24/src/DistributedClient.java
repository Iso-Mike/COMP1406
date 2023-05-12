import java.net.*;
import java.io.*;
import java.util.*;
public class DistributedClient{
  public static int SERVER_PORT = 5000;
  public static void main(String[] args){
    int numProducers = 5;
    int numConsumers = 5;
    
    ArrayList<Thread> threads = new ArrayList<Thread>();
    for(int i = 0; i < numProducers; i++){
      Thread t = new DistributedProducer(i);
      t.start();
      threads.add(t);
    }
    
    for(int i = 0; i < numConsumers; i++){
      Thread t = new DistributedConsumer(i);
      t.start();
      threads.add(t);
    }
    
    for(Thread t: threads){
      try{
        t.join(); 
      }catch(InterruptedException e){
        
      }
    }
  }
}