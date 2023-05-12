package Basics;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class AddressPaneTester extends Application{
  public void start(Stage primaryStage){
    AddressPane addPane = new AddressPane("Address Information");
    addPane.relocate(10,10);

    Pane mainPane = new Pane();
    mainPane.getChildren().add(addPane);
    Scene scene = new Scene(mainPane, 510, 250);
    primaryStage.setTitle("My Window"); // Set window title
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  public static void main(String[] args){
    launch(args);
  } 
}