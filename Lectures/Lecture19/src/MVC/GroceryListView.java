package MVC;
import javafx.scene.layout.Pane;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class GroceryListView extends Pane{
  private ListView<String> groceryList;
  private Button addButton;
  private Button removeButton;
  private TextField newItemField;
  GroceryList model;

  public GroceryListView(GroceryList initModel){
    model = initModel;

    // Create and position the "new item" TextField
    newItemField = new TextField();
    newItemField.relocate(10, 10);
    newItemField.setPrefSize(150, 25);

    // Create and position the "Add" Button
    addButton = new Button("Add");
    addButton.relocate(175, 10);
    addButton.setPrefSize(100, 25);

    // Create and position the "Remove" Button
    removeButton = new Button("Remove");
    removeButton.relocate(175, 45);
    removeButton.setPrefSize(100, 25);

    // Create and position the ListView
    groceryList = new ListView<String>();
    groceryList.relocate(10, 45);
    groceryList.setPrefSize(150, 150);

    // Add all the components to the window
    getChildren().addAll(newItemField, addButton, removeButton, groceryList);
  }

  public Button getAddButton(){
    return addButton;
  }

  public Button getRemoveButton(){
    return removeButton;
  }

  public ListView<String> getList(){
    return groceryList;
  }

  public TextField getItemField(){
    return newItemField;
  }

  public void update(){
    ObservableList<String> list = FXCollections.observableArrayList(model.getItems());
    groceryList.setItems(list);

    if(newItemField.getText().length() == 0){
      addButton.setDisable(true);
    }else{
      addButton.setDisable(false);
    }

    int selection = groceryList.getSelectionModel().getSelectedIndex();
    if(selection == -1){
      removeButton.setDisable(true);
    }else{
      removeButton.setDisable(false);
    }
  }
}