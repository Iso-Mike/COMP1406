//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class ElectronicStore {
    String name;
    Desktop[] desktops;
    Laptop[] laptops;
    Fridge[] fridges;

    public ElectronicStore(String storename) {
        this.name = storename;
        this.desktops = new Desktop[3];
        this.desktops[0] = new Desktop(3.5, 8, 500, false);
        this.desktops[1] = new Desktop(3.0, 16, 250, true);
        this.desktops[2] = new Desktop(4.3, 32, 500, true);
        this.laptops = new Laptop[3];
        this.laptops[0] = new Laptop(3.1, 32, 500, true, 15);
        this.laptops[1] = new Laptop(2.5, 8, 250, false, 13);
        this.laptops[2] = new Laptop(3.0, 16, 250, true, 15);
        this.fridges = new Fridge[3];
        this.fridges[0] = new Fridge(16.5, true, "Black");
        this.fridges[1] = new Fridge(12.0, false, "White");
        this.fridges[2] = new Fridge(23.0, true, "Stainless Steel");
    }

    public void printStock() {
        System.out.println(this.name + " includes: ");
        Desktop[] var1 = this.desktops;
        int var2 = var1.length;

        int var3;
        for(var3 = 0; var3 < var2; ++var3) {
            Desktop desktop = var1[var3];
            System.out.println(desktop);
        }

        Laptop[] var5 = this.laptops;
        var2 = var5.length;

        for(var3 = 0; var3 < var2; ++var3) {
            Laptop laptop = var5[var3];
            System.out.println(laptop);
        }

        Fridge[] var6 = this.fridges;
        var2 = var6.length;

        for(var3 = 0; var3 < var2; ++var3) {
            Fridge fridge = var6[var3];
            System.out.println(fridge);
        }

    }

    public boolean searchStock(String item) {
        Desktop[] var2 = this.desktops;
        int var3 = var2.length;

        int var4;
        for(var4 = 0; var4 < var3; ++var4) {
            Desktop desktop = var2[var4];
            if (desktop.toString().toLowerCase().contains(item.toLowerCase())) {
                return true;
            }
        }

        Laptop[] var6 = this.laptops;
        var3 = var6.length;

        for(var4 = 0; var4 < var3; ++var4) {
            Laptop laptop = var6[var4];
            if (laptop.toString().toLowerCase().contains(item.toLowerCase())) {
                return true;
            }
        }

        Fridge[] var7 = this.fridges;
        var3 = var7.length;

        for(var4 = 0; var4 < var3; ++var4) {
            Fridge fridge = var7[var4];
            if (fridge.toString().toLowerCase().contains(item.toLowerCase())) {
                return true;
            }
        }

        return false;
    }
}