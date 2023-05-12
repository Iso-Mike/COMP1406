import java.util.*;

public class FUBAR{
  public static void main(String[] args){
    ArrayList<Integer> list = new ArrayList<Integer>();
    for(int i = 0; i < 383888; i++){
      list.add(new Integer(i));
    }
    
    ArrayList<Thread> threads = new ArrayList<Thread>();
    for(int i = 0; i < 25; i++){
      threads.add(new FUBARThread(list));
    }
    
    for(Thread t: threads){
      t.start();
    }
    
    for(Thread t: threads){
      try{
        t.join();
      }catch(InterruptedException e){
        e.printStackTrace();
      }
    }
  }
}