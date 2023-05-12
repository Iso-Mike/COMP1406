package Events;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class SimpleButtonEventTest extends Application {
  private int numClicks;
  
  public void start(Stage primaryStage) {
    numClicks = 0;
    //Create the base Pane
    Pane aPane = new Pane();
    
    //Create and positon a new Button
    Button aButton = new Button("Press Me");
    aButton.relocate(10, 10);
    aButton.setPrefSize(100, 30);
    aPane.getChildren().add(aButton);
    
    //Create a label to display the number of clicks
    Label clicks = new Label("Clicks: " + numClicks);
    clicks.relocate(125,15);
    aPane.getChildren().add(clicks);
    
    // Define an event handler
    //Attach the event handler to the button
    aButton.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent event) {
        //Add code here to update the state of the 'model'
        //Add code here to update the 'view'
        numClicks++;
        clicks.setText("Clicks: " + numClicks);
      }
    });
    
    primaryStage.setTitle("Making a Handler"); // Set title of window
    primaryStage.setScene(new Scene(aPane, 300,50)); // Set size of window
    primaryStage.show();
  }

  public static void main(String[] args) { launch(args); }
} 