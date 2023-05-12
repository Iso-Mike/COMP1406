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
    for(Car c: cars){
      c.saveTo(aFile);
    }
  }
  
  public static Autoshow loadFrom(BufferedReader aFile) throws IOException {
    Autoshow result = new Autoshow(aFile.readLine());
    while(aFile.ready()){
      Car c = Car.loadFrom(aFile);
      result.addCar(c);
    }
    return result;
  }
} 