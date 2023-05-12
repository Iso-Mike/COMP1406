package Spotify;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.*;
public class Spotify implements Serializable {
    private Map<String, Map<Integer, SpotifyObject>> data;

    public Spotify(){
        data = new HashMap();

    }

    public boolean addMedia(SpotifyObject o){
        if(o == null){
            return false;
        }

        if(!data.containsKey(o.getMediaType())){
            data.put(o.getMediaType(), new HashMap());
        }

        if(data.get(o.getMediaType()).containsKey(o.getObjectId())){
            return false;
        }

        data.get(o.getMediaType()).put(o.getObjectId(), o);
        return true;
    }

    public SpotifyObject getObjectWithId(int id){
        for(String mediaType: data.keySet()){
            if(data.get(mediaType).containsKey(id)){
                return data.get(mediaType).get(id);
            }
        }
        return null;
    }

    //Prints out all of the playlists/users/media stored in this Spotify instance
    public String toString(){
        String result = "This is Spotify\n\n";

        for(String mediaType: data.keySet()){
            result += mediaType + ":\n";
            int i = 0;
            for(Integer id: data.get(mediaType).keySet()){
                result += (i + 1) + ". " + data.get(mediaType).get(id) + "\n";
                i++;
            }
            result += "\n";
        }

        return result;
    }

    //Prints out results that match the given search term in the items list
    public void printOutSearchMatches(Map<Integer, SpotifyObject> items, String search){
        for(Integer id: items.keySet()){
            if(items.get(id).matchesSearch(search)){
                System.out.println(items.get(id));
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

    public static Spotify load(BufferedReader in) throws IOException {
        //Implement this to load from a file
        Spotify s = new Spotify();

        int numSongs = Integer.parseInt(in.readLine());
        for(int i = 0; i < numSongs; i++){
            s.addMedia(Song.load(in, s));
        }

        int numArtists = Integer.parseInt(in.readLine());
        for(int i = 0; i < numArtists; i++){
            //load a artist from the file
            s.addMedia(Artist.load(in));
        }

        return s;
    }

    public  void save(PrintWriter out){
        //Implement this to load from a file
        return;
    }
}
