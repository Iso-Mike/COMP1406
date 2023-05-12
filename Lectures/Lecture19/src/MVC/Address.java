package MVC;

public class Address{
  private String street;
  private String city;
  private String province;
  private String postalCode;

  public Address(String iStreet, String iCity, String iProvince, String iPost){
    street = iStreet;
    city = iCity;
    province = iProvince;
    postalCode = iPost;
  }

  public String getStreet(){
    return street;
  }

  public String getCity(){
    return city;
  }

  public String getProvince(){
    return province;
  }

  public String getPostalCode(){
    return postalCode;
  }
}