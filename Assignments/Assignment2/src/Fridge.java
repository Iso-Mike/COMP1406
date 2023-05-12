//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Fridge extends KitchenItems {
    private boolean hasFreezer;

    public Fridge(double p, int q, int w, String c, String b, boolean hf) {
        super(p, q, w, c, b);
        this.hasFreezer = hf;
    }

    public String toString() {
        String var10000;
        if (!this.hasFreezer) {
            var10000 = this.getBrand();
            return var10000 + " (" + this.getColor() + ", " + this.getWattage() + " watts) \n(" + this.getPrice() + " dollars each, " + this.getStockQuantity() + " in stock, " + this.getSoldQuantity() + " sold)";
        } else {
            var10000 = this.getBrand();
            return var10000 + " with Freezer (" + this.getColor() + ", " + this.getWattage() + " watts) \n(" + this.getPrice() + " dollars each, " + this.getStockQuantity() + " in stock, " + this.getSoldQuantity() + " sold)";
        }
    }
}