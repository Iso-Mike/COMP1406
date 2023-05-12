//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ElectronicStore implements Serializable {
    private String name;
    private ArrayList<Product> stock;
    private double revenue = 0.0;
    private ArrayList<Customer> customers;

    public ElectronicStore(String initName) {
        this.name = initName;
        this.stock = new ArrayList();
        this.customers = new ArrayList();
    }

    public String getName() {
        return this.name;
    }

    public List<Customer> getCustomers() {
        return this.customers;
    }

    public boolean addProduct(Product newProduct) {
        Iterator var2 = this.stock.iterator();

        Product i;
        do {
            if (!var2.hasNext()) {
                this.stock.add(newProduct);
                return true;
            }

            i = (Product)var2.next();
        } while(!newProduct.toString().equals(i.toString()));

        return false;
    }

    public boolean registerCustomer(Customer customer) {
        Iterator var2 = this.customers.iterator();

        Customer i;
        do {
            if (!var2.hasNext()) {
                this.customers.add(customer);
                return true;
            }

            i = (Customer)var2.next();
        } while(!customer.getName().equals(i.getName()));

        return false;
    }

    public List<Product> searchProducts(String x) {
        List<Product> match = new ArrayList();
        Iterator var3 = this.stock.iterator();

        while(var3.hasNext()) {
            Product i = (Product)var3.next();
            if (i.toString().toLowerCase().contains(x.toLowerCase())) {
                match.add(i);
            }
        }

        return match;
    }

    public List<Product> searchProducts(String x, double minPrice, double maxPrice) {
        List<Product> match = new ArrayList();
        if (minPrice <= 0.0 && maxPrice <= 0.0) {
            return this.searchProducts(x);
        } else {
            Iterator var7;
            Product i;
            if (minPrice <= 0.0 && maxPrice > 0.0) {
                var7 = this.searchProducts(x).iterator();

                while(var7.hasNext()) {
                    i = (Product)var7.next();
                    if (i.getPrice() <= maxPrice) {
                        match.add(i);
                    }
                }
            } else if (minPrice > 0.0 && maxPrice <= 0.0) {
                var7 = this.searchProducts(x).iterator();

                while(var7.hasNext()) {
                    i = (Product)var7.next();
                    if (i.getPrice() >= minPrice) {
                        match.add(i);
                    }
                }
            } else {
                var7 = this.searchProducts(x).iterator();

                while(var7.hasNext()) {
                    i = (Product)var7.next();
                    if (i.getPrice() >= minPrice && i.getPrice() <= maxPrice) {
                        match.add(i);
                    }
                }
            }

            return match;
        }
    }

    public boolean addStock(Product p, int amount) {
        if (this.stock.contains(p)) {
            p.setStockQuantity(amount);
            return true;
        } else {
            return false;
        }
    }

    public boolean sellProduct(Product p, Customer c, int amount) {
        if (this.stock.contains(p) && this.customers.contains(c) && p.getStockQuantity() > 0 && amount > 0 && amount <= p.getStockQuantity()) {
            for(int i = 0; i < amount; ++i) {
                c.addPurchasedProducts(p);
            }

            double total = p.sellUnits(amount);
            c.setMoneySpent(total);
            this.revenue += total;
            return true;
        } else {
            return false;
        }
    }

    public List<Customer> getTopXCustomers(int x) {
        List<Customer> topX = new ArrayList();
        List<Customer> tempList = new ArrayList(this.customers);
        if (x <= 0) {
            return topX;
        } else {
            while(topX.size() < x && !tempList.isEmpty()) {
                Customer mostMoneySpent = (Customer)tempList.get(0);
                Iterator var5 = tempList.iterator();

                while(var5.hasNext()) {
                    Customer customer = (Customer)var5.next();
                    if (customer.getMoneySpent() > mostMoneySpent.getMoneySpent()) {
                        mostMoneySpent = customer;
                    }
                }

                tempList.remove(mostMoneySpent);
                topX.add(mostMoneySpent);
            }

            return topX;
        }
    }

    public boolean saveToFile(String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            return true;
        } catch (IOException var4) {
            var4.printStackTrace();
            return false;
        }
    }

    public static ElectronicStore loadFromFile(String filename) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            ElectronicStore store = (ElectronicStore)in.readObject();
            in.close();
            return store;
        } catch (FileNotFoundException var3) {
            System.out.println("File not found: " + var3.getMessage());
            return null;
        } catch (IOException var4) {
            var4.printStackTrace();
            return null;
        } catch (ClassNotFoundException var5) {
            var5.printStackTrace();
            return null;
        }
    }
}