//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Desktop extends Computers {
    private String profile;

    public Desktop(double p, int q, double cpus, int r, boolean ssd, int s, String profile) {
        super(p, q, cpus, r, ssd, s);
        this.profile = profile;
    }

    public String toString() {
        String var10000;
        if (!this.getSsd()) {
            var10000 = this.profile;
            return var10000 + "Desktop PC with " + this.getCpuSpeed() + "ghz CPU," + this.getRam() + "GB RAM, " + this.getStorage() + "GB hdd drive. \n(" + this.getPrice() + " dollars each, " + this.getStockQuantity() + " in stock, " + this.getSoldQuantity() + " sold)";
        } else {
            var10000 = this.profile;
            return var10000 + "Desktop PC with " + this.getCpuSpeed() + "ghz CPU," + this.getRam() + "GB RAM, " + this.getStorage() + "GB ssd drive. \n(" + this.getPrice() + " dollars each, " + this.getStockQuantity() + " in stock, " + this.getSoldQuantity() + " sold)";
        }
    }
}