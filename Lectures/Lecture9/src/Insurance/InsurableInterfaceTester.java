package Insurance;

public class InsurableInterfaceTester{
  public static void main(String[] args){
    Person dave = new Person("Dave", 32, false);
    Person fiona = new Person("Fiona", 24, true);
    
    Insurable[] items = new Insurable[5];
    items[0] = new Car(dave, 2014, 20000);
    items[1] = dave;
    items[2] = new Building("177 Macy Blvd.", 750, true, dave);
    items[3] = fiona;
    items[4] = new Car(fiona, 2018, 32000);
    
    double totalCoverage = 0.0;
    for(Insurable item: items){
      System.out.println("Item: " + item);
      System.out.println("Coverage amount: " + item.getCoverageAmount());
      totalCoverage += item.getCoverageAmount();
    }
    System.out.println("Total coverage of all insurable items: " + totalCoverage);
  }  
}