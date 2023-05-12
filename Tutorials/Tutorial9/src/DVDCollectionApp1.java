import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class DVDCollectionApp1  extends Application {
    public void start(Stage primaryStage) {
        DVDButtonPane innerPane = new DVDButtonPane();
        innerPane.relocate(30, 200);

        Pane aPane = new Pane();
        aPane.setStyle("-fx-background-color: rgb(244, 244, 244); " +
                "-fx-border-color: rgb(152, 160, 192); " +
                "-fx-padding: 1 1;");

        // Create the labels
        Label label1 = new Label("Title");
        label1.relocate(10, 5);
        label1.setPrefSize(80, 30);
        Label label2 = new Label("Year");
        label2.relocate(220, 5);
        label2.setPrefSize(80, 30);
        Label label3 = new Label("Length");
        label3.relocate(290, 5);
        label3.setPrefSize(80, 30);

        // Create the lists
        ListView<String> name = new ListView<String>();
        String[] titles = {"Star Wars", "Java is cool", "Mary Poppins", "The Green Mile"};
        ObservableList<String> list1 = FXCollections.observableArrayList(titles);
        name.setItems(list1);
        name.relocate(10, 40);
        name.setPrefSize(200, 150);

        ListView<String> date = new ListView<String>();
        String[] years = {"1978", "2002", "1968", "1999"};
        ObservableList<String> list2 = FXCollections.observableArrayList(years);
        date.setItems(list2);
        date.relocate(220, 40);
        date.setPrefSize(60, 150);

        ListView<String> runtime = new ListView<String>();
        String[] lengths = {"124", "93", "126", "148"};
        ObservableList<String> list3 = FXCollections.observableArrayList(lengths);
        runtime.setItems(list3);
        runtime.relocate(290, 40);
        runtime.setPrefSize(60, 150);

        // Don't forget to add the components to the window, set the title,
        // make it non-resizable, set Scene dimensions and then show the stage
        aPane.getChildren().addAll(label1, label2, label3, name, date, runtime, innerPane);

        primaryStage.setTitle("My DVD Collection");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(aPane, 360,240));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}