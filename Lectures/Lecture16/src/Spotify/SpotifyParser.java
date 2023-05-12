package Spotify;

import java.io.*;

public class SpotifyParser {

    public static void main(String[] args){
        try {
            BufferedReader in = new BufferedReader(new FileReader("resources" + File.separator + "songs-and-artists.txt"));
            Spotify s = Spotify.load(in);
            in.close();

            //System.out.println(s);

           //s.search("card");
            s.search("foo");
            //s.search("walk");

            PrintWriter out = new PrintWriter(new FileWriter("resources" + File.separator + "saved-spotify.txt"));
            //s.save(out);
            out.close();

            //ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream("resources" + File.separator + "object-spotify.txt"));
            //objectOut.writeObject(s);

            ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream("resources" + File.separator + "object-spotify.txt"));
            Spotify newSpotify = (Spotify)objectIn.readObject();

            newSpotify.search("foo");


            //object input/output
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
