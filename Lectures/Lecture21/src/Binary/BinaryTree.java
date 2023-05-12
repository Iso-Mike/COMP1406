package Binary;

import java.util.ArrayList;
public class BinaryTree {
  private String data;
  private BinaryTree leftChild;
  private BinaryTree rightChild;
  
  // A constructor that takes root data only and
  // makes a tree with no children (i.e., a leaf)
  public BinaryTree(String d) {
    data = d;
    leftChild = null;
    rightChild = null;
  }
  
  // A constructor that takes root data as well as two subtrees
  // which then become children to this new larger tree.
  public BinaryTree(String d, BinaryTree left, BinaryTree right) {
    data = d;
    leftChild = left;
    rightChild = right;
  }
  
  // Get methods
  public String getData() { return data; }
  public BinaryTree getLeftChild() { return leftChild; }
  public BinaryTree getRightChild() { return rightChild; }
  
  // Set methods
  public void setData(String d) { data = d; }
  public void setLeftChild(BinaryTree left) { leftChild = left; }
  public void setRightChild(BinaryTree right) { rightChild = right; }
  
  public int height() {
    if (leftChild == null) {
      if (rightChild == null)
        return 0;
      else
        return 1 + rightChild.height();
    }
    else {
      if (rightChild == null)
        return 1 + leftChild.height();
      else
        return 1 + Math.max(leftChild.height(),
                            rightChild.height());
    }
  } 
  
  public ArrayList<String> leafData() {
    ArrayList<String> result = new ArrayList<String>();
    if (leftChild == null) {
      if (rightChild == null)
        result.add(data);
      else
        result.addAll(rightChild.leafData());
    }
    else {
      result.addAll(leftChild.leafData());
      if (rightChild != null)
        result.addAll(rightChild.leafData());
    }
    return result;
  }
}