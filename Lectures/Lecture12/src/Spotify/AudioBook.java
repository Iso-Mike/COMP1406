package Spotify;

public class AudioBook {
    private String title;
    private Artist artist;

    public AudioBook(String title, Artist artist){
        this.title = title;
        this.artist = artist;
    }

    public String toString(){
        return title + " by " + artist.getName();
    }
}
