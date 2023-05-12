//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Oven extends KitchenItems {
    private boolean convection;

    public Oven(double p, int q, int w, String c, String b, boolean convection) {
        super(p, q, w, c, b);
        this.convection = convection;
    }

    public String toString() {
        String var10000;
        if (!this.convection) {
            var10000 = this.getBrand();
            return var10000 + " Oven (" + this.getColor() + ", " + this.getWattage() + " watts) \n(" + this.getPrice() + " dollars each, " + this.getStockQuantity() + " in stock, " + this.getSoldQuantity() + " sold)";
        } else {
            var10000 = this.getBrand();
            return var10000 + " Oven with convection (" + this.getColor() + ", " + this.getWattage() + " watts) \n(" + this.getPrice() + " dollars each, " + this.getStockQuantity() + " in stock, " + this.getSoldQuantity() + " sold)";
        }
    }
}