package Basics;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class TwoApp extends Application {
  public void start(Stage primaryStage) {
    Pane aPane = new Pane();
    
    // Add the list
    ListView<String> namesList = new ListView<String>();
    String[] names = {"Bob E. Pins", "Sunny Day", "Jen Tull", "Bea Keeper", "Ivona Pass"};
    namesList.setItems(FXCollections.observableArrayList(names));
    namesList.relocate(10, 10);
    namesList.setPrefSize(150, 420);
    aPane.getChildren().add(namesList);
    
    // Now add an AddressPane
    AddressPane myPanel1 = new AddressPane("HOME ADDRESS");
    myPanel1.relocate(170,10);
    aPane.getChildren().add(myPanel1);
    
    // Now add another AddressPane
    AddressPane myPanel2 = new AddressPane("ALTERNATE ADDRESS");
    myPanel2.relocate(170,230);
    aPane.getChildren().add(myPanel2);
    
    primaryStage.setTitle("App 2"); // Set title of window
    primaryStage.setResizable(false); // Make it non-resizable
    primaryStage.setScene(new Scene(aPane, 590,440)); // Set size of window
    primaryStage.show();
  }
  public static void main(String[] args) {
    launch(args);
  }
} 