package MVC;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.collections.ObservableList;
public class GroceryListApp extends Application {
  GroceryList model;
  GroceryListView view;

  public void start(Stage primaryStage) {
    model = new GroceryList();
    model.addItem("Banana");
    model.addItem("Apple");
    view = new GroceryListView(model);

    //What did we have here before?
    //..all of the code for creating the view
    //..all of the code for event handling
    //..even some code for the model
    //Very cluttered, not modular, hard to work with, hard to modify

    view.getAddButton().setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent actionEvent) {
        handleAdd();
      }
    });

    view.getRemoveButton().setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent actionEvent) { handleRemove(); }
    });

    view.getList().setOnMouseReleased(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent e){view.update(); }
    });

    view.getItemField().setOnKeyReleased(new EventHandler<KeyEvent>() {
      public void handle(KeyEvent e){view.update(); }
    });

    primaryStage.setTitle("My Grocery List"); // Set title of window
    primaryStage.setScene(new Scene(view, 285,205)); // Set size of window
    primaryStage.show();

    view.update();
  }
  public static void main(String[] args) {
    launch(args);
  }

  public void handleAdd(){
    ///gets the item name from the view
    //call the add method on the model
    //update the view
    String x = view.getItemField().getText();
    if(x.length() > 0){
      model.addItem(x);
      view.update();
      view.getItemField().setText("");
    }
  }

  public void handleRemove(){
    int selection = view.getList().getSelectionModel().getSelectedIndex();

    if(selection >= 0){
      model.removeItem(selection);
      view.update();
    }
  }
}