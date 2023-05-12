public class EqualityTester{
  public static void main(String[] args){
   String a = new String("Hello");
   String b = new String("Hello");
   
   String c = "Hello";
   String d = "Hello";
   
   System.out.println("a == b " + (a == b));
   System.out.println("a.equals(b) " + a.equals(b));
   
   System.out.println("a == c " + (a == c));
   System.out.println("a.equals(c) " + a.equals(c));
   
   System.out.println("c == d " + (c == d));
   System.out.println("c.equals(d) " + c.equals(d));
   
  }  
}