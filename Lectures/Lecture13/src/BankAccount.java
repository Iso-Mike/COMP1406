import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class BankAccount implements Comparable<BankAccount> {
    private int accountNum;
    private String institution;
    private double balance;

    public BankAccount(int iAccount, String iInst, double initBalance) {
        accountNum = iAccount;
        institution = iInst;
        balance = initBalance;
    }

    //Assume accounts are equal if they have the same
    //account number and same institution name
    public boolean equals(Object o) {
        if (o instanceof BankAccount) {
            BankAccount temp = (BankAccount) o;
            return (this.accountNum == temp.accountNum && this.institution.equals(temp.institution));
        }
        return false;
    }

    public String toString() {
        return "Account #" + accountNum + " at " + institution;
    }

    @Override
    public int compareTo(BankAccount o) {
        //Step 1: Sort based on institution name
        int instCompare = o.institution.compareTo(this.institution);
        if (instCompare == 0) {
            //Step 2: If the inst is the same, then sort by account number
            return this.accountNum - o.accountNum;
        }
        return instCompare;
    }

    public static void main(String[] args) {
        BankAccount b1 = new BankAccount(0, "Scotia", 15);
        BankAccount b2 = new BankAccount(0, "Scotia", 25);
        BankAccount b3 = new BankAccount(1, "Scotia", 0);
        BankAccount b4 = new BankAccount(0, "Montreal", 7);

        System.out.println("b1 == b2: " + (b1 == b2));
        System.out.println("b1.equals(b2): " + (b1.equals(b2)));
        System.out.println("b1 == b3: " + (b1 == b3));
        System.out.println("b1.equals(b3): " + (b1.equals(b3)));
        System.out.println("b1 == b4: " + (b1 == b4));
        System.out.println("b1.equals(b4): " + (b1.equals(b4)));

        List<BankAccount> unsorted = new ArrayList<>();
        unsorted.add(b2);
        unsorted.add(b3);
        unsorted.add(b4);
        unsorted.add(new BankAccount(6, "Scotia", 0));
        unsorted.add(new BankAccount(4, "Montreal", 0));
        unsorted.add(new BankAccount(8, "Montreal", 0));
        unsorted.add(new BankAccount(13, "Scotia", 0));
        unsorted.add(new BankAccount(2, "Montreal", 0));
        unsorted.add(new BankAccount(5, "Scotia", 0));
        unsorted.add(new BankAccount(23, "Montreal", 0));
        unsorted.add(new BankAccount(17, "Scotia", 0));
        unsorted.add(new BankAccount(19, "Montreal", 0));
        unsorted.add(new BankAccount(21, "Scotia", 0));
        unsorted.add(new BankAccount(21, "Montreal", 0));
        unsorted.add(new BankAccount(3, "Scotia", 0));
        unsorted.add(new BankAccount(3, "Montreal", 0));
        unsorted.add(new BankAccount(7, "Scotia", 0));
        unsorted.add(new BankAccount(1, "Montreal", 0));
        unsorted.add(new BankAccount(2, "Scotia", 0));



        TreeSet<BankAccount> tree = new TreeSet<BankAccount>();
        for (BankAccount b : unsorted) {
            tree.add(b);
        }
        System.out.println("Accounts in tree set:");
        for (BankAccount b : tree) {
            System.out.println(b);
        }

        List<BankAccount> list = new ArrayList<BankAccount>();
        list.addAll(unsorted);
        Collections.sort(list);
        System.out.println("Accounts in sorted list:");
        for (BankAccount b : list) {
            System.out.println(b);
        }


    }


}