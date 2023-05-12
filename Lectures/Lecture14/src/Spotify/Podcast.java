package Spotify;
import java.util.*;
public class Podcast extends SpotifyObject {
    private String title;
    private Artist artist;
    private List<String> keywords;

    public Podcast(String title, Artist artist, List<String> keywords){
        this.title = title;
        this.artist = artist;
        this.keywords = keywords;
    }

    public String getTitle(){
        return title;
    }

    public Artist getArtist() {
        return artist;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    //Returns true if this podcast matches the given search argument
    public boolean matchesSearch(String str){
        str = str.toLowerCase();

        if(title.toLowerCase().contains(str)){
            return true;
        }

        if(artist.getName().toLowerCase().contains(str)){
            return true;
        }

        for(String keyword: keywords){
            if(keyword.toLowerCase().contains(str)){
                return true;
            }
        }

        return false;
    }

    public String getMediaType(){
        return "Podcasts";
    }
}
