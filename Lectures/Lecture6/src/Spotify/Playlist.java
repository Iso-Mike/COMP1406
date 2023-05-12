package Spotify;

public class Playlist {
    private Song[] songs;
    private String name;
    private int playlistId;
    private int numSongs;
    private static int nextPlaylistId = 0;
    public static final int MAX_SONGS = 100;

    public Playlist(String initName){
        name = initName;
        numSongs = 0;
        songs = new Song[MAX_SONGS];
        playlistId = nextPlaylistId++;
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

    public void printSongs(){
        System.out.println("Songs for Playlist - " + name);
        for(int i = 0; i < songs.length; i++){
            if(songs[i] != null){
                System.out.println(songs[i]);
            }
        }
        System.out.println();
    }

    public boolean matchesSearchWord(String word){
        word = word.toLowerCase();
        return name.toLowerCase().contains(word);
    }

    public String toString(){
        return name + " with " + numSongs + " songs";
    }

    //You can ignore this for now
    //Just a way to determine if two playlists are equal
    public boolean equals(Object o){
        if(o == null){
            return false;
        }

        if(o instanceof Playlist){
            return ((Playlist) o).playlistId == this.playlistId;
        }
        return false;
    }
}
