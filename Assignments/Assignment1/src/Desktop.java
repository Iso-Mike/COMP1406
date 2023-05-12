//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Desktop {
    double Ghz;
    int ramGB;
    int storageGB;
    boolean SSD;

    public Desktop(double CPUspeed, int Ram, int storage, boolean SSD) {
        this.Ghz = CPUspeed;
        this.ramGB = Ram;
        this.storageGB = storage;
        this.SSD = SSD;
    }

    public String toString() {
        return !this.SSD ? "Desktop PC with " + this.Ghz + "ghz CPU, " + this.ramGB + "GB RAM, " + this.storageGB + "GB HDD drive" : "Desktop PC with " + this.Ghz + "ghz CPU, " + this.ramGB + "GB RAM, " + this.storageGB + "GB SSD drive";
    }
}