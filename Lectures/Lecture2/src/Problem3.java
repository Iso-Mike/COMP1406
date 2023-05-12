import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args){
        /*
            Write Java code that will repeatedly
             read numbers from the user until a
             negative number is entered. When a
             negative number is entered, the code
             should print out the total and average
             of all non-negative values entered by
             the user and then stop.

             1. We need a way to repeatedly read numbers until a negative is entered.
             2. Compute the total and average (sum and count)
         */

        Scanner in = new Scanner(System.in);

        int number = in.nextInt();
        int sum = 0;
        int count = 0;

        while(number >= 0){
            //do SOMETHING
            sum += number;
            count++;

            number = in.nextInt();
        }

        System.out.println("Sum: " + sum); //15
        System.out.println("Avg: " + ((float)sum/count));//7.5
    }
}
