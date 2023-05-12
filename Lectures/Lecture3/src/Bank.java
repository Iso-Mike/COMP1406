public class Bank {
    String name;
    Person manager;
    BankAccount[] accounts;
    int currentNumAccounts;
    final static int MAX_ACCOUNTS = 25;

    public Bank(String initName){
        name = initName;
        manager = null;
        accounts = new BankAccount[MAX_ACCOUNTS]; //we can have up to 25 accounts in the bank
    }

    //For extra practice - implement a method that will pay 5% interest to every
    //bank account within this bank. Add code to the BankTester class to test it.
    public void payInterest(){

    }
}