public class Bank {
    private String name;
    private BankAccount[] accounts;
    private Person manager;

    public Bank(String name){
        this(name, null);
    }

    public Bank(String name, Person manager){
        this.name = name;
        accounts = new BankAccount[15];
        this.manager = manager;
    }

    //Given a BankAccount, add it to a null slot in the accounts array if possible.
    //Return true to indicate success and false for failure
    public boolean addAccount(BankAccount account){
        for(int i = 0; i < accounts.length; i++){
            if(accounts[i] == null){
                accounts[i] = account;
                return true;
            }
        }
        return false;
    }

    //Given a bank account, remove that account if you can find one with the same account number
    //Return true when successful and false to indicate failure
    public boolean removeAccount(BankAccount account){
        for(int i = 0; i < accounts.length; i++){
            if(accounts[i] != null && accounts[i].getAccountNumber() == account.getAccountNumber()){
                accounts[i] = null;
                return true;
            }
        }
        return false;
    }

    //Given the index in the accounts array, remove the account at that index if possible
    //Return true for success and false for failure
    public boolean removeAccount(int index){
        if(accounts[index] != null){
            accounts[index] = null;
            return true;
        }
        return false;
    }

    public void collectFees(){
        for(BankAccount a: accounts){
            if(a != null && a.getBalance() > a.getMonthlyFee()){
                a.setBalance(a.getBalance() - a.getMonthlyFee());
            }
        }
    }

    public String toString(){
        String result = name + "\n";
        if(manager != null){
            result += "Manager: " + manager.getName() + "\n";
        }
        for(BankAccount a: accounts){
            if(a != null){
                result += a + "\n";
            }
        }
        return result;
    }
}
