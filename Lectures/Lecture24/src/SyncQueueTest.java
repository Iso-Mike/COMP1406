import java.util.*;
public class SyncQueueTest{
  public static void main(String[] args){
    int numProducers = 3;
    int numConsumers = 6;
    SyncQueue q = new SyncQueue();
    //BadSyncQueue q = new BadSyncQueue();
    
    ArrayList<Thread> threads = new ArrayList<Thread>();
    for(int i = 0; i < numProducers; i++){
      threads.add(new Producer(q, i));
    }
    
    for(int i = 0; i < numConsumers; i++){
      threads.add(new Consumer(q, i));
    }
    
    for(Thread t: threads){
      t.start();
    }
    
    for(Thread t: threads){
      try{
        t.join();
      }catch(Exception e){
        System.out.println(t + " was interrupted.");
      }
    }
  }  
}