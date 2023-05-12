public class Mall {
    public static final int MAX_STORES = 100;
    private String name;
    private Store[] stores;
    private int storeCount;
    public Mall(String n) {
        name = n;
        stores = new Store[MAX_STORES];
        storeCount = 0;
    }
    public void addStore(Store s) {
        if (storeCount < MAX_STORES) {
            stores[storeCount++] = s;
        }
    }

//    public boolean shoppedAtSameStore(Customer c1, Customer c2) {
//        boolean c1instore = false;
//        boolean c2instore = false;
//        for(int i = 0; i < storeCount-1; i++) {
//            for (int j = 0; j < stores[i].getCustomersCount() - 1; j++) {
//                if (c1 == stores[i].getCustomers()[j]) {
//                    c1instore = true;
//                    break;
//                }
//            }
//
//            for (int j = 0; j < stores[i].getCustomersCount() - 1; j++) {
//                if (c2 == stores[i].getCustomers()[j]) {
//                    c2instore = true;
//                    break;
//                }
//            }
//        }
//        return c1instore && c2instore;
//    }
}
