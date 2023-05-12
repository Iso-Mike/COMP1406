package Spotify;

public class Song extends SpotifyObject{
    private String title;
    private Artist artist;
    private String lyrics;

    public Song(String title, Artist artist, String lyrics){
        this.lyrics = lyrics;
        this.artist = artist;
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public String getLyrics() {
        return lyrics;
    }

    public String toString(){
        return title + " by " + artist.getName();
    }

    public boolean matchesSearch(String search){
        search = search.toLowerCase();

        if(title.toLowerCase().contains(search)){
            return true;
        }

        if(artist.getName().toLowerCase().contains(search)){
            return true;
        }

        if(lyrics.toLowerCase().contains(search)){
            return true;
        }

        return false;
    }
}
