import java.util.LinkedList;
import java.util.List;

public class ListStack implements StackInterface{
  private List data;

  public ListStack(){
    data = new LinkedList();
  }

  public void push(Object o){
    data.add(o);
  }

  public Object pop(){
    return data.remove(data.size() - 1);
  }

  public Object peek(){
    return data.get(data.size() - 1);
  }

  public int size(){
    return data.size();
  }

  public boolean isEmpty(){
    return data.size() == 0;
  }

  public void clear(){
    data.clear();
  }

  public static void main(String[] args){
    ListStack s = new ListStack();
    for(int i = 0; i < 10; i++){
      s.push(i);
      System.out.println(s.data);
    }

    while(!s.isEmpty()){
      System.out.println(s.pop());
      System.out.println(s.data);
    }
  }

}