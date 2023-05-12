//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Scanner;

public class ElectronicStoreTester {
    public ElectronicStoreTester() {
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ElectronicStore Estore = new ElectronicStore("Mikes Electronic Store");
        Estore.printStock();
        System.out.println();
        boolean running = true;

        while(running) {
            System.out.print("Enter a term to search for: ");
            String item = input.nextLine();
            if (item.equalsIgnoreCase("quit")) {
                running = false;
            } else if (Estore.searchStock(item)) {
                System.out.println("A matching item is contained in the store's stock.");
            } else {
                System.out.println("No items in the store's stock match that term.");
            }
        }

    }
}