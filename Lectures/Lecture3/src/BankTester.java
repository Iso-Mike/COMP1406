public class BankTester {
    public static void main(String[] args) {
        Address a1 = new Address("Ricky Lahey", 5, "Bonnyview Dr", "Halifax", "NS", "N4L1B9");
        Address a2 = new Address("Julian", 2, "Maple Lake", "Halifax", "NS", "N4L1B9");

        Person ricky = new Person("Ricky");
        ricky.address = a1;
        Person julian = new Person("Julian");
        julian.address = a2;

        BankAccount rickysAccount = new BankAccount(ricky);
        BankAccount juliansAccount = new BankAccount(julian);

        Bank scotia = new Bank("Scotiabank");

        System.out.println(rickysAccount.owner);
        System.out.println(rickysAccount.owner.address);
        System.out.println(juliansAccount.owner.address);

        rickysAccount.deposit(10);
        System.out.println(rickysAccount.checkBalance()); //10
        rickysAccount.withdraw(2);
        System.out.println(rickysAccount.checkBalance()); //8
        rickysAccount.withdraw(9);
        System.out.println(rickysAccount.checkBalance()); //8
        rickysAccount.deposit(-1);
        System.out.println(rickysAccount.checkBalance()); //8
        rickysAccount.deposit(5, 55);
        System.out.println(rickysAccount.checkBalance()); //13.55

        System.out.println(rickysAccount);
        System.out.println(juliansAccount);
    }
}
