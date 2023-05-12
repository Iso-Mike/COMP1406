//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class ElectronicStoreCreator {
    public ElectronicStoreCreator() {
    }

    public static ElectronicStore createStore1() {
        ElectronicStore store1 = new ElectronicStore("Watts Up Electronics");
        Desktop d1 = new Desktop(100.0, 10, 3.0, 16, false, 250, "Compact");
        Desktop d2 = new Desktop(200.0, 10, 4.0, 32, true, 500, "Server");
        Laptop l1 = new Laptop(150.0, 10, 2.5, 16, true, 250, 15.0);
        Laptop l2 = new Laptop(250.0, 10, 3.5, 24, true, 500, 16.0);
        Fridge f1 = new Fridge(500.0, 10, 250, "White", "Sub Zero", false);
        Fridge f2 = new Fridge(750.0, 10, 125, "Stainless Steel", "Sub Zero", true);
        Oven t1 = new Oven(25.0, 10, 50, "Black", "Danby", false);
        Oven t2 = new Oven(75.0, 10, 50, "Silver", "Toasty", true);
        store1.addProduct(d1);
        store1.addProduct(d2);
        store1.addProduct(l1);
        store1.addProduct(l2);
        store1.addProduct(f1);
        store1.addProduct(f2);
        store1.addProduct(t1);
        store1.addProduct(t2);
        return store1;
    }

    public static ElectronicStore createStore2() {
        ElectronicStore store1 = new ElectronicStore("Buy-nary Computing");
        Desktop d1 = new Desktop(150.0, 5, 3.0, 16, true, 250, "Compact");
        Desktop d2 = new Desktop(250.0, 5, 3.5, 32, true, 500, "Server");
        Laptop l1 = new Laptop(100.0, 15, 2.5, 16, false, 250, 15.0);
        Laptop l2 = new Laptop(175.0, 15, 3.5, 24, true, 500, 16.0);
        Fridge f1 = new Fridge(350.0, 10, 250, "Black", "Sub Zero", false);
        Fridge f2 = new Fridge(600.0, 10, 125, "White", "Sub Zero", true);
        Oven t1 = new Oven(25.0, 10, 50, "Graphite", "Danby", false);
        Oven t2 = new Oven(75.0, 10, 50, "Red", "Toasty", true);
        store1.addProduct(d1);
        store1.addProduct(d2);
        store1.addProduct(l1);
        store1.addProduct(l2);
        store1.addProduct(f1);
        store1.addProduct(f2);
        store1.addProduct(t1);
        store1.addProduct(t2);
        return store1;
    }

    public static ElectronicStore createStore3() {
        ElectronicStore store1 = new ElectronicStore("Ohm-y Goodness Electronics");
        Desktop d1 = new Desktop(175.0, 10, 3.0, 16, true, 250, "Low-Profile");
        Desktop d2 = new Desktop(150.0, 15, 3.5, 32, false, 1000, "Standard");
        Laptop l1 = new Laptop(350.0, 5, 3.5, 16, true, 500, 16.0);
        Laptop l2 = new Laptop(500.0, 5, 2.5, 8, true, 125, 13.0);
        Fridge f1 = new Fridge(250.0, 5, 250, "Black", "Sub Zero", false);
        Fridge f2 = new Fridge(275.0, 5, 125, "White", "Sub Zero", false);
        Oven t1 = new Oven(30.0, 10, 50, "Graphite", "Danby", false);
        Oven t2 = new Oven(80.0, 10, 50, "Red", "Toasty", true);
        Desktop d3 = new Desktop(175.0, 10, 3.0, 16, true, 250, "Low-Profile");
        Desktop d4 = new Desktop(150.0, 15, 3.5, 32, false, 1000, "Standard");
        Laptop l3 = new Laptop(350.0, 5, 3.5, 16, true, 500, 16.0);
        Laptop l4 = new Laptop(500.0, 5, 2.5, 8, true, 125, 13.0);
        Fridge f3 = new Fridge(250.0, 5, 250, "Black", "Sub Zero", false);
        Fridge f4 = new Fridge(275.0, 5, 125, "White", "Sub Zero", false);
        Oven t3 = new Oven(30.0, 10, 50, "Graphite", "Danby", false);
        Oven t4 = new Oven(80.0, 10, 50, "Red", "Toasty", true);
        store1.addProduct(d1);
        store1.addProduct(d2);
        store1.addProduct(l1);
        store1.addProduct(l2);
        store1.addProduct(f1);
        store1.addProduct(f2);
        store1.addProduct(t1);
        store1.addProduct(t2);
        store1.addProduct(d3);
        store1.addProduct(d4);
        store1.addProduct(l3);
        store1.addProduct(l4);
        store1.addProduct(f3);
        store1.addProduct(f4);
        store1.addProduct(t3);
        store1.addProduct(t4);
        return store1;
    }
}