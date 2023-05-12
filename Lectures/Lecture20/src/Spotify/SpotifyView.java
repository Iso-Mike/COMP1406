package Spotify;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.util.List;

public class SpotifyView extends Pane {
    protected ListView<String> mediaTypeList;
    protected ListView<SpotifyObject> mediaListList;
    protected Button removeButton;
    protected Button addButton;
    protected Button displayMediaInfo;
    protected TextField filterField;
    private Spotify spotify;

    public SpotifyView(Spotify model){
        spotify = model;

        Label mediaTypeLabel = new Label("Media Types:");
        mediaTypeLabel.relocate(10, 10);
        mediaTypeLabel.setPrefSize(150, 20);
        getChildren().add(mediaTypeLabel);

        Label mediaListLabel = new Label("List of Media:");
        mediaListLabel.relocate(170, 10);
        mediaListLabel.setPrefSize(150, 20);
        getChildren().add(mediaListLabel);

        displayMediaInfo = new Button("View Media Information");
        displayMediaInfo.relocate(250, 10);
        displayMediaInfo.setPrefSize(150, 20);
        getChildren().add(displayMediaInfo);

        mediaTypeList = new ListView<String>();
        mediaTypeList.relocate(10, 40);
        mediaTypeList.setPrefSize(150, 420);
        getChildren().add(mediaTypeList);

        mediaListList = new ListView<SpotifyObject>();
        mediaListList.relocate(170, 40);
        mediaListList.setPrefSize(350, 420);
        getChildren().add(mediaListList);

        removeButton = new Button("Remove Media");
        removeButton.relocate(10, 470);
        removeButton.setPrefSize(150, 30);
        getChildren().add(removeButton);


        Label filterLabel = new Label("Filter:");
        filterLabel.relocate(170,470);
        filterLabel.setPrefSize(40, 30);
        getChildren().add(filterLabel);

        filterField = new TextField();
        filterField.relocate(210, 470);
        filterField.setPrefSize(150, 30);
        getChildren().add(filterField);


        addButton = new Button("Add New Media");
        addButton.relocate(370, 470);
        addButton.setPrefSize(150, 30);
        getChildren().add(addButton);
    }

    public SpotifyObject getSelectedMedia(){
        return mediaListList.getSelectionModel().getSelectedItem();
    }

    //The model has changed in some way
    //So update everything on the screen to match the current model contents
    public void update(){
        mediaTypeList.setItems(FXCollections.observableArrayList(spotify.getMediaTypeList()));

        String selectedMedia = mediaTypeList.getSelectionModel().getSelectedItem();
        List<SpotifyObject> media = spotify.getMediaForMediaType(selectedMedia, filterField.getText());
        mediaListList.setItems(FXCollections.observableArrayList(media));
    }
}
