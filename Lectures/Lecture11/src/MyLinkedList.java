import java.time.*;

public class MyLinkedList implements ListInterface{
    private Node head;
    private int numItems;

    public MyLinkedList(){
        head = null;
        numItems = 0;
    }

    //Runtime complexity?
    //Adding at front runtime complexity? O(1)
    public void add(int index, Object data){
        Node newNode = new Node(data);
        //if we are adding at the start, or head == null (which means the list is empty)
        if(head == null || index == 0){
            newNode.setNext(head);
            head = newNode;
            numItems++;
            return;
        }

        int curIndex = 0;
        Node curNode = head;
        Node prevNode = null;
        while(curIndex < index && curNode != null){
            prevNode = curNode;
            curNode = curNode.getNext();
            curIndex++;
        }

        newNode.setNext(curNode);
        prevNode.setNext(newNode);
        numItems++;
    }

    //Runtime complexity?
    public void add(Object item){
        add(numItems, item);
    }

    //Runtime complexity?
    public boolean contains(Object data){
        return false;
    }

    //Runtime complexity? O(n)
    //Runtime complexity of removing from front? O(1)
    //What about a remove(Object) method?
    public Object remove(int index){
        if(index >= 0 && index < numItems){
            if(index == 0){
                Object result = head.getData();
                head = head.getNext();
                numItems--;
                return result;
            }

            int curIndex = 0;
            Node curNode = head;
            Node prevNode = null;

            while(curIndex < index && curNode != null){
                prevNode = curNode;
                curNode = curNode.getNext();
                curIndex++;
            }

            prevNode.setNext(curNode.getNext());
            numItems--;
            return curNode.getData();
        }

        return null;
    }

    //Runtime complexity? O(n)
    public void set(int index, Object data){

    }

    //Runtime complexity? O(n)
    public Object get(int index){
        return null;
    }

    public int size(){
        return numItems;
    }


    public void clear(){
        head = null;
        numItems--;
    }

    public boolean isEmpty(){
        return head == null;
    }
  
    public void print(){
      Node cur = head;
      
      String result = "[";
      while(cur != null){
       result += cur.getData();
       cur = cur.getNext();
       if(cur != null){
        result += ", "; 
       }
      }
      result += "]";
      System.out.println(result);
    }

    public static void main(String[] args){
        MyLinkedList l = new MyLinkedList();

        for(int i = 0 ; i < 10; i++){
            l.add(i,i);
            l.print();
        }
        l.add(10);
        l.print();
        l.add(0, -1);
        l.print();
        l.add(5, -5);
        l.print();

        l.remove(0);
        l.print();
        l.remove(3);
        l.print();

        while(!l.isEmpty()){
            l.remove(0);
            l.print();
        }

        if(true)System.exit(1);

        l.add(-1, -1);
        l.print();
        System.out.println("Is empty?: " + l.isEmpty());
        System.out.println("Size: " + l.size());
        l.add(50,50);
        l.print();
        System.out.println("Is empty?: " + l.isEmpty());
        System.out.println("Size: " + l.size());

        l.remove(0);
        l.print();
        System.out.println("Is empty?: " + l.isEmpty());
        System.out.println("Size: " + l.size());
        l.remove(10);
        l.print();
        System.out.println("Is empty?: " + l.isEmpty());
        System.out.println("Size: " + l.size());
        l.remove(4);
        l.print();
        System.out.println("Is empty?: " + l.isEmpty());
        System.out.println("Size: " + l.size());

        while(!l.isEmpty()){
            l.remove(0);
            l.print();
        }

    }
}