package Spotify;

import java.io.*;
import java.util.ArrayList;

public class SpotifyParser {

    public static void main(String[] args){
        try {
            BufferedReader in = new BufferedReader(new FileReader("resources" + File.separator + "songs-and-artists.txt"));
            Spotify s = Spotify.load(in);
            in.close();

            System.out.println(s);

            //s.search("card");
            s.search("foo");
            //s.search("walk");

            PrintWriter out = new PrintWriter(new FileWriter("resources" + File.separator + "saved-spotify.txt"));
            s.save(out);
            out.close();

            in = new BufferedReader(new FileReader("resources" + File.separator + "saved-spotify.txt"));
            s = Spotify.load(in);
            in.close();

            s.search("dave");

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

            ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream("resources" + File.separator + "object-spotify.txt"));
            objectOut.writeObject(s);

            ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream("resources" + File.separator + "object-spotify.txt"));
            Spotify newSpotify = (Spotify)objectIn.readObject();
            newSpotify.search("foo");

            objectOut = new ObjectOutputStream(new FileOutputStream("resources" + File.separator + "final-object-spotify.txt"));
            objectOut.writeObject(newSpotify);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
