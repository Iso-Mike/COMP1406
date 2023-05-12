public class Consumer extends Thread{
  private SyncQueue q;
  private int num;
  
  public Consumer(SyncQueue iq, int cNum){
    q = iq;
    num = cNum;
  }
  
  public void run(){
    while(true){
      try{
        Job j = q.getJob();
        System.out.println("Consumer #" + num + " processing job: " + j.getName());
        sleep(j.getLength());
      }catch(InterruptedException e){
        System.out.println("Consumer #" + num + " interrupted.");
        return;
      }
    }
  }
  
  public String toString(){
    return "Consumer #" + num;
  }
  
}