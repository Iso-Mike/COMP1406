package Spotify;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.List;

public class AddSongDialog extends Dialog {
    private Spotify model;

    public AddSongDialog(Stage owner, Spotify model){
        this.model = model;

        setTitle("Create New Song");

        //Plagiarising the textbook...
        //See Chapter 7 if you're interested
        ButtonType okButtonType = new ButtonType("OK",
                ButtonBar.ButtonData.OK_DONE);
        getDialogPane().getButtonTypes().addAll(okButtonType, ButtonType.CANCEL);


        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        TextField titleField = new TextField();
        titleField.setMinWidth(300);
        TextField artistField = new TextField();
        artistField.setMinWidth(300);
        TextField labelField = new TextField();
        labelField.setMinWidth(300);
        TextField youtubeField = new TextField();
        youtubeField.setMinWidth(300);
        TextField spotifyField = new TextField();
        spotifyField.setMinWidth(300);


        grid.add(new Label("Title:"), 0, 0);
        grid.add(titleField, 1, 0);
        grid.add(new Label("Artists:"), 0, 1);
        grid.add(artistField, 1, 1);
        grid.add(new Label("Label:"), 0, 2);
        grid.add(labelField, 1, 2);
        grid.add(new Label("YouTube:"), 0, 3);
        grid.add(youtubeField, 1, 3);
        grid.add(new Label("Spotify:"), 0, 4);
        grid.add(spotifyField, 1, 4);

        getDialogPane().setContent(grid);

        setResultConverter(new Callback<ButtonType, Song>() {
            public Song call(ButtonType b) {
                if (b == okButtonType) {
                    //Really, we should validate the information...
                    String title = titleField.getText();
                    String label = labelField.getText();
                    String youtube = youtubeField.getText();
                    String spotify = spotifyField.getText();
                    List<Integer> artists = new ArrayList<>();
                    String[] pieces = artistField.getText().split(",");
                    for(String piece: pieces){
                        artists.add(Integer.parseInt(piece));
                    }
                    Song s = new Song(title, artists, label, youtube, spotify, model);
                    return s;
                }
                return null;
            }
        });
    }
}
