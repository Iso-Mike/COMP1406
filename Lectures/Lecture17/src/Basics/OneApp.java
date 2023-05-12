package Basics;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class OneApp extends Application {
  public void start(Stage primaryStage) {
    Pane aPane = new Pane();
    ObservableList<String> options = FXCollections.observableArrayList("Home Address", "Work Address", "Alternate Address");
    ComboBox<String> addressBox = new ComboBox<String>(options);
    addressBox.setPromptText("Choose address type");
    addressBox.setValue("Work Address");
    addressBox.relocate(10,10);
    addressBox.setPrefSize(410,30);
    aPane.getChildren().add(addressBox);
    
    // Now add an AddressPane
    AddressPane myPanel = new AddressPane("CONTACT ADDRESS");
    myPanel.relocate(10,50);
    aPane.getChildren().add(myPanel);
    
    primaryStage.setTitle("App 1"); // Set title of window
    primaryStage.setResizable(false); // Make it non-resizable
    primaryStage.setScene(new Scene(aPane, 430,260)); // Set size of window
    primaryStage.show();
  }
  public static void main(String[] args) {
    launch(args);
  }
} 