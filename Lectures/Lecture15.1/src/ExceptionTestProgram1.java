import java.util.Scanner;
import java.util.InputMismatchException;
public class ExceptionTestProgram1 {
  public static void main(String[] args) {
    int number1, number2, result;
    Scanner keyboard;
    keyboard = new Scanner(System.in);
    boolean success = false;
    while(!success){
      success = true;
      try {
        System.out.println("Enter the first number:");
        number1 = keyboard.nextInt();

        System.out.println("Enter the second number:");
        number2 = keyboard.nextInt();

        result = number1 / number2;
        System.out.print(number2 + " goes into " + number1);
        System.out.print(" this many times: ");
        System.out.println(result);
      } catch (ArithmeticException e) {
        System.out.println("You can't divide by 0. Try again.");
        success = false;
        keyboard = new Scanner(System.in);
      } catch (InputMismatchException e) {
        System.out.println("You didn't enter an integer. Try again.");
        success = false;
        keyboard = new Scanner(System.in);
      }
    }
  }
} 