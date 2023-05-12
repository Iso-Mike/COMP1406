import java.io.*;
public class CarSaveLoadTestProgram {
  private static void writeTest() throws IOException {
    PrintWriter file1, file2;
    Car car1, car2;
    file1 = new PrintWriter(new FileWriter("resources" + File.separator + "car1.txt"));
    file2 = new PrintWriter(new FileWriter("resources" + File.separator + "car2.txt"));
    car1 = new Car("Pontiac", "Grand-Am", "White", 160, true);
    car2 = new Car("Ford", "Mustang", "White", 230, false);
    car1.saveTo(file1);
    car2.saveTo(file2);
    file1.close();
    file2.close();
  }
  private static void readTest() throws IOException {
    BufferedReader file1, file2;
    Car car1, car2;
    file1 = new BufferedReader(new FileReader("resources" + File.separator + "car1.txt"));
    file2 = new BufferedReader(new FileReader("resources" + File.separator + "car2.txt"));
    car1 = Car.loadFrom(file1);
    car2 = Car.loadFrom(file2);
    System.out.println(car1);
    System.out.println(car2);
    file1.close();
    file2.close();
  }
  public static void main(String[] args) throws IOException {
    writeTest();
    readTest();
  }
} 