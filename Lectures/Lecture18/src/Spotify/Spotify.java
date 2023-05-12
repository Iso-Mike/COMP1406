package Spotify;
import javafx.scene.effect.Light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.*;
public class Spotify implements Serializable {
    private Map<String, Map<Integer, SpotifyObject>> data;
    /*
    data maps String (media type) to map of media
       map of media maps integer (objectid) to an actual spotify object
     */

    public List<SpotifyObject> getMediaListFor(String mediaType, String keyword){
        List<SpotifyObject> result = new ArrayList<>();

        Map<Integer, SpotifyObject> mediaMap = data.get(mediaType);
        if(mediaMap != null){
            for(int objectId: mediaMap.keySet()){
                SpotifyObject object = mediaMap.get(objectId);
                if(object.matchesSearch(keyword)){
                    result.add(object);
                }
            }
        }

        Collections.sort(result);

        return result;
    }

    public List<SpotifyObject> getMediaListFor(String mediaType){
        return getMediaListFor(mediaType, "");
    }


    public List<String> getMediaTypeList(){
        List<String> mediaTypes = new ArrayList<>();
        for(String key: data.keySet()){
            mediaTypes.add(key);
        }
        Collections.sort(mediaTypes);
        return mediaTypes;
    }

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

    //Returns the SpotifyObject with the given unique ID,
    //if one exists in this Spotify object's data.
    //Returns null if an object with that ID is not found.
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

    //Loads songs and artists
    //Note: this is not completed for ALL media types
    //Instead, we switched to use ObjectOutputStream to write the object directly
    public static Spotify load(BufferedReader in) throws IOException {
        //Implement this to load from a file
        Spotify s = new Spotify();

        int numSongs = Integer.parseInt(in.readLine());
        for(int i = 0; i < numSongs; i++){
            //read a song from 'in'
            s.addMedia(Song.load(in, s));
        }

        int numArtists = Integer.parseInt(in.readLine());
        for(int i = 0; i < numArtists; i++){
            //read an artist from 'in'
            s.addMedia(Artist.load(in));
        }

        return s;
    }

    //Saves songs and artists to a file
    //Note: this is not completed for ALL media types
    //Instead, we switched to use ObjectInputStream to read the object directly
    public  void save(PrintWriter out){
        out.println(data.get("Songs").size());
        for(int objectId: data.get("Songs").keySet()){
            ((Song)data.get("Songs").get(objectId)).save(out);
        }
        out.println(data.get("Artists").size());
        for(int objectId: data.get("Artists").keySet()){
            ((Artist)data.get("Artists").get(objectId)).save(out);
        }
    }
}
