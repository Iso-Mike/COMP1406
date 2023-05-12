package Spotify;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.*;

public class SpotifyManager extends Application {
    private ListView<String> mediaTypeList;
    private ListView<SpotifyObject> mediaListList;
    private Button removeButton;
    private Button addButton;
    private Button displayMediaInfo;
    private TextField filterField;
    private Spotify spotify;

    @Override
    public void start(Stage stage) {

        ObjectInputStream objectIn = null;
        try {
            objectIn = new ObjectInputStream(new FileInputStream("resources" + File.separator + "final-object-spotify.txt"));
            spotify = (Spotify)objectIn.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Could not read the data. Stopping");
            System.exit(1);
        }

        Pane mainPane = new Pane();

        Label mediaTypeLabel = new Label("Media Types:");
        mediaTypeLabel.relocate(10, 10);
        mediaTypeLabel.setPrefSize(150, 20);
        mainPane.getChildren().add(mediaTypeLabel);

        Label mediaListLabel = new Label("List of Media:");
        mediaListLabel.relocate(170, 10);
        mediaListLabel.setPrefSize(150, 20);
        mainPane.getChildren().add(mediaListLabel);

        displayMediaInfo = new Button("View Media Information");
        displayMediaInfo.relocate(250, 10);
        displayMediaInfo.setPrefSize(150, 20);
        mainPane.getChildren().add(displayMediaInfo);
        displayMediaInfo.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent){handleViewInfo(); }
        });

        mediaTypeList = new ListView<String>();
        mediaTypeList.relocate(10, 40);
        mediaTypeList.setPrefSize(150, 420);
        mainPane.getChildren().add(mediaTypeList);
        mediaTypeList.setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e){handleMediaTypeSelection(); }
        });
        mediaTypeList.setItems(FXCollections.observableArrayList(spotify.getMediaTypeList()));

        mediaListList = new ListView<SpotifyObject>();
        mediaListList.relocate(170, 40);
        mediaListList.setPrefSize(350, 420);
        mainPane.getChildren().add(mediaListList);
        mediaListList.setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e){handleMediaListSelection(); }
        });

        removeButton = new Button("Remove Media");
        removeButton.relocate(10, 470);
        removeButton.setPrefSize(150, 30);
        mainPane.getChildren().add(removeButton);
        removeButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent){handleRemove(); }
        });

        Label filterLabel = new Label("Filter:");
        filterLabel.relocate(170,470);
        filterLabel.setPrefSize(40, 30);
        mainPane.getChildren().add(filterLabel);

        filterField = new TextField();
        filterField.relocate(210, 470);
        filterField.setPrefSize(150, 30);
        mainPane.getChildren().add(filterField);
        filterField.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e){handleFilterType(); }
        });

        addButton = new Button("Add New Media");
        addButton.relocate(370, 470);
        addButton.setPrefSize(150, 30);
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent){handleAdd(); }
        });
        mainPane.getChildren().add(addButton);

        stage.setTitle("Spotify Organizer");
        stage.setResizable(false);
        stage.setScene(new Scene(mainPane, 530, 510));
        stage.show();
    }

    public void handleMediaTypeSelection(){
        System.out.println("Media Type List Selected");
        String selectedMedia = mediaTypeList.getSelectionModel().getSelectedItem();
        mediaListList.setItems(FXCollections.observableArrayList(spotify.getMediaListFor(selectedMedia, filterField.getText())));
    }

    public void handleMediaListSelection(){
        System.out.println("Media List Selected");
    }

    public void handleRemove(){
        System.out.println("Remove Button Clicked");
    }

    public void handleViewInfo(){
        System.out.println("View Media Info Clicked");
        SpotifyObject media = mediaListList.getSelectionModel().getSelectedItem();
        ///what do we DO with the spotify object
        Alert alert = media.getInformationDialog();
        alert.showAndWait();
    }

    public void handleAdd(){
        System.out.println("Add Button Clicked");
    }

    public void handleFilterType(){
        System.out.println("User Typed in Filter");
        handleMediaTypeSelection();
    }

    public static void main(String[] args){
        initializeSpotifyData();
        launch(args);
    }

    public static void initializeSpotifyData(){
        try {
            BufferedReader in = new BufferedReader(new FileReader("resources" + File.separator + "songs-and-artists.txt"));
            Spotify s = Spotify.load(in);
            in.close();

            Playlist p = new Playlist("Foo Fighters Songs");
            Playlist p2 = new Playlist("Walking Songs");

            for(int i = 0; i < 2500;  i++) {
                SpotifyObject o = s.getObjectWithId(i);
                if(o instanceof Song){
                    Song song = (Song)o;
                    if(song.getArtistNames().contains("Foo Fighters")){
                        p.addSong(song);
                    }
                    if(song.matchesSearch("walk")){
                        p2.addSong(song);
                    }
                }
            }

            s.addMedia(p);
            s.addMedia(p2);

            ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream("resources" + File.separator + "final-object-spotify.txt"));
            objectOut.writeObject(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
