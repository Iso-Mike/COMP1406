public class BankTester {
    public static void main(String[] args){
        Address a1 = new Address("177 Macy Blvd.", "Ottawa", "ON", "Canada", "K1Z7K1");
        Address a2 = new Address("15 Pizza Ave.", "Mandrake Falls", "New Hampshire", "USA", "31442");
        Address a3 = new Address("42 Kellum Court", "Scranton", "Pennsylvania", "USA", "21234");

        Person ron = new Person("Ronald", 23, a1);
        Person jess = new Person("Jess", 28, new Address("43 South St.", "Ottawa", "ON", "Canada", "K1R7E4"));
        Person longfellow = new Person("Longfellow Deeds", 35, a2);
        Person mike = new Person("Michael Scott", 45, a3);

        Bank scotia = new Bank("Scotiabank", mike);

        //Make and test some different account types
        BankAccount ba = new BankAccount(ron, scotia);
        ba.deposit(100);
        ba.monthlyUpkeep();
        ba.withdraw(94.50);
        System.out.println(ba);

        SavingsAccount sa = new SavingsAccount(ron, scotia);
        sa.deposit(200);
        sa.monthlyUpkeep();
        sa.withdraw(199.5);
        System.out.println(sa);

        SuperSavingsAccount ssa = new SuperSavingsAccount(ron, scotia);
        ssa.deposit(100);
        ssa.withdraw(10);
        ssa.monthlyUpkeep();
        System.out.println(ssa);

        PowerSavingsAccount psa = new PowerSavingsAccount(ron, scotia);
        psa.deposit(1000);
        psa.deposit(100);
        System.out.println(psa);

        ChequingAccount ca = new ChequingAccount(ron, scotia);
        ca.deposit(100);
        ca.writeCheque(5);
        ca.monthlyUpkeep();
        System.out.println(ca);

        PowerChequingAccount pca = new PowerChequingAccount(ron, scotia);
        pca.deposit(100);
        pca.writeCheque(1);
        pca.writeCheque(1);
        pca.writeCheque(1);
        pca.writeCheque(1);
        pca.writeCheque(1);
        pca.writeCheque(1);
        System.out.println(pca);
        pca.monthlyUpkeep();
        pca.writeCheque(1);
        System.out.println(pca);

        BusinessChequingAccount bca = new BusinessChequingAccount(ron, scotia);
        bca.deposit(100);
        bca.writeCheque(50);
        bca.monthlyUpkeep();
        System.out.println(bca);
    }
}