package Spotify;

public class Song {
    private int songId;
    private String title;
    private Artist artist;
    private String lyrics;
    private static int nextSongId = 0;

    public Song(String title, Artist artist, String lyrics){
        this.lyrics = lyrics;
        this.artist = artist;
        this.title = title;
        songId = nextSongId++;
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

    public boolean matchesSearchWord(String word){
        word = word.toLowerCase();
        if(title.toLowerCase().contains(word)){
            return true;
        }

        if(lyrics.toLowerCase().contains(word)){
            return true;
        }

        if(artist.getName().toLowerCase().contains(word)){
            return true;
        }

        return false;
    }

    public String toString(){
        return title + " by " + artist.getName();
    }

    //You can ignore this for now
    //Just a way to determine if two songs are equal
    public boolean equals(Object o){
        if(o == null){
            return false;
        }

        if(o instanceof Song){
            return ((Song) o).songId == this.songId;
        }
        return false;
    }
}
