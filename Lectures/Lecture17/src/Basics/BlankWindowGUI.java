package Basics;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class BlankWindowGUI extends Application{
  //Called automatically to start the application (you must write this)
  public void start(Stage primaryStage){
    //Create a new scene
    //The first argument is the 'root' node
    //The second/third arguments are the size of the window
    Pane blank = new Pane();
    Scene scene = new Scene(blank, 300, 300);
    primaryStage.setTitle("The Window"); // Set window title
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  public static void main(String[] args){
    launch(args);
  } 
}