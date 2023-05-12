public class Address {
    String name;
    int streetNum;
    String streetName;
    String city;
    String province;
    String postalCode;
    String phoneNumber;

    public Address(){
        this("Unnamed");
    }

    public Address(String name){
        this(name, -1, "Unknown St", "Unknown City", "Unknown Provice", "Unknown Postal Code");
    }

    public Address(String iName, int streetNum, String streetName, String city, String province, String postalCode){
        name = iName;
        this.streetNum = streetNum;
        this.streetName = streetName;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.phoneNumber = "UNKNOWN";
    }

    public String toString(){
        return name + " lives at " + streetNum + " " + streetName;
    }
}
