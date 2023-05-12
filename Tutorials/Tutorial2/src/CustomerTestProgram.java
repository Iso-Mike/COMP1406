public class CustomerTestProgram {
    public static void main(String[] args) {
        Customer c1, c2;

        c1 = new Customer("Bob");
        c2 = new Customer("Mike");

        c1.age = 27;
        c1.money = 50;
        System.out.println(c1.name);
        System.out.println(c1.age);
        System.out.println(c1.money);
        System.out.println();
        c2.age = 18;
        c2.money = 1540;
        System.out.println(c2.name);
        System.out.println(c2.age);
        System.out.println(c2.money);

    }
}
