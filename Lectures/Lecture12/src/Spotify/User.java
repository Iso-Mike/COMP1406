package Spotify;
import java.util.*;
public class User extends SpotifyObject {
    private String name;

    public User(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return name;
    }

    @Override
    public boolean matchesSearch(String search) {
        return name.toLowerCase().contains(search.toLowerCase());
    }

    public void playPlaylist(Playlist p){
        ////
        List<Song> songs = p.getSongs();
        System.out.println("Playing playlist " + p.getName());
        for(Song s: songs){
            System.out.println(s);
        }

    }

    public void shufflePlaylist(Playlist p){
        List<Song> songs = p.shuffleSongs();
        System.out.println("Shuffling playlist " + p.getName());
        for(Song s: songs){
            System.out.println(s);
        }
    }
}
