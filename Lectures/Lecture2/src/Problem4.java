import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args){
        /*
            Write Java code that allows a user
             to repeatedly enter numbers. Each
             time the user enters a number, the
             program should print out the average
             of the last 4 numbers (or all numbers
             if 4 or less have been entered).

             1. Repeatedly ask the user for a number
             2. Keep track of the average of the last 4 numbers (total, count)
         */

        // Average: 6.25
        //10, 5, 10, 5, 5
        int SIZE = 4;
        //[3, 9, 0, 8]
        // ^

        Scanner in = new Scanner(System.in);

        int index = 0; //the current place in the array that we will add the number
        int counter = 0; //the current count of numbers
        int total = 0;
        int[] numbers = new int[SIZE]; //[10, 0, 0, 0]
        while(true){
            int number = in.nextInt();
            total -= numbers[index];
            numbers[index] = number;
            total += number;
            index++;
            if(counter < 4) {
                counter++;
            }

            if(index == 4){
                index = 0;
            }

            System.out.println("Average is: " + ((double)total/counter));
        }
    }
}
