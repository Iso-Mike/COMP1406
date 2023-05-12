package Linked;
public class LinkedList{
  Item head;
  Item tail;
  
  public LinkedList() {
    head = null;
    tail = null;
  }
  
  // Add an item to the end of the list
  public void add(Item x) {
    if (tail == null) {
      tail = x;
      head = x;
    }
    else {
      tail.next = x;
      x.previous = tail;
      tail = x;
    }
  }
  
  // Remove the given item from the list
  public void remove(Item x) {
    if (x == head) {
      if (x == tail) {
        head = tail = null;
      }
      else {
        head = x.next;
        head.previous = null;
      }
    }
    else {
      if (x == tail) {
        tail = x.previous;
        tail.next = null;
      }
      else {
        x.previous.next = x.next;
        x.next.previous = x.previous;
      }
    }
  }
  
  // Return a string representation of the list
  public String toString() {
    if (head == null)
      return "[EMPTY]";
    
    String s = "[H:";
    Item currentItem = head;
    while (currentItem != null) {
      s += currentItem.data;
      if (currentItem != tail)
        s += "]<==>[";
      currentItem = currentItem.next;
    }
    return s + ":T]";
  }
  
  // Add up the total data in the list
  public int totalData() {
    return totalData(head);
  }
  
  private int totalData(Item curNode){
    //If we are at the end of the list
    if(curNode == null){
      return 0; //stop or return the default value
    }

    //Do our processing (add the current node's data)
    int thisNodeData = curNode.getData();
    //Recursively operate on the next node
    return thisNodeData + totalData(curNode.getNext());
  }
  
  public LinkedList getOddValues(){
    //new LinkedList -> a memory reference
    LinkedList result = new LinkedList();
    return getOddValues(head, result);
  }
  
  public LinkedList getOddValues(Item curHead, LinkedList result){
    //Go through each node
    //If the node is an odd number
    //Add that node to the result

    //base case
    if(curHead == null){
      return result;
    }
    //recursive step
    if(curHead.getData() % 2 == 1){ //odd number
      result.add(new Item(curHead.getData()));
      //result.add(curHead);
    }
    return getOddValues(curHead.getNext(), result);
  }

  public boolean contains(byte b){
    return contains(head, b);
  }
  
  private boolean contains(Item curHead, byte b){
    if(curHead == null){
      return false;
    }

    if(curHead.getData() == b){
      return true;
    }

    return contains(curHead.getNext(), b);
  }

  //In Common:
  //Set startItem to head of one of lists list
  //if head isn't null, check if the value exists in other list
  //if it does, add it to a result, otherwise do not
  //'Remove' head and repeat

  public LinkedList inCommon(LinkedList otherList){
    return inCommon(head, otherList, new LinkedList());
  }

  private LinkedList inCommon(Item curHead, LinkedList otherList, LinkedList result){
    if(curHead == null){
      return result;
    }

    if(otherList.contains(curHead.getData())){
      result.add(new Item(curHead.getData()));
    }

    return inCommon(curHead.getNext(), otherList, result);
  }
  
  public static void main(String[] args){
    LinkedList list = new LinkedList();
    list.add(new Item(23));
    list.add(new Item(65));
    list.add(new Item(87));
    list.add(new Item(45));
    list.add(new Item(56));
    list.add(new Item(34));
    list.add(new Item(95));
    list.add(new Item(71)); //476?
    
    System.out.println(list.totalData());
    System.out.println(list);
    System.out.println(list.getOddValues());
    System.out.println(list);
   
    LinkedList list2 = new LinkedList();
    list2.add(new Item(45));
    list2.add(new Item(76));
    list2.add(new Item(23));
    list2.add(new Item(14));
    list2.add(new Item(98));
    list2.add(new Item(21));
    list2.add(new Item(95));
    System.out.println(list.inCommon(list2));
    System.out.println(list2.inCommon(list));
    System.out.println(list);
  }
}