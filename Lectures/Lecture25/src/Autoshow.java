import java.util.ArrayList;
import java.io.*;
public class Autoshow {
  private String name;
  private ArrayList<Car> cars;
  public Autoshow(String n) {
    name = n;
    cars = new ArrayList<Car>();
  }
  public void addCar(Car c) {
    cars.add(c);
  }
  public void showCars() {
    for (Car c: cars)
      System.out.println(c);
  }
  
  public void saveTo(PrintWriter aFile) {
    aFile.println(name);
    for (Car c: cars) {
      aFile.println(); // Leave a blank line before writing the next one
      c.saveTo(aFile);
    }
  }
  
  public static Autoshow loadFrom(BufferedReader aFile) throws IOException {
    Autoshow aShow = new Autoshow(aFile.readLine());
    
    while (aFile.ready()) { //read until no more available (i.e., not ready)
      aFile.readLine(); //read the blank line
      aShow.cars.add(Car.loadFrom(aFile)); //read & add the car
    }
    return aShow;
  }
} 