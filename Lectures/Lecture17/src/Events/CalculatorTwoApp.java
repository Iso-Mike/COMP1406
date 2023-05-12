package Events;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class CalculatorTwoApp extends Application {
  
  TextField valueField, answerField;
  RadioButton[] buttons;
  
  public void start(Stage primaryStage) {
    //Create a new base pane
    Pane aPane = new Pane();
    
    // Add the value label and text field
    Label label = new Label("Input X:");
    label.relocate(10,10); label.setPrefSize(100, 30);
    aPane.getChildren().add(label);
    valueField = new TextField();
    valueField.relocate(80,10); valueField.setPrefSize(140, 30);
    aPane.getChildren().add(valueField);
    
    // Add the "operation type" radio buttons to the window
    // and to a ButtonGroup so that only one is on at a time
    label = new Label("Operation:");
    label.relocate(10,55); label.setPrefSize(100, 30);
    aPane.getChildren().add(label);
    
    ToggleGroup operations = new ToggleGroup();
    buttons = new RadioButton[4];
    String[] buttonLabels = {"X + X", "X * X", "X ^ 0.5", "1 / X"};
    
    for (int i=0; i<4; i++) {
      //Create the button
      buttons[i] = new RadioButton(buttonLabels[i]);
      buttons[i].relocate(80, 60 + i*20);
      buttons[i].setPrefSize(150, 20);
      aPane.getChildren().add(buttons[i]);
      
      //Add the button to the ToggleGroup - only 1 in a ToggleGroup can be selected at any given time
      buttons[i].setToggleGroup(operations);
      
      //Add the action handler
      buttons[i].setOnAction(new EventHandler<ActionEvent>() {
        // This is the single event handler for all of the radio buttons
        public void handle(ActionEvent event) {
          //This just checks that the input is valid
          //We will talk about Exception Handling later in the course
          //For now, we will typically assume the correct values are entered
          if (!valueField.getText().matches("[-,+,0-9]+")) {
            answerField.setText("INVALID INPUT");
            return;
          }  
          
          //Get the number value
          //Get the button that was selected
          //Determine the result
          //Update the view with the correct result
          float value = Float.parseFloat(valueField.getText());
          double result = 0.0;

          RadioButton selected = (RadioButton)event.getSource();
          if(selected == buttons[0]){
            result = value + value;
          }else if(selected == buttons[1]){
            result = value * value;
          }else if(selected == buttons[2]){
            result = Math.sqrt(value);
          }else if(selected == buttons[3]){
            result = 1 / value;
          }
          answerField.setText(result + "");
        }
      });
    }
    // Add the answer label and text field
    label = new Label("Answer:");
    label.relocate(10,150); label.setPrefSize(100, 30);
    aPane.getChildren().add(label);
    answerField = new TextField();
    answerField.relocate(80,150);
    answerField.setPrefSize(140, 30);
    answerField.setEditable(false);
    aPane.getChildren().add(answerField);
    
    primaryStage.setTitle("Calc 2");
    primaryStage.setResizable(false);
    primaryStage.setScene(new Scene(aPane, 230,190));
    primaryStage.show();
  }
  public static void main(String[] args) { launch(args); } 

}