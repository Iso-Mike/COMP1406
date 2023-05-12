import java.util.*;
public class BadSyncQueue extends SyncQueue{
  private ArrayList<Job> jobs;
  
  public BadSyncQueue(){
    jobs = new ArrayList<Job>();
  }
  
  public synchronized void addJob(Job j){
      jobs.add(j);
      System.out.println("Adding job, queue now: " + jobs);
  }
  
  public synchronized Job getJob(){
    
    
    if(jobs.isEmpty()){
      return null;
      //System.out.println("Consumer waiting.");
    }
    
    
    Job j = jobs.remove(0);
    System.out.println("Removed " + j + ", queue now: " + jobs);
    return j;
  }
  
  
  
}