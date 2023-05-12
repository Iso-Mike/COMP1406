import java.io.*;
public class Customer {
    private String      name;
    private int         age; 
    private float       money;
    private int id;

    public Customer(String n, int a, float m) {
        name = n;
        age = a; 
        money = m;
        id = -1;
    }
    
    public void setID(int newID){
      id = newID;
    }

    public String toString() {
        return "Customer " + name + ": a " + age + " year old with $" + money;
    }
    
    public String getName() { return name; }
    public int getAge(){return age;}
    
    public boolean hasMoreMoneyThan(Customer c) {
      return money > c.money;
    }

    public void saveTo(DataOutputStream aFile) throws IOException {
        aFile.writeUTF(this.name);
        aFile.writeInt(this.age);
        aFile.writeFloat(this.money);
        aFile.writeInt(this.id);
    }

    public static Customer readFrom(DataInputStream aFile) throws IOException {
        String name = aFile.readUTF();
        int age = aFile.readInt();
        float balance = aFile.readFloat();
        int id = aFile.readInt();

        Customer customer = new Customer(name, age, balance);
        customer.setID(id);

        return customer;
    }
}
