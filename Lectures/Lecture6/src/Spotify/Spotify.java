package Spotify;

public class Spotify {
    private Song[] songDatabase;
    private Playlist[] playlists;
    private User[] users;
    public final int MAX_SONGS = 1000;
    public final int MAX_PLAYLISTS = 1000;
    public final int MAX_USERS = 1000;

    public Spotify(){
        songDatabase = new Song[MAX_SONGS];
        playlists = new Playlist[MAX_PLAYLISTS];
        users = new User[MAX_USERS];
    }

    public boolean userExists(User u){
        for(int i = 0; i < users.length; i++){
            if(users[i] != null && users[i].equals(u)){
                return true;
            }
        }

        return false;
    }

    public boolean addUser(User u){
        if(userExists(u)){
            return false;
        }

        for(int i = 0; i < users.length; i++){
            if(users[i] == null){
                users[i] = u;
                return true;
            }
        }

        return false;
    }

    public boolean playlistExists(Playlist p){
        for(int i = 0; i < playlists.length; i++){
            if(playlists[i] != null && playlists[i].equals(p)){
                return true;
            }
        }
        return false;
    }

    public boolean addPlaylist(Playlist p){
        if(playlistExists(p)){
            return false;
        }

        for(int i = 0; i < playlists.length; i++){
            if(playlists[i] == null){
                playlists[i] = p;
                return true;
            }
        }

        return false;
    }

    public boolean songExists(Song s){
        for(int i = 0; i < songDatabase.length; i++){
            if(songDatabase[i] != null && songDatabase[i].equals(s)){
                return true;
            }
        }
        return false;
    }

    public boolean addSong(Song s){
        if(songExists(s)){
            return false;
        }

        for(int i = 0; i < songDatabase.length; i++){
            if(songDatabase[i] == null){
                songDatabase[i] = s;
                return true;
            }
        }

        return false;
    }

    public String toString(){
        String result = "This is Spotify\n\n";

        result += "Playlists:\n";
        for(int i = 0; i < playlists.length; i++){
            if(playlists[i] != null) {
                result += (i + 1) + ". " + playlists[i] + "\n";
            }
        }
        result += "\n";

        result += "Songs:\n";
        for(int i = 0; i < songDatabase.length; i++){
            if(songDatabase[i] != null) {
                result += (i + 1) + ". " + songDatabase[i] + "\n";
            }
        }
        result += "\n";

        result += "Users:\n";
        for(int i = 0; i < users.length; i++){
            if(users[i] != null) {
                result += (i + 1) + ". " + users[i] + "\n";
            }
        }
        result += "\n";

        return result;
    }

    /*
    Implement a search method that accepts a string to search for.
    Should print out songs that match (what does it mean to match?)
    Should also print out playlists that match (what does it mean to match?)
     */
    public void search(String search){
        search = search.toLowerCase();
        System.out.println("The songs that match are:");
        for(int i = 0; i < songDatabase.length; i++){
            if(songDatabase[i] != null && songDatabase[i].matchesSearchWord(search)){
                System.out.println(songDatabase[i]);
            }
        }

        System.out.println("The playlists that match are:");
        for(int i = 0; i < playlists.length; i++){
            if(playlists[i] != null && playlists[i].matchesSearchWord(search)){
                System.out.println(playlists[i]);
            }
        }
    }
}
