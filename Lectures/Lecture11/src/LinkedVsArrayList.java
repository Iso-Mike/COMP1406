import java.util.*;
import java.time.*;

public class LinkedVsArrayList{
  public static void main(String[] args){
    List linked = new LinkedList();
    List array = new ArrayList();

    /*
    thousands of lines of code
    across many different classes
    that are allworking with allOfOurData
     */

    int size = 10000;
    int repeats = 100;
    
    Instant linkedStart = Instant.now();
    addRemoveTest(linked, size, repeats);
    Instant linkedEnd = Instant.now();
    
    Instant arrayStart = Instant.now();
    addRemoveTest(array, size, repeats);
    Instant arrayEnd = Instant.now();
    
    System.out.println("Adding to end and removing from start:");
    System.out.println("LinkedList: " + Duration.between(linkedStart, linkedEnd).getNano());
    System.out.println(" ArrayList: " + Duration.between(arrayStart, arrayEnd).getNano());
    
    linkedStart = Instant.now();
    accessTest(linked, size, repeats);
    linkedEnd = Instant.now();
    
    arrayStart = Instant.now();
    accessTest(array, size, repeats);
    arrayEnd = Instant.now();
    
    System.out.println("Adding to end and accessing all elements:");
    System.out.println("LinkedList: " + Duration.between(linkedStart, linkedEnd).getNano());
    System.out.println(" ArrayList: " + Duration.between(arrayStart, arrayEnd).getNano());
  }  
  
  //Repeatedly adds items to end of list and then removes front until empty
  public static void addRemoveTest(List list, int size, int repeats){
    for(int repeat = 0; repeat < repeats; repeat++){
      for(int i = 0; i < size; i++){
        list.add(i);
      }
      while(!list.isEmpty()){
        list.remove(0);
      }
    }
  }
  
  //Builds a list once, repeatedly access all elements of list
  public static void accessTest(List list, int size, int repeats){
    for(int i = 0; i < size; i++){
      list.add(i);
    }
    
    for(int repeat = 0; repeat < repeats; repeat++){
      for(int i = 0; i < size; i++){
        list.get(i);
      }
    }
  }
}