import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class ArrayListSet implements SetInterface{
  private List data;
  
  public ArrayListSet(){
    data = new ArrayList();
  }

  //O(n) operation
  public void add(Object o){
    if(!data.contains(o)){
      data.add(o);
    }
  }

  //O(n)
  public boolean contains(Object o){
    return data.contains(o);
  }

  //O(n)
  public void remove(Object o){
    data.remove(o);
  }

  //O(1)
  public boolean isEmpty(Object o){
    return data.size() == 0;
  }

  //O(1)
  public int size(){
    return data.size();
  }

  //O(1)
  public void clear(){
    data.clear();
  }

  //We can ignore this method
  //It was needed for a later example where the Map interface is implemented
  public Object get(Object o) {
    for(Object other: data){
      if(other.equals(o)){
        return other;
      }
    }
    return null;
  }

  //We can ignore this method
  //It was needed for a later example where the Map interface is implemented
  public List getItems() {
    return data;
  }

  public void print(){
    System.out.println("Here are the items in the set:");
    for(Object o: data){
      System.out.println(o);
    }
    System.out.println();
    System.out.println();
  }
  
  public static void main(String[] args) {
    SetInterface s = new HashBasedSet();
    Random rand = new Random();
    String[] words = {"Hello", "how", "are", "you"};
    for (int i = 0; i < 100; i++) {
      s.add(words[rand.nextInt(words.length)]);
    }
    s.print();
    System.out.println(s.contains("how"));
    System.out.println(s.contains("Hello"));
    System.out.println(s.contains("hello"));
    s.remove("how");
    s.print();
    System.out.println(s.contains("how"));
  }
}