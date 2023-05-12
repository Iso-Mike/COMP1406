package Basics;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.collections.ObservableList;

public class FruitListApp extends Application {
  public void start(Stage primaryStage) {
    //Create the main pane
    //We will add our components to it
    Pane aPane = new Pane();

    // Create and position the "new item" TextField
    TextField newItemField = new TextField();
    newItemField.relocate(10, 10);
    newItemField.setPrefSize(150, 25);

    // Create and position the "Add" Button
    Button addButton = new Button("Add");
    addButton.relocate(175, 10);
    addButton.setPrefSize(100, 25);

    // Create and position the "Remove" Button
    Button removeButton = new Button("Remove");
    removeButton.relocate(175, 45);
    removeButton.setPrefSize(100, 25);

    // Create and position the "fruit" ListView with some fruits in it
    ListView<String> fruitList = new ListView<String>();
    String[] fruits = {"Apples", "Oranges", "Bananas", "Cherries",
            "Lemons", "Pears", "Strawberries", "Peaches",
            "Pomegranates", "Nectarines", "Apricots"};
    //Requires import javafx.collections.ObservableList;
    //Creates an observable list
    ObservableList<String> list = FXCollections.observableArrayList(fruits);
    fruitList.setItems(list);
    fruitList.relocate(10, 45);
    fruitList.setPrefSize(150, 150);

    //Add some more items to the list
    //An ObservableList is 'observed' by the ListView
    //This means the ListView updates automatically if we modify the list
    list.add("Chocolate");
    list.add("Pizza");

    // Add all the components to the window
    aPane.getChildren().addAll(newItemField, addButton, removeButton, fruitList);

    primaryStage.setTitle("My Fruit List"); // Set title of window
    primaryStage.setScene(new Scene(aPane, 285,205)); // Set size of window
    primaryStage.show();
  }
  public static void main(String[] args) {
    launch(args);
  }
}