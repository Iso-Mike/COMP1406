package MVC;
import javafx.scene.layout.Pane;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
public class AddressBookView extends Pane{
  AddressBook model;
  ListView<String> namesList;
  AddressPane primaryAddress;
  AddressPane secondaryAddress;
  TextField newName;
  Button addNew;
  Button remove;
  Button save;

  public AddressBookView(AddressBook iModel){
    model = iModel;

    // Add the list
    namesList = new ListView<String>();
    namesList.relocate(10, 10);
    namesList.setPrefSize(150, 420);
    getChildren().add(namesList);

    // Now add an AddressPane
    primaryAddress = new AddressPane("HOME ADDRESS");
    primaryAddress.relocate(170,10);
    getChildren().add(primaryAddress);

    // Now add another AddressPane
    secondaryAddress = new AddressPane("ALTERNATE ADDRESS");
    secondaryAddress.relocate(170,230);
    getChildren().add(secondaryAddress);

    newName = new TextField();
    newName.relocate(10, 435);
    newName.setPrefSize(150,25);
    getChildren().add(newName);

    addNew = new Button("Add Person");
    addNew.relocate(170, 435);
    addNew.setPrefSize(100, 25);
    getChildren().add(addNew);

    remove = new Button("Remove Person");
    remove.relocate(280, 435);
    remove.setPrefSize(150, 25);
    getChildren().add(remove);

    save = new Button("Save Changes");
    save.relocate(440, 435);
    save.setPrefSize(140, 25);
    getChildren().add(save);

    update();
  }

  public TextField getName(){
    return newName;
  }

  public Button getAddButton(){
    return addNew;
  }

  public Button getRemoveButton(){
    return remove;
  }

  public Button getSaveButton(){
    return save;
  }

  public ListView getNamesList(){
    return namesList;
  }

  public AddressPane getPrimaryPanel(){
    return primaryAddress;
  }

  public AddressPane getSecondaryPanel(){
    return secondaryAddress;
  }

  public void update(){
    Person[] people = model.getPeople();
    String[] names = new String[model.getCurPeople()];
    for(int i = 0; i < names.length; i++){
      names[i] = people[i].getName();
    }

    namesList.setItems(FXCollections.observableArrayList(names));

    int selection = namesList.getSelectionModel().getSelectedIndex();
    if(selection >= 0){
      System.out.println(selection);
      Person curPerson = model.getPerson(selection);
      primaryAddress.updateFields(curPerson.getPrimary(), curPerson.getName());
      secondaryAddress.updateFields(curPerson.getSecondary(), curPerson.getName());
    }else{
      primaryAddress.updateFields(null, "");
      secondaryAddress.updateFields(null, "");
    }
  }
}