public class Address{
    private String street;
    private String postalCode;
    private String city;
    private String province;
    private String country;

    public Address(String street, String city, String province, String country, String postalCode){
        this.street = street;
        this.city = city;
        this.province = province;
        this.country = country;
        this.postalCode = postalCode;
    }

    public String toString(){
        return street + ", " + city + ", " + postalCode;
    }
}