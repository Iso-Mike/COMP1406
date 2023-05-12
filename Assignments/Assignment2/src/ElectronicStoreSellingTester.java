//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.PrintStream;

public class ElectronicStoreSellingTester {
    public ElectronicStoreSellingTester() {
    }

    public static void main(String[] args) {
        ElectronicStore store1 = ElectronicStoreCreator.createStore1();
        ElectronicStore store2 = ElectronicStoreCreator.createStore2();
        ElectronicStore store3 = ElectronicStoreCreator.createStore3();
        System.out.println(store1.getName() + "'s Starting Stock Is:");
        store1.printStock();
        System.out.println();
        System.out.println(store2.getName() + "'s Starting Stock Is:");
        store2.printStock();
        System.out.println();
        System.out.println(store3.getName() + "'s Starting Stock Is:");
        store3.printStock();
        System.out.println();
        store1.sellProducts(0, 5);
        store1.sellProducts(0, 4);
        store1.sellProducts(0, 2);
        store1.sellProducts(3, 5);
        store1.sellProducts(3, 5);
        store1.sellProducts(7, 10);
        store1.sellProducts(0, 1);
        store1.sellProducts(0, 1);
        store2.sellProducts(0, 5);
        store2.sellProducts(0, 1);
        store2.sellProducts(1, 0);
        store2.sellProducts(1, 1);
        store2.sellProducts(2, 5);
        store2.sellProducts(2, 10);
        store2.sellProducts(8, 1);
        store2.sellProducts(37, 1);
        store2.sellProducts(0, -4);
        store3.sellProducts(1, 15);
        store3.sellProducts(2, 5);
        store3.sellProducts(4, 4);
        store3.sellProducts(1, 1);
        store3.sellProducts(5, 5);
        store3.sellProducts(9, 3);
        store3.sellProducts(9, 4);
        store3.sellProducts(11, 1);
        System.out.println(store1.getName() + "'s Ending Stock Is:");
        store1.printStock();
        System.out.println();
        System.out.println(store2.getName() + "'s Ending Stock Is:");
        store2.printStock();
        System.out.println();
        System.out.println(store3.getName() + "'s Ending Stock Is:");
        store3.printStock();
        System.out.println();
        PrintStream var10000 = System.out;
        String var10001 = store1.getName();
        var10000.println(var10001 + "'s total revenue was: " + store1.getRevenue());
        var10000 = System.out;
        var10001 = store2.getName();
        var10000.println(var10001 + "'s total revenue was: " + store2.getRevenue());
        var10000 = System.out;
        var10001 = store3.getName();
        var10000.println(var10001 + "'s total revenue was: " + store3.getRevenue());
    }
}