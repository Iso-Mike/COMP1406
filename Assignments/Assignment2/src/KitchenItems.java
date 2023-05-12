//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public abstract class KitchenItems extends Product {
    private int wattage;
    private String color;
    private String brand;

    public KitchenItems(double p, int q, int w, String c, String b) {
        super(p, q);
        this.wattage = w;
        this.color = c;
        this.brand = b;
    }

    public int getWattage() {
        return this.wattage;
    }

    public String getColor() {
        return this.color;
    }

    public String getBrand() {
        return this.brand;
    }
}