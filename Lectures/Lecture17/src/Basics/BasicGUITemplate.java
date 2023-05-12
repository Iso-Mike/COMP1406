package Basics;

import javafx.application.Application;
import javafx.stage.Stage;

public class BasicGUITemplate extends Application{
  //Called automatically to start the application (you must write this)
  public void start(Stage primaryStage){
    System.out.println("Starting!");
    //Add code in here to actually create the window
  }
  
  public static void main(String[] args){
    launch(args);
  } 
}