import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.event.*;
import javafx.scene.input.MouseEvent;

public class DVDCollectionApp1 extends Application {

    private DVDCollection model;
    public DVDCollectionApp1() {
        model = DVDCollection.example1();
    }

    public void start(Stage primaryStage) {
        Pane aPane = new Pane();

        // Create the view
        DVDCollectionAppView1 view = new DVDCollectionAppView1();
        view.update(model, -1);
        aPane.getChildren().add(view);

        view.getButtonPane().getAddButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                try {
                    String t = javax.swing.JOptionPane.showInputDialog("Please enter the title: ");
                    int y = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Please enter the year: "));
                    int l = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Please enter the length: "));

                    DVD newDVD = new DVD(t, y, l);
                    model.add(newDVD);
                }
                catch(NumberFormatException e) {
                    System.out.println("Please enter a valid value!");
                }
                view.update(model, model.getDVDList().length - 1);
            }
        });

        view.getButtonPane().getDeleteButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                if(view.getTitleList().getSelectionModel().getSelectedItem() != null) {
                    model.remove(view.getTitleList().getSelectionModel().getSelectedItem());
                    view.update(model, 0);
                }
            }
        });

        view.getTitleList().setOnMousePressed(new EventHandler<MouseEvent>()
        {
            public void handle(MouseEvent mouseEvent) {
                view.update(model, view.getTitleList().getSelectionModel().getSelectedIndex());
            }
        });

        view.getYearList().setOnMousePressed(new EventHandler<MouseEvent>()
        {
            public void handle(MouseEvent mouseEvent) {
                view.update(model, view.getYearList().getSelectionModel().getSelectedIndex());
            }
        });

        view.getLengthList().setOnMousePressed(new EventHandler<MouseEvent>()
        {
            public void handle(MouseEvent mouseEvent) {
                view.update(model, view.getLengthList().getSelectionModel().getSelectedIndex());
            }
        });

        primaryStage.setTitle("My DVD Collection");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(aPane));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}