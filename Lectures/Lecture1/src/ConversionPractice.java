import java.util.Scanner;

public class ConversionPractice {
    public static void main(String[] args){
        /*
        Convert some number of miles entered by the user into
        some number of kilometers
         */

        //1. Read a number of miles from the user
        //2. km = 1.6 * number of miles
        //3. Print out the number of kilometers
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of miles: ");
        float miles = in.nextFloat();
        float kms = 1.6f * miles;
        System.out.println(miles + " miles is equal to " + kms + " kilometers");
    }
}
