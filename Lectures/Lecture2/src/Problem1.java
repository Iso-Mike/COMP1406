import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args){
        /*
            Write Java code that asks the user to enter
            two numbers and prints out the largest of
            the two numbers.
         */

        Scanner in = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int first = in.nextInt();
        System.out.print("Enter the second number: ");
        int second = in.nextInt();

        if(first > second){
            System.out.println(first + " is largest");
        }else if(second > first){
            System.out.println(second + " is largest");
        }else{
            System.out.println("They're the same.");
        }

    }
}
