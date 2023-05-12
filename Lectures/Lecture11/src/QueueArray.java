public class QueueArray implements QueueInterface{
  static final int MAX_SIZE = 500;
  Object[] q;
  int curItems;

  public QueueArray(){
    q = new Object[MAX_SIZE];
    curItems = 0;
  }

  public void add(Object o){
    if(curItems < MAX_SIZE){
      q[curItems] = o;
      curItems++;
    }
  }

  public Object remove(){
    Object result = null;
    if(curItems > 0){
      result = q[0];
      for(int i = 1; i < curItems; i++){
        q[i-1] = q[i];
      }
      q[curItems] = null;
      curItems--;
    }
    return result;
  }

  public Object peek(){
    if(curItems > 0){
      return q[0];
    }
    return null;
  }

  public int size(){
    return curItems;
  }

  public boolean isEmpty(){
    return curItems == 0;
  }

  public void clear(){
    curItems = 0;
  }

  public void print(){
    if(curItems > 0){
      String result = "[";
      for(int i = 0; i < curItems-1; i++){
        result += q[i] + ", ";
      }
      result += q[curItems-1] + "]";
      System.out.println(result);
    }else{
      System.out.println("[]");
    }
  }

  public static void main(String[] args){
    QueueArray a = new QueueArray();
    for(int i = 0 ; i < 10; i++){
      a.add(i);
    }
    a.print();
    while(!a.isEmpty()){
      a.remove();
      a.print();
      System.out.println(a.peek());
    }

  }
}