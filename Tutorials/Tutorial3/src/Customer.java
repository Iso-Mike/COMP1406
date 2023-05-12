public class Customer {
    private int rewardsld;
    String name;
    int age;
    private float money;
    public Customer(String n, int a, float m) {
        name = n;
        age = a;
        money = m;
        rewardsld = -1;
    }
    public String toString() {
        return "Customer " + name + ": a " + age + " year old with $" + money;
    }

    public String getName() {return name;}

    public int getAge() {return age;}

    public int getRewardsld() {return rewardsld;}

    public void setRewardsld(int ID) {
        rewardsld = ID;
    }

    public boolean hasMoreMoneyThan(Customer c) {
        if(money > c.money) {
            return true;
        }
        return false;
    }
}
