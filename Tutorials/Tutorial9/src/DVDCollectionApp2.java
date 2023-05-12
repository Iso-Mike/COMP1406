import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.scene.input.MouseEvent;

public class DVDCollectionApp2 extends Application {
    private DVDCollection model;
    public DVDCollectionApp2() {
        model = DVDCollection.example1();
    }
    public void start(Stage primaryStage) {
        Pane  aPane = new Pane();

        // Create the labels
        Label label1 = new Label("DVDs");
        label1.relocate(10, 10);
        Label label2 = new Label("Title");
        label2.relocate(10, 202);
        Label label3 = new Label("Year");
        label3.relocate(10, 242);
        Label label4 = new Label("Length");
        label4.relocate(120, 242);

        // Create the TextFields
        TextField tField = new TextField();
        tField.setPrefSize(500, 30);
        tField.relocate(50, 202);
        TextField yField = new TextField();
        yField.setPrefSize(55, 30);
        yField.relocate(50, 240);
        TextField lField = new TextField();
        lField.setPrefSize(45, 30);
        lField.relocate(180, 240);

        // Create the lists
        ListView<DVD> tList = new ListView<DVD>();
        tList.setItems(FXCollections.observableArrayList(model.getDVDList()));
        tList.setPrefSize(540, 150);
        tList.relocate(10, 40);

        // Create the buttons
        DVDButtonPane buttonPane = new DVDButtonPane();
        buttonPane.relocate(250, 240);

        buttonPane.getAddButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (!tField.getText().isEmpty()) {
                    try {
                        int year = Integer.parseInt(yField.getText());
                        int length = Integer.parseInt(lField.getText());
                        DVD newDVD = new DVD(tField.getText(), year, length);
                        model.add(newDVD);
                    }
                    catch(NumberFormatException e) {
                        System.out.println("Enter a valid value!!!!!");
                    }
                    tList.setItems(FXCollections.observableArrayList(model.getDVDList()));
                }
            }
        });

        buttonPane.getDeleteButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if(tList.getSelectionModel().getSelectedItem() != null) {
                    model.remove(tList.getSelectionModel().getSelectedItem().getTitle());
                    tList.setItems(FXCollections.observableArrayList(model.getDVDList()));                }
            }
        });

        tList.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent != null) {
                    tField.setText(tList.getSelectionModel().getSelectedItem().getTitle());
                    yField.setText(String.valueOf(tList.getSelectionModel().getSelectedItem().getYear()));
                    lField.setText(String.valueOf(tList.getSelectionModel().getSelectedItem().getDuration()));
                }
            }
        });

        // Add all the components to the window
        aPane.getChildren().addAll(label1, label2, label3, label4, tField, yField,
                lField, tList, buttonPane);

        primaryStage.setTitle("My DVD Collection");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(aPane, 560,280));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
