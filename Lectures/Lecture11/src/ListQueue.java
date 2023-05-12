import java.util.LinkedList;
import java.util.List;
public class ListQueue implements QueueInterface{
  private List data;

  public ListQueue(){
    data = new LinkedList();
  }

  //Adds the given object to the end of the queue
  public void add(Object o){
    data.add(o);
  }

  //Removes and returns the first object in the queue
  public Object remove(){
    if(data.size() > 0){
      return data.remove(0);
    }
    return null;
  }

  //Returns the first object in the queue
  public Object peek(){
    if(data.size() > 0){
      return data.get(0);
    }
    return null;
  }

  //Returns the number of elements in the queue
  public int size(){
    return data.size();
  }

  //True if the queue is empty, false otherwise
  public boolean isEmpty(){
    return data.isEmpty();
  }

  //Removes all items from the queue
  public void clear(){
    data.clear();
  }


}