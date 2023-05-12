package MVC;

public class GroceryList{
  private String[] items;
  private final int MAX_ITEMS = 100;
  private int curItems;
  
  //Create a new grocery list
  public GroceryList(){
    items = new String[MAX_ITEMS];
    curItems = 0;
  }
  
  //Get the items array, removing any null values
  public String[] getItems(){
    if(curItems <= 0){
      return new String[0];
    }
    
    String[] temp = new String[curItems];
    for(int i = 0; i < temp.length; i++){
      temp[i] = items[i];
    }
    return temp;
  }
  
  //Removes the item at index, if it is valid
  //Shifts other items to fill the gap
  public void removeItem(int index){
    if(index >= 0 && index < curItems){
      items[index] = null;
      for(int i = index + 1; i < curItems; i++){
       String temp = items[i-1];
       items[i-1] = items[i];
       items[i] = temp;
      }
      curItems--;
    }
  }
  
  //Adds an item to the list
  public void addItem(String item){
    if(curItems < MAX_ITEMS){
      items[curItems] = item;
      curItems++;
    }
  }
}