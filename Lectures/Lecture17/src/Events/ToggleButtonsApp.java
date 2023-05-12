package Events;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class ToggleButtonsApp extends Application {
  ToggleButton[][] buttons; // This will store all the Buttons
  
  
  public void start(Stage primaryStage) {
    Pane aPane = new Pane();
    buttons = new ToggleButton[4][3];
    for(int row=0; row<4; row++) {
      for (int col=0; col<3; col++) {
        buttons[row][col] = new ToggleButton();
        buttons[row][col].relocate(10+col*70, 10+row*70);
        buttons[row][col].setPrefSize(65,65);
        buttons[row][col].setOnAction(new EventHandler<ActionEvent>() {
         
          // This is the single event handler for all of the buttons
          public void handle(ActionEvent event) {
            // Now toggle the button's color
            ToggleButton source = (ToggleButton)event.getSource();
            source.toggle();
          }});
        
        //Random initialization of buttons
        //With 50% probability, toggle the button
        if(Math.random() < 0.5){
          buttons[row][col].toggle();
        }
        aPane.getChildren().add(buttons[row][col]);
      }
    }
    
    primaryStage.setTitle("Toggle"); // Set title of window
    primaryStage.setScene(new Scene(aPane, 225, 295)); // Set size of window
    primaryStage.show();
  }
 
  public static void main(String[] args) {
    launch(args);
  }
}