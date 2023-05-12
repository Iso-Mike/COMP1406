package Events;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class MultipleButtonsApp extends Application {
  
  private Button[][] buttons; // This will store all the Buttons
  private TextField number; //This will hold the number that has been entered

  public void start(Stage primaryStage) {
    Pane aPane = new Pane();
    buttons = new Button[4][3];
    String[] buttonLabels = {"1","2","3","4","5","6","7","8","9","*","0","#"};
    
    number = new TextField("");
    number.relocate(10, 10);
    number.setPrefSize(205, 30);
    number.setEditable(false);
    aPane.getChildren().add(number);
        
    for(int row=0; row<4; row++) {
      for (int col=0; col<3; col++) {
        buttons[row][col] = new Button(buttonLabels[row*3+col]);
        buttons[row][col].relocate(10+col*70, 50+row*70);
        buttons[row][col].setPrefSize(65,65);
        
        buttons[row][col].setOnAction(new EventHandler<ActionEvent>() {
          // This is the single event handler for all of the buttons
          public void handle(ActionEvent actionEvent) {
            handleButtonClick(actionEvent);
          }
        });
        
        aPane.getChildren().add(buttons[row][col]);
      }
    }
    primaryStage.setTitle("Keypad"); // Set title of window
    primaryStage.setScene(new Scene(aPane, 225, 350)); // Set size of window
    primaryStage.show();
  }

  public void handleButtonClick(ActionEvent actionEvent){
    //Get the button that was pressed
    //Get the text of that button
    //Update the number field

    //The nice looking version
    Button clicked = (Button)actionEvent.getSource();
    String buttonText = clicked.getText();
    number.setText(number.getText() + buttonText);

    //The one-liner version
    //number.setText(number.getText() + ((Button)actionEvent.getSource()).getText());
  }
  
  public static void main(String[] args) {
    launch(args);
  }
}