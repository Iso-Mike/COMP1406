public class PrintingThreadTest{
  public static void main(String[] args){
    Thread[] threads = new Thread[10];
    for(int i = 0; i < threads.length; i++){
      threads[i] = new PrintingThread("Thread #" + i);
      threads[i].start();
    }
    
    for(int i = 0; i < threads.length; i++){
      try{
        threads[i].join();
      }catch(InterruptedException e){
        e.printStackTrace();
      }
    }
  }
}