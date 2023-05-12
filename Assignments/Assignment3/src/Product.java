//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.Serializable;

public abstract class Product implements Serializable {
    private double price;
    private int stockQuantity;
    private int soldQuantity;

    public Product(double initPrice, int initQuantity) {
        this.price = initPrice;
        this.stockQuantity = initQuantity;
    }

    public int getStockQuantity() {
        return this.stockQuantity;
    }

    public int getSoldQuantity() {
        return this.soldQuantity;
    }

    public double getPrice() {
        return this.price;
    }

    public void setStockQuantity(int x) {
        this.stockQuantity += x;
    }

    public double sellUnits(int amount) {
        if (amount > 0 && this.stockQuantity >= amount) {
            this.stockQuantity -= amount;
            this.soldQuantity += amount;
            return this.price * (double)amount;
        } else {
            return 0.0;
        }
    }
}