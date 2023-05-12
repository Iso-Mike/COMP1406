import java.util.*;
public class SyncQueue{
  private ArrayList<Job> jobs;
  
  public SyncQueue(){
    jobs = new ArrayList<Job>();
  }
  
  public synchronized void addJob(Job j){
      jobs.add(j);
      System.out.println("Adding job, queue now: " + jobs);
      notifyAll();
  }
  
  public synchronized Job getJob(){
    while(jobs.isEmpty()){
      try{
        wait();
      }catch(InterruptedException e){
        return null;
      }
    }
    Job j = jobs.remove(0);
    System.out.println("Removed " + j + ", queue now: " + jobs);
    return j;
  }
  
  
  
}