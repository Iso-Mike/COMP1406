package Spotify;

public class Playlist extends SpotifyObject {
    private Song[] songs;
    private String name;
    private int numSongs;
    public static final int MAX_SONGS = 100;

    public Playlist(String initName){
        name = initName;
        numSongs = 0;
        songs = new Song[MAX_SONGS];
    }

    public boolean addSong(Song aSong){
        if(findSongIndex(aSong) >= 0){
            return false;
        }

        for(int i = 0; i < songs.length; i++){
            if(songs[i] == null){
                songs[i] = aSong;
                numSongs++;
                return true;
            }
        }

        return false;
    }

    private int findSongIndex(Song aSong){
        for(int i = 0; i < songs.length; i++){
            if(aSong.equals(songs[i])){
                return i;
            }
        }
        return -1;
    }

    private boolean swapSongs(int one, int two){
        if(one < 0 || one >= songs.length){
            return false;
        }

        if(two < 0 || two >= songs.length){
            return false;
        }

        Song temp = songs[one];
        songs[one] = songs[two];
        songs[two] = temp;
        return true;
    }

    public boolean moveUp(Song aSong){
        int songIndex = findSongIndex(aSong);
        return swapSongs(songIndex, songIndex-1);
    }

    public boolean moveDown(Song aSong){
        int songIndex = findSongIndex(aSong);
        return swapSongs(songIndex, songIndex+1);
    }

    public boolean matchesSearch(String search){
        return name.toLowerCase().contains(search.toLowerCase());
    }

    public void printSongs(){
        System.out.println("Songs for Playlist - " + name);
        for(int i = 0; i < songs.length; i++){
            if(songs[i] != null){
                System.out.println(songs[i]);
            }
        }
        System.out.println();
    }

    public String toString(){
        return name + " with " + numSongs + " songs";
    }

}
