package MVC;
public class Person{
    private String name;
    private Address primaryAddress;
    private Address secondaryAddress;

    public Person(String initName){
        name = initName;
        primaryAddress = null;
        secondaryAddress = null;
    }

    public void setPrimary(Address newAddress){
        primaryAddress = newAddress;
    }

    public void setSecondary(Address newAddress){
        secondaryAddress = newAddress;
    }

    public String getName(){
        return name;
    }

    public Address getPrimary(){
        return primaryAddress;
    }

    public Address getSecondary(){
        return secondaryAddress;
    }

    public String toString(){
        return name;
    }
}