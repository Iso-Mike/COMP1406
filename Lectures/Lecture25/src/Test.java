public class Test{
  static boolean debug = false;
  
  public static void main(String[] args){
    log("OH NO");
    log("Is htis right.");
    log("Oh no again.");
  }
  
  public static void log(String s){
    if(debug){
      System.out.println(s);
    }
  }
  
}