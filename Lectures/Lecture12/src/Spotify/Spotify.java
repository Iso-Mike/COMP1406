package Spotify;
import java.util.*;

public class Spotify {
    private List<Song> songDatabase;
    private List<Playlist> playlists;
    private List<User> users;

    public Spotify(){
        songDatabase = new ArrayList();
        playlists = new ArrayList();
        users = new ArrayList();
    }

   public boolean addUser(User u){
        if(users.contains(u) || u == null){
            return false;
        }

        users.add(u);
        return true;
    }

    public boolean addPlaylist(Playlist p){
        if(playlists.contains(p) || p == null){
            return false;
        }

        playlists.add(p);
        return true;
    }

    public boolean addSong(Song s){
        if(songDatabase.contains(s) || s == null){
            return false;
        }

        songDatabase.add(s);
        return true;
    }

    public String toString(){
        String result = "This is Spotify\n\n";

        result += "Playlists:\n";
        for(int i = 0; i < playlists.size(); i++){
            result += (i + 1) + ". " + playlists.get(i) + "\n";
        }
        result += "\n";

        result += "Songs:\n";
        for(int i = 0; i < songDatabase.size(); i++){
            result += (i + 1) + ". " + songDatabase.get(i) + "\n";
        }
        result += "\n";

        result += "Users:\n";
        for(int i = 0; i < users.size(); i++){
            result += (i + 1) + ". " + users.get(i) + "\n";
        }
        result += "\n";

        return result;
    }

    public void printOutSearchMatches(List<? extends SpotifyObject> items, String search){
        for(int i = 0 ; i < items.size(); i++){
            if(items.get(i).matchesSearch(search)){
                System.out.println(items.get(i));
            }
        }
    }

    /*
    Implement a search method that accepts a string to search for.
    Should print out songs that match (what does it mean to match?)
    Should also print out playlists that match (what does it mean to match?)
     */
    public void search(String search){
        System.out.println("Search results for \"" + search + "\"");

        System.out.println("Here are the songs that match:");
        printOutSearchMatches(songDatabase, search);

        System.out.println("Here are the playlists that match:");
        printOutSearchMatches(playlists, search);

        System.out.print("Here are the users that match:");
        printOutSearchMatches(users, search);
    }
}
