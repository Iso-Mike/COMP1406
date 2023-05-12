//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public abstract class Computers extends Product {
    private double cpuSpeed;
    private int ram;
    private boolean ssd;
    private int storage;

    public Computers(double p, int q, double cpus, int r, boolean ssd, int s) {
        super(p, q);
        this.cpuSpeed = cpus;
        this.ram = r;
        this.ssd = ssd;
        this.storage = s;
    }

    public double getCpuSpeed() {
        return this.cpuSpeed;
    }

    public int getRam() {
        return this.ram;
    }

    public boolean getSsd() {
        return this.ssd;
    }

    public int getStorage() {
        return this.storage;
    }
}