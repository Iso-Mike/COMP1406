//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Fridge {
    double cubicFeet;
    boolean freezer;
    String color;

    public Fridge(double size, boolean freezer, String color) {
        this.cubicFeet = size;
        this.freezer = freezer;
        this.color = color;
    }

    public String toString() {
        return this.freezer ? this.cubicFeet + " cu. ft. Fridge with Freezer (" + this.color + ")" : this.cubicFeet + " cu. ft. Fridge (" + this.color + ")";
    }
}