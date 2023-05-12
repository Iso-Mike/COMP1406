package Binary;

public class BinaryTreeTest2 {
  public static void main(String[] args) {
    BinaryTree2 root;
    root = new BinaryTree2("A",
                           new BinaryTree2("B",
                                           new BinaryTree2("C",
                                                           new BinaryTree2("D"),
                                                           new BinaryTree2("E",
                                                                           new BinaryTree2("F",
                                                                                           new BinaryTree2("G"),
                                                                                           new BinaryTree2("I")),
                                                                           new BinaryTree2("H"))),
                                           new BinaryTree2("J",
                                                           new BinaryTree2("K",
                                                                           new BinaryTree2(),
                                                                           new BinaryTree2("L",
                                                                                           new BinaryTree2(),
                                                                                           new BinaryTree2("M"))),
                                                           new BinaryTree2("N",
                                                                           new BinaryTree2(),
                                                                           new BinaryTree2("O")))),
                           new BinaryTree2("P",
                                           new BinaryTree2("Q"),
                                           new BinaryTree2("R",
                                                           new BinaryTree2("S",
                                                                           new BinaryTree2("T"),
                                                                           new BinaryTree2()),
                                                           new BinaryTree2("U"))));
    System.out.println(root.height());
    System.out.println(root.leafData());
    System.out.println(root.leafData2());
  }
} 