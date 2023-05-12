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
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class SpotifyManager extends Application {
    private Spotify spotify;
    private SpotifyView view;
    private Stage stage;

    @Override
    public void start(Stage stage) {
        this.stage = stage;

        ObjectInputStream objectIn = null;
        try {
            objectIn = new ObjectInputStream(new FileInputStream("resources" + File.separator + "final-object-spotify.txt"));
            spotify = (Spotify)objectIn.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Could not read the data. Stopping.");
            System.exit(1);
        }

        view = new SpotifyView(spotify);

        view.displayMediaInfo.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent){handleViewInfo(); }
        });

        view.mediaTypeList.setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e){handleMediaTypeSelection(); }
        });

        view.mediaListList.setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e){handleMediaListSelection(); }
        });

        view.removeButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent){handleRemove(); }
        });



        view.filterField.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e){handleFilterType(); }
        });


        view.addButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent){handleAdd(); }
        });


        stage.setTitle("Spotify Organizer");
        stage.setResizable(false);
        stage.setScene(new Scene(view, 530, 510));
        stage.show();

        view.update();
    }

    public void handleMediaTypeSelection(){
        System.out.println("Media Type List Selected");
        view.update();
    }

    public void handleMediaListSelection(){
        System.out.println("Media List Selected");
    }

    public void handleRemove(){
        System.out.println("Remove Button Clicked");
        //use the method for removing (in spotify)
        SpotifyObject selected = view.getSelectedMedia();
        if(selected != null) {
            spotify.removeMedia(selected);
            view.update();
        }
    }

    public void handleViewInfo(){
        System.out.println("View Media Info Clicked");
        SpotifyObject selected = view.getSelectedMedia();
        if(selected != null){
            selected.getDisplayInformation().showAndWait();
        }else{
            System.out.println("Good thing we checked it wasn't null.");
        }
    }

    public void handleAdd(){
        System.out.println("Add Button Clicked");

        //show that dialog
        //get a new song object back (or null)
        //if it's not null, add it to the model

        Dialog dialog = new AddSongDialog(stage, spotify);
        Optional<Song> result = dialog.showAndWait();
        if (result.isPresent()) {
            //Use result.get() to retrieve song object
            Song s = result.get();
            if(s != null){
                spotify.addMedia(s);
                view.update();
            }
        }
    }

    public void handleFilterType(){
        System.out.println("User Typed in Filter");
        view.update();
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
