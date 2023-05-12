package Spotify;

import com.sun.javafx.css.SelectorPartitioning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Artist extends SpotifyObject {
    private String name;
    private List<Integer> songs;

    public Artist(int id, String name, List<Integer> songs){
        super(id);
        this.name = name;
        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return name;
    }

    public boolean matchesSearch(String search) {
        return name.toLowerCase().contains(search.toLowerCase());
    }

    @Override
    public String getMediaType() {
        return "Artists";
    }

    public static Artist load(BufferedReader in) throws IOException {
        int id = Integer.parseInt(in.readLine());
        String name = in.readLine();
        int numSongs = Integer.parseInt(in.readLine());

        List<Integer> songIds = new ArrayList();
        for(int i = 0; i < numSongs; i++){
            songIds.add(Integer.parseInt(in.readLine()));
        }

        return new Artist(id, name, songIds);


    }

    public void save(PrintWriter out){
        out.println(getObjectId());
        out.println(name);
        out.println(songs.size());
        for(Integer songId: songs) {
            out.println(songId);
        }
    }

    public int compareTo(SpotifyObject o){
        if(o instanceof Artist){
            return name.compareTo(((Artist)o).name);
        }

        return super.compareTo(o);
    }
}
