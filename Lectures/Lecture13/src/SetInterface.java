import java.util.List;

public interface SetInterface{
  void add(Object o);
  boolean contains(Object o);
  Object get(Object o);
  void remove(Object o);
  boolean isEmpty(Object o);
  int size();
  void clear();
  List getItems();
  void print();
}