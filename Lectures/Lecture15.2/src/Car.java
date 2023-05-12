import java.io.*;
public class Car {
  private String make;
  private String model;
  private String color;
  private int topSpeed;
  private boolean has4Doors;
  public Car() {
    this("","","",0,false);
  }
  public Car(String mak, String mod, String col, int tsp, boolean fd) {
    make = mak;
    model = mod;
    color = col;
    topSpeed = tsp;
    has4Doors = fd;
  }
  public String toString() {
    String s = color;
    if (has4Doors)
      s += " 4-door ";
    else
      s += " 2-door ";
    return (s + make + " " + model + " with top speed " + topSpeed + "kmph");
  }

  public void saveTo(PrintWriter aFile) {
    aFile.println(make);
    aFile.println(model);
    aFile.println(color);
    aFile.println(topSpeed);
    aFile.println(has4Doors);
  }
  
  public static Car loadFrom(BufferedReader aFile) throws IOException {
    String make = aFile.readLine();
    String model = aFile.readLine();
    String color = aFile.readLine();
    int topSpeed = Integer.parseInt(aFile.readLine());
    boolean doors = Boolean.parseBoolean(aFile.readLine());
    return new Car(make, model, color, topSpeed, doors);
  }
}