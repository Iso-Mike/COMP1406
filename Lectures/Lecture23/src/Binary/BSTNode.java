package Binary;

public class BSTNode{
  private int data;
  private BSTNode leftChild;
  private BSTNode rightChild;
  private int subtreeSum;
  
  // A constructor that takes data only and
  // makes a tree with no children (i.e., a leaf)
  public BSTNode(int d) {
    data = d;
    leftChild = null;
    rightChild = null;
    subtreeSum = 0;
  }
  
  // A constructor that takes data as well as two nodes
  // which then become children to this new node.
  public BSTNode(int d, BSTNode left, BSTNode right) {
    data = d;
    leftChild = left;
    rightChild = right;
  }
  
  // Get methods
  public int getData() { return data; }
  public BSTNode getLeftChild() { return leftChild; }
  public BSTNode getRightChild() { return rightChild; }
  
  // Set methods
  public void setData(int d) { data = d; }
  public void setLeftChild(BSTNode left) { leftChild = left; }
  public void setRightChild(BSTNode right) { rightChild = right; }
}