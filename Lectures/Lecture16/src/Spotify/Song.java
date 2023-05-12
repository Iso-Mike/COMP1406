package Spotify;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Song extends SpotifyObject{
    private String title;
    private String lyrics;
    private List<Integer> artists;
    private String label;
    private String youtube;
    private String spotify;
    private Spotify owner;

    public Song(int id, String title, List<Integer> artistIds, String label, String yt, String spot, Spotify owner){
        super(id);
        this.lyrics = "";
        this.title = title;
        this.artists = artistIds;
        this.label = label;
        this.youtube = yt;
        this.spotify = spot;
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public String getLyrics() {
        return lyrics;
    }

    public String getArtistNames(){
        String result = "";
        for(int artistId: artists){
            Artist artist = (Artist)owner.getObjectWithId(artistId);
            result += artist.getName() + ", ";
        }
        return result.substring(0, result.length()-2);
    }

    public String toString(){
        return title + " by " + getArtistNames();
    }

    //Returns true if this song matches the given search argument
    public boolean matchesSearch(String search){
        search = search.toLowerCase();

        if(title.toLowerCase().contains(search)){
            return true;
        }


        if(getArtistNames().toLowerCase().contains(search)){
            return true;
        }

        if(lyrics.toLowerCase().contains(search)){
            return true;
        }

        return false;
    }

    public String getMediaType(){
        return "Songs";
    }

    public static Song load(BufferedReader in, Spotify owner) throws IOException {
        int id = Integer.parseInt(in.readLine());
        String title = in.readLine();
        int numArtists = Integer.parseInt(in.readLine());
        List<Integer> artistIds = new ArrayList<>();
        for(int i = 0; i < numArtists; i++){
           artistIds.add(Integer.parseInt(in.readLine()));
        }
        String label = in.readLine();
        String youtube = in.readLine();
        String spotify = in.readLine();

        Song s = new Song(id, title, artistIds, label, youtube, spotify, owner);

        return s;
    }
}
