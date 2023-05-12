//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public abstract class Product {
    private double price;
    private int stockQuantity;
    private int soldQuantity;

    public Product(double p, int q) {
        this.price = p;
        this.stockQuantity = q;
        this.soldQuantity = 0;
    }

    public double getPrice() {
        return this.price;
    }

    public int getStockQuantity() {
        return this.stockQuantity;
    }

    public int getSoldQuantity() {
        return this.soldQuantity;
    }

    public double sellUnits(int amount) {
        if (amount <= this.stockQuantity && amount > 0) {
            this.stockQuantity -= amount;
            this.soldQuantity += amount;
            return (double)amount * this.price;
        } else {
            return 0.0;
        }
    }
}