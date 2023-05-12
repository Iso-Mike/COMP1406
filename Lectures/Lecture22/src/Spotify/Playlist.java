package Spotify;

import java.util.*;
public class Playlist extends SpotifyObject {
    private List<Song> songs;
    private String name;
    public static final int MAX_SONGS = 100;

    public Playlist(String initName){
        name = initName;
        songs = new ArrayList();
    }

    public String getName(){
        return name;
    }

    //Returns an ordered list of the songs in this playlist
    public List<Song> getSongs(){
        List<Song> copy = new ArrayList();
        for(Song s: songs){
            copy.add(s);
        }
        return copy;
    }

    //Returns the songs of this playlist in a randomly shuffled order
    public List<Song> getShuffledSongs(){
        List<Song> copy = getSongs();
        Collections.shuffle(copy);
        return copy;
    }

    //Adds the given song to the playlist
    public boolean addSong(Song aSong){
        if(songs.contains(aSong) || aSong == null){
            return false;
        }

        songs.add(aSong);
        return true;
    }

    //Swaps the two songs at indices one/two, if they are valid
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

    //Moves the argument Song object 'up' one space in the playlist
    public boolean moveUp(Song aSong){
        int songIndex = songs.indexOf(aSong);
        return swapSongs(songIndex, songIndex-1);
    }

    //Moves the argument Song object 'down' one space in the playlist
    public boolean moveDown(Song aSong){
        int songIndex = songs.indexOf(aSong);
        return swapSongs(songIndex, songIndex+1);
    }

    //Returns true if this playlist matches the given search argument
    public boolean matchesSearch(String search){
        return name.toLowerCase().contains(search.toLowerCase());
    }

    //Prints out the ordered songs of this playlist
    public void printSongs(){
        System.out.println("Songs for Playlist - " + name);
        for(int i = 0; i < songs.size(); i++){
            System.out.println(songs.get(i));
        }
        System.out.println();
    }

    public String toString(){
        return name + " with " + songs.size() + " songs";
    }

    public String getMediaType(){
        return "Playlists";
    }

    /*public Alert getDisplayInformation(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Information for " + toString() + "(ID#" + getObjectId() +")");
        String result = "Name: " + name + "\n";
        result += "Songs in the playlist:\n";
        for(Song s: songs){
            result += s + "\n";
        }
        alert.setContentText(result);
        return alert;
    }*/

    public void removeReferencesFor(int objectId){
        //go through each song object
        //if that song's id == objectId
        //remove that song
        List<Song> toRemove = new ArrayList<>();
        for(Song s: songs){
            if(s.getObjectId() == objectId){
                toRemove.add(s);
            }
        }

        for(Song s: toRemove){
            songs.remove(s);
        }
    }
}
