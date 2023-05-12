//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Laptop {
    double Ghz;
    int ramGB;
    int storageGB;
    boolean SSD;
    int inches;

    public Laptop(double CPUspeed, int Ram, int storage, boolean SSD, int ScreenSize) {
        this.Ghz = CPUspeed;
        this.ramGB = Ram;
        this.storageGB = storage;
        this.SSD = SSD;
        this.inches = ScreenSize;
    }

    public String toString() {
        return !this.SSD ? this.inches + "\" Laptop PC with " + this.Ghz + "ghz CPU, " + this.ramGB + "GB RAM, " + this.storageGB + "GB HDD drive" : this.inches + "\" Laptop PC with " + this.Ghz + "ghz CPU, " + this.ramGB + "GB RAM, " + this.storageGB + "GB SSD drive";
    }
}