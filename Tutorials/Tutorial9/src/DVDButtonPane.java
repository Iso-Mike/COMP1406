import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class DVDButtonPane extends Pane {
    private Button addButton;
    private Button deleteButton;
    public DVDButtonPane() {
        addButton = new Button("Add");
        addButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(2,98,2); " +
                "-fx-text-fill: rgb(255,255,255);");
        addButton.relocate(0,0);
        addButton.setPrefSize(90, 30);

        deleteButton = new Button("Delete");
        deleteButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(192,4,4); " +
                "-fx-text-fill: rgb(255,255,255);");
        deleteButton.relocate(100,0);
        deleteButton.setPrefSize(90, 30);

        Button statsButton = new Button("Stats");
        statsButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(232,232,232); " +
                "-fx-text-fill: rgb(95,87,116);");
        statsButton.relocate(210,0);
        statsButton.setPrefSize(90, 30);

        getChildren().addAll(addButton, deleteButton, statsButton);
    }
    public Button getAddButton() {
        return addButton;
    }
    public Button getDeleteButton() {
        return deleteButton;
    }
}
