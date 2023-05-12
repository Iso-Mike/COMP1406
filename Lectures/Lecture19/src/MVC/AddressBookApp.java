package MVC;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.scene.input.*;

public class AddressBookApp extends Application {
 AddressBook model;
 AddressBookView view;

 public void start(Stage primaryStage) {
  model = AddressBook.createBook();
  view = new AddressBookView(model);

  view.getAddButton().setOnAction(new EventHandler<ActionEvent>() {
   public void handle(ActionEvent actionEvent) { handleAdd(); }
  });

  view.getRemoveButton().setOnAction(new EventHandler<ActionEvent>() {
   public void handle(ActionEvent actionEvent){handleRemove(); }
  });

  view.getSaveButton().setOnAction(new EventHandler<ActionEvent>() {
   public void handle(ActionEvent actionEvent){handleSaveButton(); }
  });

  view.getNamesList().setOnMouseReleased(new EventHandler<MouseEvent>() {
   public void handle(MouseEvent e){handleListSelection(); }
  });

  view.getName().setOnKeyReleased(new EventHandler<KeyEvent>() {
   public void handle(KeyEvent e){handleTextType(); }
  });

  primaryStage.setTitle("Address Book App");
  primaryStage.setResizable(true);
  primaryStage.setScene(new Scene(view, 585,485)); // Set size of window
  primaryStage.show();
  view.update();
 }

 public static void main(String[] args) { launch(args); }

 public void handleAdd(){
  String name = view.getName().getText();
  if(name.length() > 0){
   model.addPerson(new Person(name));
   view.getName().setText("");
   view.update();
  }
 }

 public void handleRemove(){
  int index = view.getNamesList().getSelectionModel().getSelectedIndex();
  if(index >= 0){
   model.removePerson(index);
   view.getNamesList().getSelectionModel().clearSelection();
   view.update();
  }
 }

 public void handleListSelection(){
  view.update();
 }

 public void handleSaveButton(){
  int index = view.getNamesList().getSelectionModel().getSelectedIndex();
  if(index >= 0) {
   model.getPerson(index).setPrimary(view.getPrimaryPanel().createAddressFromFields());
   model.getPerson(index).setSecondary(view.getSecondaryPanel().createAddressFromFields());
   view.update();
  }
 }

 public void handleTextType(){
  view.update();
 }
}