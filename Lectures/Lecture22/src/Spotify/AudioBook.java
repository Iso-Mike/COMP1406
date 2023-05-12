package Spotify;

import java.util.Locale;

public class AudioBook extends SpotifyObject {
    private String title;
    private Artist artist;

    public AudioBook(String title, Artist artist){
        this.title = title;
        this.artist = artist;
    }

    public String toString(){
        return title + " by " + artist.getName();
    }

    public boolean matchesSearch(String search){
        return title.toLowerCase().contains(search.toLowerCase());
    }
    public String getMediaType(){
        return "Audiobooks";
    }
}
