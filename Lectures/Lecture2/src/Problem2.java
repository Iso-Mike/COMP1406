import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args){
        /*
            Write Java code that reads three numbers
             from the user and prints out the largest
              of the three numbers.
         */

        Scanner in = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int first = in.nextInt();
        System.out.print("Enter the second number: ");
        int second = in.nextInt();
        System.out.print("Enter the third number: ");
        int third = in.nextInt();

        if(first > second && first > third){
            System.out.println(first + " is largest");
        }else if(second > first && second > third) {
            System.out.println(second + " is largest");
        }else if(third > first && third > second){
            System.out.println(third + " is largest");
        }else{
            System.out.println("They're the same.");
        }
    }
}
