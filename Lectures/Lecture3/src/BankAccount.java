public class BankAccount {
    Person owner;
    double balance;
    int accountId;
    static int nextAccountId = 10000;

    public BankAccount(Person initOwner){
        owner = initOwner;
        balance = 0.0;
        accountId = nextAccountId;
        nextAccountId++;
    }

    //Increases the account's balance by the given amount
    //assuming the amount is greater than 0
    //Returns true to indicate success and false for failure
    public boolean deposit(double amount){
        if(amount > 0) {
            this.balance = this.balance + amount;
            return true;
        }
        return false;
    }

    public boolean deposit(int dollars, int cents){
        double amount = dollars + (cents / 100.0);
        return deposit(amount);
    }

    public boolean withdraw(double amount){
        if(amount < balance){
            balance -= amount;
            return true;
        }
        return false;
    }

    public double checkBalance(){
        return balance;
    }

    public String toString(){
        return "#" + accountId + " has a balance of $" + balance;
    }
}
