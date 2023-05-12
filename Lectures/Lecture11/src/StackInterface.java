public interface StackInterface{
  //Adds the given object to the top of the stack
  void push(Object o);
  
  //Removes and returns the top object from the stack
  Object pop();
  
  //Returns the top object from the stack
  Object peek();
  
  //Returns the number of items on the stack
  int size();
  
  //Returns true if the stack is empty (no items), false otherwise
  boolean isEmpty();
  
  //removes all items from the stack
  void clear();
}