public class Producer extends Thread{
  private SyncQueue q;
  private static String[] jobNames = {"Add things", "Subtract things", "Do recursion", "Search tree", "Contemplate"};
  private int num;
  private int maxLength = 10000;
  private int createJobs = 5;
  
  public Producer(SyncQueue iq, int pNum){
    q = iq;
    num = pNum;
  }
  
  public void run(){
    for(int i = 0; i < createJobs; i++){
      String name = jobNames[(int)(Math.random()*jobNames.length)];
      int time = (int)(Math.random() * maxLength);
      q.addJob(new Job(name, time));
      System.out.println("Producer #" + num + " added a job.");
      try{
        sleep((int)(Math.random() * maxLength));
      }catch(InterruptedException e){
        System.out.println("Producer #" + num + " interrupted.");
        return;
      }
    }
  }
  
  public String toString(){
    return "Producer #" + num;
  }
}