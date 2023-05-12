import java.util.*;
public class DistributedProducerCreator{
  public static void main(String[] args){
    int numProducers = 5;
    ArrayList<Thread> threads = new ArrayList<Thread>();
    for(int i = 0; i < numProducers; i++){
      Thread t = new DistributedProducer(i);
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