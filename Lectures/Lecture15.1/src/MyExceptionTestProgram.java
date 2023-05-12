import java.util.Scanner;
public class MyExceptionTestProgram {
  public static void main(String[] args) {
    String name = "";
    boolean gotValidName = false;
    Scanner keyboard = new Scanner(System.in);
    
    while (!gotValidName) {
      System.out.println("Enter your name");
      name = keyboard.nextLine();
      if (name.length() > 0)
        gotValidName = true;
      else{
        //
        System.out.println("Error: Name must not be blank");
      }
    }
    
    System.out.println("Hello " + name);
  }
} 