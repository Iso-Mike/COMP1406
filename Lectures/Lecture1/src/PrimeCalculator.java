public class PrimeCalculator {
    public static void main(String[] args){
        //We need a way to determine if a number of prime
        //We will print out the prime numbers from 2-100

        for(int i = 2; i <= 100; i++){
            System.out.println(i + " is prime? " + isPrime(i));
        }
    }

    //Returns true if x is prime and false otherwise
    public static boolean isPrime(int x){
        if(x < 2){
            return false;
        }

        for(int i = 2; i < x; i++){
            if(x % i == 0){
                return false;
            }
        }

        return true;
    }
}
