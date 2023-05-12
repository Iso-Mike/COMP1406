package Binary;

import java.util.ArrayList;
public class BinaryTree2 {
  private String data;
  private BinaryTree2 leftChild;
  private BinaryTree2 rightChild;
  // A constructor that makes a Sentinel node
  public BinaryTree2() {
    data = null;
    leftChild = null;
    rightChild = null;
  }
  // This constructor now uses sentinels for terminators instead of null
  public BinaryTree2(String d) {
    data = d;
    leftChild = new BinaryTree2();
    rightChild = new BinaryTree2();
  }
  // This constructor is unchanged
  public BinaryTree2(String d, BinaryTree2 left, BinaryTree2 right) {
    data = d;
    leftChild = left;
    rightChild = right;
  }
  // Get methods
  public String getData() { return data; }
  public BinaryTree2 getLeftChild() { return leftChild; }
  public BinaryTree2 getRightChild() { return rightChild; }
  // Set methods
  public void setData(String d) { data = d; }
  public void setLeftChild(BinaryTree2 left) { leftChild = left; }
  public void setRightChild(BinaryTree2 right) { rightChild = right; }
  
  public int height() {
    // Check if this is a sentinel node
    if (data == null)
      return -1;
    return 1 + Math.max(leftChild.height(),
                        rightChild.height());
  }
  
  public ArrayList<String> leafData() {
    ArrayList<String> result = new ArrayList<String>();
    if (data != null) {
      if ((leftChild.data == null) && (rightChild.data == null))
        result.add(data);
      result.addAll(leftChild.leafData());
      result.addAll(rightChild.leafData());
    }
    return result;
  }

  public ArrayList<String> leafData2(){
   return leafData2(new ArrayList<String>());
  }

  public ArrayList<String> leafData2(ArrayList<String> result) {
    //If it is a sentinel, don't do anything
    if(this.data == null){
      return result;
    }

    //If it is a leaf, add it's data to the result
    if ((leftChild.data == null) && (rightChild.data == null)){
      result.add(data);
    }else {//Otherwise it is not a leaf, get leaf data from left/right subtrees
      leftChild.leafData2(result);
      rightChild.leafData2(result);
    }
    return result;
  }
}