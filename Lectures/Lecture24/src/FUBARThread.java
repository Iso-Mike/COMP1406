import java.util.*;
public class FUBARThread extends Thread{
  ArrayList<Integer> nums;
  
  public FUBARThread(ArrayList<Integer> n){
    nums = n;
  }
  
  public void run(){
    while(nums.size() > 0){
      nums.remove(0);
    }
  }
  
}