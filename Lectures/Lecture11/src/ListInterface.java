public interface ListInterface{
  //Adds the given Object at the given index
  //Any objects at index or later should be moved 1 later
  void add(int index, Object data);

  //Adds the given object at the end of the list
  void add(Object data);
  
  //Removes and returns the object at given index
  //Objects later than index should be moved 1 earlier
  Object remove(int index);
  
  //Sets the object at index to be the specified Object
  void set(int index, Object data);
  
  //Returns the object at the given index
  Object get(int index);

  //Returns true if the given Object exists in the list
  boolean contains(Object data);
  
  //Returns the number of elements in the list
  int size();

  //Removes all items from the list
  void clear();
  
  //Returns true if no items in the list, false otherwise
  boolean isEmpty();  
}