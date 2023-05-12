package Spotify;
import java.util.*;
public class Spotify {
    private Map<String, Set<SpotifyObject>> data;

    public Spotify(){
        data = new HashMap();
    }

    public boolean addMedia(SpotifyObject o){
        if(o == null){
            return false;
        }

        if(!data.containsKey(o.getMediaType())){
            data.put(o.getMediaType(), new HashSet());
        }

        return data.get(o.getMediaType()).add(o);
    }

    //Prints out all of the playlists/users/media stored in this Spotify instance
    public String toString(){
        String result = "This is Spotify\n\n";

        for(String mediaType: data.keySet()){
            result += mediaType + ":\n";
            int i = 0;
            for(SpotifyObject o: data.get(mediaType)){
                result += (i + 1) + ". " + o + "\n";
                i++;
            }
            result += "\n";
        }

        return result;
    }

    //Prints out results that match the given search term in the items list
    public void printOutSearchMatches(Set<SpotifyObject> items, String search){
        for(SpotifyObject o: items){
            if(o.matchesSearch(search)){
                System.out.println(o);
            }
        }
    }

    /*
    Prints out the search results for a given search term.
    Searches various types of objects (playlists, songs, etc.)
     */
    public void search(String search){
        System.out.println("Search results for \"" + search + "\"");

        for(String mediaType: data.keySet()){
            System.out.println("Here are the " + mediaType + " that match:");
            printOutSearchMatches(data.get(mediaType), search);
        }
    }
}
