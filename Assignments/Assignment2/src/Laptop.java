//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Laptop extends Computers {
    private double screenSize;

    public Laptop(double p, int q, double cpus, int r, boolean ssd, int s, double sc) {
        super(p, q, cpus, r, ssd, s);
        this.screenSize = sc;
    }

    public String toString() {
        double var10000;
        if (!this.getSsd()) {
            var10000 = this.screenSize;
            return "" + var10000 + " inch Laptop PC with " + this.getCpuSpeed() + "ghz CPU, " + this.getRam() + "GB RAM, " + this.getStorage() + "GB HDD drive. \n(" + this.getPrice() + " dollars each, " + this.getStockQuantity() + " in stock, " + this.getSoldQuantity() + " sold)";
        } else {
            var10000 = this.screenSize;
            return "" + var10000 + " inch Laptop PC with " + this.getCpuSpeed() + "ghz CPU, " + this.getRam() + "GB RAM, " + this.getStorage() + "GB SSD drive. \n(" + this.getPrice() + " dollars each, " + this.getStockQuantity() + " in stock, " + this.getSoldQuantity() + " sold)";
        }
    }
}