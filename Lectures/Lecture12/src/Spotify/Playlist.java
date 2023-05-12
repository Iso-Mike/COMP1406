package Spotify;
import java.util.*;
public class Playlist extends SpotifyObject {
    private List<Song> songs;
    private String name;
    private int numSongs;
    public static final int MAX_SONGS = 100;

    public Playlist(String initName){
        name = initName;
        numSongs = 0;
        songs = new ArrayList<Song>();
    }

    public String getName(){
        return name;
    }

    public List<Song> getSongs(){
        List<Song> copy = new ArrayList<Song>();
        for(Song s: songs){
            copy.add(s);
        }
        return copy;
    }

    public List<Song> shuffleSongs(){
        List<Song> copy =  getSongs();
        Random rand = new Random();
        Collections.shuffle(copy);
        return copy;
    }

    public boolean addSong(Song aSong){
        if(songs.contains(aSong) || aSong == null){
            return false;
        }

        songs.add(aSong);
        return true;
    }

    private boolean swapSongs(int one, int two){
        if(one < 0 || one >= songs.size()){
            return false;
        }

        if(two < 0 || two >= songs.size()){
            return false;
        }

        Song temp = songs.get(one);
        songs.set(one, songs.get(two));
        songs.set(two, temp);
        return true;
    }

    public boolean moveUp(Song aSong){
        int songIndex = songs.indexOf(aSong);
        return swapSongs(songIndex, songIndex-1);
    }

    public boolean moveDown(Song aSong){
        int songIndex = songs.indexOf(aSong);
        return swapSongs(songIndex, songIndex+1);
    }

    public boolean matchesSearch(String search){
        return name.toLowerCase().contains(search.toLowerCase());
    }

    public void printSongs(){
        System.out.println("Songs for Playlist - " + name);
        for(int i = 0; i < songs.size(); i++){
            if(songs.get(i) != null){
                System.out.println(songs.get(i));
            }
        }
        System.out.println();
    }

    public String toString(){
        return name + " with " + numSongs + " songs";
    }

}
