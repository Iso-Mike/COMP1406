//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.PrintStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;

public class Customer implements Serializable {
    private String name;
    private double moneySpent;
    private HashMap<String, Integer> purchasedProducts;

    public Customer(String n) {
        this.name = n;
        this.moneySpent = 0.0;
        this.purchasedProducts = new HashMap();
    }

    public String getName() {
        return this.name;
    }

    public double getMoneySpent() {
        return this.moneySpent;
    }

    public void setMoneySpent(double x) {
        this.moneySpent += x;
    }

    public void addPurchasedProducts(Product x) {
        if (x != null) {
            if (this.purchasedProducts.containsKey(x.toString())) {
                int currentQuantity = (Integer)this.purchasedProducts.get(x.toString());
                this.purchasedProducts.put(x.toString(), currentQuantity + 1);
            } else {
                this.purchasedProducts.put(x.toString(), 1);
            }
        }

    }

    public String toString() {
        return this.name + " who has spent $" + this.moneySpent;
    }

    public void printPurchaseHistory() {
        Iterator var1 = this.purchasedProducts.keySet().iterator();

        while(var1.hasNext()) {
            String i = (String)var1.next();
            PrintStream var10000 = System.out;
            String var10001 = String.valueOf(this.purchasedProducts.get(i));
            var10000.println(var10001 + "x " + i);
        }

    }
}