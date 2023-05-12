public class Person{
    private String name;
    private int age;
    private Address address;

    public Person(String name, int age, Address address){
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Person(String name){
        this(name, -1, null);
    }

    public String toString(){
        return name;
    }
}