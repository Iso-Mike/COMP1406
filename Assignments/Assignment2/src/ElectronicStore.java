//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Scanner;

public class ElectronicStore {
    Scanner input;
    private final int MAX_PRODUCTS;
    private String name;
    private double revenue;
    private Product[] products;

    public ElectronicStore(String n) {
        this.input = new Scanner(System.in);
        this.MAX_PRODUCTS = 10;
        this.name = n;
        this.products = new Product[10];
        this.revenue = 0.0;
    }

    public String getName() {
        return this.name;
    }

    public double getRevenue() {
        return this.revenue;
    }

    public void printStock() {
        for(int i = 0; i < 10; ++i) {
            if (this.products[i] != null) {
                System.out.println("" + i + ".  " + this.products[i].toString());
            }
        }

    }

    public boolean addProduct(Product p) {
        for(int i = 0; i < 10; ++i) {
            if (this.products[i] == null) {
                this.products[i] = p;
                return true;
            }
        }

        return false;
    }

    public boolean sellProducts() {
        this.printStock();
        System.out.println("What product would you like to purchase today at " + this.getName() + " electronic store");
        int Item = this.input.nextInt();
        int Amount = this.input.nextInt();
        if (Item <= 9 && this.products[Item] != null && Amount > 0 && Amount <= this.products[Item].getStockQuantity()) {
            this.revenue += this.products[Item].sellUnits(Amount);
            return true;
        } else {
            return false;
        }
    }

    public boolean sellProducts(int Item, int Amount) {
        if (Item <= 9 && this.products[Item] != null && Amount > 0 && Amount <= this.products[Item].getStockQuantity()) {
            this.revenue += this.products[Item].sellUnits(Amount);
            return true;
        } else {
            return false;
        }
    }
}