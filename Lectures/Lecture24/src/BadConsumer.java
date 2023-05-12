public class BadConsumer extends Thread{
  private BadSyncQueue q;
  private int num;
  
  public BadConsumer(BadSyncQueue iq, int cNum){
    q = iq;
    num = cNum;
  }
  
  public void run(){
    while(true){
      
      
      try{
        Job j = q.getJob();
        while(j == null){
          j = q.getJob();
          System.out.println("Retrying");
        }
        
        
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