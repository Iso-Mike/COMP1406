import java.io.*;
public class AutoshowSaveLoadTestProgram {
  // This method tests the writing of an autoshow to a file
  private static void writeTest() throws IOException {
    // First make an Autoshow and add lots of cars to the show
    Autoshow show = new Autoshow("AutoRama 2022");
    show.addCar(new Car("Porsche", "959", "Red", 240, false));
    show.addCar(new Car("Pontiac", "Grand-Am", "White", 160, true));
    show.addCar(new Car("Ford", "Mustang", "White", 230, false));
    show.addCar(new Car("Volkswagon", "Beetle", "Blue", 140, false));
    show.addCar(new Car("Volkswagon", "Jetta", "Silver", 180, true));
    show.addCar(new Car("Geo", "Storm", "Yellow", 110, true));
    show.addCar(new Car("Toyota", "MR2", "Black", 220, false));
    show.addCar(new Car("Ford", "Escort", "Yellow", 10, true));
    show.addCar(new Car("Honda", "Civic", "Black", 220, true));
    show.addCar(new Car("Nissan", "Altima", "Silver", 180, true));
    show.addCar(new Car("BMW", "5", "Gold", 260, true));
    show.addCar(new Car("Prelude", "Honda", "White", 90, false));
    show.addCar(new Car("Mazda", "RX7", "Red", 240, false));
    show.addCar(new Car("Mazda", "MX6", "Green", 160, true));
    show.addCar(new Car("Pontiac", "G6", "Black", 140, false));
    // Now open the file and save the autoshow
    PrintWriter aFile;
    aFile = new PrintWriter(new FileWriter("resources" + File.separator + "autoshow.txt"));
    show.saveTo(aFile);
    aFile.close();
  } 
  // This method tests the reading of an autoshow from a file
  private static void readTest() throws IOException {
    BufferedReader aFile;
    aFile = new BufferedReader(new FileReader("resources" + File.separator + "autoshow.txt"));
    Autoshow aShow = Autoshow.loadFrom(aFile);
    aShow.showCars();
    aFile.close();
  }
  public static void main(String[] args) throws IOException {
    writeTest(); // Write an autoshow to the file
    readTest(); // Read an autoshow from the file
  }
} 