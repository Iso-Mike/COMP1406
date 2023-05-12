package Basics;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//The javafx documentation will be extremely useful
//It outlines all the methods that you can use to interact with the various GUI elements
//It also documents all different types of controls/containers
public class BasicButtonDemo extends Application{
  //Called automatically to start the application (you must write this)
  public void start(Stage primaryStage){
    //Create a pane to hold the buttons
    //This will be the 'root' of our scene we create later
    Pane mainPane = new Pane();

    //Create a new button
    //Requires import javafx.scene.control.Button;
    Button b = new Button("Press Me");

    //Change the text inside the button
    //Once we add the ability to interact and process events
    //this will become more useful
    b.setText("PANIC!");

    //Change text alignment in the button
    //Requires import javafx.geometry.Pos;
    b.setAlignment(Pos.CENTER_LEFT);

    //Enable or disable the button
    b.setDisable(false);
    //b.setDisable(true);

    //Create a button with and style it
    Button colorButton = new Button("Test");
    //Change the style of the image button
    //This is a CSS-type string
    colorButton.setStyle("-fx-font: 22 arial; -fx-base: rgb(170,0,0); -fx-text-fill: rgb(255,255,255);");

    //Set the location and size of both buttons
    b.relocate(50,60);
    b.setPrefSize(200, 100);
    colorButton.relocate(50,200);
    colorButton.setPrefSize(200,100);

    //Add the buttons to the main pane
    mainPane.getChildren().add(b);
    mainPane.getChildren().add(colorButton);

    //Create a new scene using the mainPain as the root
    //Set the scene of the main window
    Scene scene = new Scene(mainPane, 300, 400);
    primaryStage.setTitle("Basic Button Demo");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args){
    launch(args);
  } 
}