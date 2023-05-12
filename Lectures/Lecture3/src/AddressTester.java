public class AddressTester {
    public static void main(String[] args) {
        //Declaring an object variable
        Address a1;
        Address a2;

        //Instantiating an object variable
        a1 = new Address("Ricky Lahey", 5, "Bonnyview Dr", "Halifax", "NS", "N4L1B9");
        a2 = new Address("Julian", 2, "Maple Lake", "Halifax", "NS", "N4L1B9");

        //Initializing an object variable
        System.out.println(a1.name);
        System.out.println(a2.name);
        a1.phoneNumber = "613-912-3742";

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a1.phoneNumber);
        System.out.println(a2.phoneNumber);


    }
}
