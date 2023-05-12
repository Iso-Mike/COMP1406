package MVC;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class AddressPane extends Pane {
  TextField nameField, streetField, cityField, provinceField, postalField;

  //Constructor for our AddressPane
  ///Takes a String, which represents the title of the pane (e.g., 'Contact Address')
  public AddressPane(String title) {
    //Create an inner pane and set its style
    //This will hold all our components
    Pane innerPane = new Pane();
    innerPane.setStyle("-fx-background-color: white; " +
            "-fx-border-color: gray; " +
            "-fx-padding: 4 4;"); // margin spacing at bottom right

    // Create the labels and textfields
    Label label1 = new Label("Name:");
    label1.relocate(10, 20);
    label1.setPrefSize(80, 30);
    Label label2 = new Label("Street:");
    label2.relocate(10, 55);
    label2.setPrefSize(80, 30);
    Label label3 = new Label("City:");
    label3.relocate(10, 90);
    label3.setPrefSize(80, 30);
    Label label4 = new Label("Province:");
    label4.relocate(10, 125);
    label4.setPrefSize(80, 30);
    Label label5 = new Label("Postal Code:");
    label5.relocate(10, 160);
    label5.setPrefSize(80, 30);

    nameField = new TextField();
    nameField.relocate(100, 20);
    nameField.setPrefSize(300, 30);
    streetField = new TextField();
    streetField.relocate(100, 55);
    streetField.setPrefSize(300, 30);
    cityField = new TextField();
    cityField.relocate(100, 90);
    cityField.setPrefSize(300, 30);
    provinceField = new TextField();
    provinceField.relocate(100, 125);
    provinceField.setPrefSize(300, 30);
    postalField = new TextField();
    postalField.relocate(100, 160);
    postalField.setPrefSize(300, 30);

    // Add all labels and textfields to the pane
    innerPane.getChildren().addAll(label1, label2, label3, label4, label5,
            nameField, streetField, cityField, provinceField, postalField);

    // Make a title for border and add it as well as inner pane to main pane
    Label titleLabel = new Label(); // Title to be placed onto border
    titleLabel.setText(title); // Incoming constructor parameter
    titleLabel.setStyle("-fx-background-color: white; \n" +
            "-fx-translate-y: -8; \n" +
            "-fx-translate-x: 10;");
    getChildren().addAll(innerPane, titleLabel);
  }

  public TextField getNameField(){
    return nameField;
  }

  public TextField getStreetField(){
    return streetField;
  }

  public TextField getCityField(){
    return cityField;
  }

  public TextField getPostalField(){
    return postalField;
  }

  public TextField getProvinceField(){
    return provinceField;
  }

  public void updateFields(Address newAddress, String name){
    if(newAddress != null){
      nameField.setText(name);
      streetField.setText(newAddress.getStreet());
      cityField.setText(newAddress.getCity());
      postalField.setText(newAddress.getPostalCode());
      provinceField.setText(newAddress.getProvince());
    }else{
      nameField.setText("");
      streetField.setText("");
      cityField.setText("");
      postalField.setText("");
      provinceField.setText("");
    }
  }

  public Address createAddressFromFields(){
    String street = streetField.getText();
    String city = cityField.getText();
    String prov = provinceField.getText();
    String post = postalField.getText();
    return new Address(street, city, prov, post);
  }

}