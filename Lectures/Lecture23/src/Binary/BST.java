package Binary;

import java.util.*;
public class BST{
 BSTNode root;
 
 public BST(){
  root = null; 
 }
 
 public void add(BSTNode node){
   if(root == null){
     root = node;
     return;
   }
   add(node, root);
   return;
 }
 
 public void add(BSTNode newNode, BSTNode root){
   if(newNode.getData() < root.getData()){
     if(root.getLeftChild() == null){
      root.setLeftChild(newNode); 
      return;
     }else{
       add(newNode, root.getLeftChild());
       return;
     }
   }else if(newNode.getData() > root.getData()){
     if(root.getRightChild() == null){
       root.setRightChild(newNode);
       return;
     }else{
       add(newNode, root.getRightChild());
     }
   }else{
     return;
   }
 }
 
 public void remove(int value){
   remove(root, value, root);
 }
 
 public boolean remove(BSTNode current, int value, BSTNode parent){
   if(current == null){
     return false;
   }
   
   System.out.println(value + " removing with current data " + current.getData());
   
   if(value < current.getData()){
     return remove(current.getLeftChild(), value, current);
   }else if(value > current.getData()){
     return remove(current.getRightChild(), value, current);
   }
   System.out.println("Found correct node");
   //the node to remove is a leaf
   if(current.getLeftChild() == null && current.getRightChild() == null){
     System.out.println("Removing leaf");
     //the node to remove is the root
     if(current == root){
       root = null;
       return true;
     }
     //the node to remove is the left child of parent
     if(parent.getLeftChild() != null && current.getData() == parent.getLeftChild().getData()){
       parent.setLeftChild(null);
       return true;
     }else{
       parent.setRightChild(null);
       return true;
     }
   //the node has one child on the left
   }else if(current.getRightChild() == null){
     if(current == root){
       root = current.getLeftChild();
     }else if(parent.getLeftChild() != null && current.getData() == parent.getLeftChild().getData()){
       parent.setLeftChild(current.getLeftChild());
     }else{
       parent.setRightChild(current.getLeftChild());
     }
     return true;
   //the node has one child on the right
   }else if(current.getLeftChild() == null){
     if(current == root){
       root = current.getRightChild();
     }else if(parent.getLeftChild() != null && current.getData() == parent.getLeftChild().getData()){
       parent.setLeftChild(current.getRightChild());
     }else{
       parent.setRightChild(current.getRightChild());
     }
     return true;
   }else{
     //the node has two children, this is the most complex case
     //find the smallest node in the right subtree
     //copy its value to the current node
     //remove the smallest node in the right subtree
     BSTNode successor = getSuccessor(current.getRightChild());
     current.setData(successor.getData());
     remove(current.getRightChild(), successor.getData(), current);
     return true;
   }
 }
 
 public int sum(BSTNode current){
   if(current == null){
     return 0;
   }
   return current.getData() + sum(current.getLeftChild()) + sum(current.getRightChild());
   
 }
 
 public BSTNode getSuccessor(BSTNode current){
   if(current.getLeftChild() != null){
    return getSuccessor(current.getLeftChild()); 
   }
   return current;
 }
 
 public boolean contains(int value){
   return contains(root, value);
 }
 
 public boolean contains(BSTNode root, int value){
   if(root == null){
     return false;
   }
   if(root.getData() == value){
     return true;
   }
   
   if(root.getData() > value){
     return contains(root.getLeftChild(), value);
   }
   
    return contains(root.getRightChild(), value);
 }
 
 public void print(){
   print(root);
 }
 
 public void print(BSTNode root){
   if(root != null){
    print(root.getLeftChild());
    System.out.println(root.getData());
    print(root.getRightChild());
   }
 }
 
 public int sumLessThan(int value){
  return sumLessThan(root, value); 
 }
 
 public int sumLessThan(BSTNode current, int value){
   if(current == null){
     return 0;
   }
   
   if(current.getData() < value){
    return sumLessThan(current.getLeftChild(), value) + current.getData() + sumLessThan(current.getRightChild(), value);
   }else{
     return sumLessThan(current.getLeftChild(), value);
   }
 }
 
 public int sumBetween(int start, int end){
  return sumBetween(root, start, end); 
 }
 
 public int sumBetween(BSTNode current, int start, int end){
   if(current == null){
     return 0;
   }
 
   if(current.getData() < start){
    return sumBetween(current.getRightChild(), start, end); 
   }else if(current.getData() > end){
     return sumBetween(current.getLeftChild(), start, end);
   }else{
    return sumBetween(current.getLeftChild(), start, end) + current.getData() + sumBetween(current.getRightChild(), start, end); 
   }
 }
 
 public static void main(String[] args){
   BST tree = new BST();
   tree.add(new BSTNode(15));
   tree.add(new BSTNode(3));
   tree.add(new BSTNode(18));
   tree.add(new BSTNode(18));
   tree.add(new BSTNode(18));
   tree.add(new BSTNode(18));
   tree.add(new BSTNode(11));
   tree.add(new BSTNode(1));
   tree.add(new BSTNode(2));
   tree.add(new BSTNode(3));
   tree.add(new BSTNode(3));
   tree.add(new BSTNode(3));
   tree.add(new BSTNode(21));
   tree.add(new BSTNode(24));
   tree.print();
   //tree.remove(15);
   //tree.remove(3);
   tree.remove(24);
   tree.print();
   System.out.println(tree.sum(tree.root));
   System.out.println(tree.sumLessThan(25));
   System.out.println(tree.sumBetween(6,17));
   if(true)return;
   
   
   System.out.println(tree.contains(15));
   System.out.println(tree.contains(3));
   System.out.println(tree.contains(17));
   System.out.println(tree.contains(25));
   System.out.println(tree.contains(0));
   System.out.println(tree.contains(24));
   
   Random rand = new Random();
   tree = new BST();
   HashSet<Integer> nums = new HashSet<Integer>();
   for(int i = 0; i < 10000; i++){
     int num = rand.nextInt(30000);
     nums.add(num);
     tree.add(new BSTNode(num));
   }
   
   for(int i = 0; i < 1000000; i++){
    int num = rand.nextInt(30000);
    if(nums.contains(num) != tree.contains(num)){
      System.out.println("Error");
    }
   }
   System.out.println("Done.");
 }
}