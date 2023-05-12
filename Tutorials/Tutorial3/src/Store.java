public class Store {
    private static int LATEST_ID = 100000;
    public static final int MAX_CUSTOMERS = 500;
    private String name;
    private Customer[] customers;
    int customerCount;
    public Store(String n) {
        name = n;
        customers = new Customer[MAX_CUSTOMERS];
        customerCount = 0;
    }
    public void addCustomer(Customer c) {
        if (customerCount < MAX_CUSTOMERS)
            customers[customerCount++] = c;
            c.setRewardsld(LATEST_ID);
            LATEST_ID++;
    }
    public void listCustomers() {
        for (int i=0; i<customerCount; i++)
            System.out.println(customers[i]);
    }

    public int averageCustomerAge() {
        int total = 0;
        for(int i = 0; i < customerCount; i++) {
            total += customers[i].getAge();
        }
        return total/customerCount;
    }

    public Customer richestCustomer() {
        Customer rich = customers[0];
        for(int i = 0; i < customerCount; i++) {
            if(customers[i].hasMoreMoneyThan(rich)) {
                rich = customers[i];
            }
        }
        return rich;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public int getCustomersCount() {
        return customerCount;
    }
}
