package Spotify;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Array;
import java.util.*;
public class Spotify implements Serializable {
    private Map<String, Map<Integer, SpotifyObject>> data;

    public Spotify(){
        data = new HashMap();
    }

    /*
      {
        "Songs" -> { 3->songWithId3, 9->songWihtId9  },
        "Playlists" --> {}
      }

     */


    public int findShortestPathBetween(SpotifyObject o1, SpotifyObject o2){
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> distances = new LinkedList<>();
        List<Integer> visited = new ArrayList();
        queue.add(o1.getObjectId());
        distances.add(0);
        int endId = o2.getObjectId();

        while(!queue.isEmpty()){
            int curId = queue.remove();
            int curDist = distances.remove();
            visited.add(curId);

            if(curId == endId){
                return curDist;
            }

            for(int objectId: getObjectWithId(curId).getReferences()) {
                if (!visited.contains(objectId) && !queue.contains(objectId)) {
                    queue.add(objectId);
                    distances.add(curDist + 1);
                }
            }
        }
        return -1; //indicates no path possible
    }

    //Indirectly recursive method
    //Returns whether a path can be found between o1 and o2
    public boolean findPathBetween(SpotifyObject o1, SpotifyObject o2){
        return findPathBetween(o1, o2, new ArrayList<>());
    }

    //Directly recursive method
    //Returns whether a path can be found between start and end objects
    public boolean findPathBetween(SpotifyObject start, SpotifyObject end, List<Integer> visited){
        ///
        int startId = start.getObjectId();
        int endId = end.getObjectId();

        if(startId == endId){
            System.out.println(start);
            return true;
        }

        if (visited.contains(startId)) {
            return false;
        }

        visited.add(startId);

        for(int neighbourId: start.getReferences()){
            SpotifyObject neighbour = getObjectWithId(neighbourId);
            if(findPathBetween(neighbour, end, visited)){
                System.out.println(start);
                return true;
            }
        }

        return false;
    }

    //Generate a playlist from the given song
    //Works by following paths between songs/artists
    public Playlist generatePlaylistFromSong(Song s){
        Playlist p = new Playlist("Playlist for " + s);
        //Call the directly recursive method
        generatePlaylistFromSong(s, p, 0, new ArrayList<>());
        return p;
    }

    //Recursively crawl tree and add songs to the given playlist
    public void generatePlaylistFromSong(SpotifyObject s, Playlist p, int steps, List<Integer> visited){
        if(p.getSongs().size() >= 25){
            return;
        }

        if(steps > 6){
            return;
        }

        if(visited.contains(s.getObjectId())){
            return;
        }

        visited.add(s.getObjectId());

        if(s instanceof Song) {
            p.addSong((Song)s);
        }

        List<Integer> references = s.getReferences();
        Collections.shuffle(references);
        for(int objectId: references){
            generatePlaylistFromSong(getObjectWithId(objectId), p, steps+1, visited);
        }
    }

    public Artist findArtistByName(String s){
        for(int id: data.get("Artists").keySet()){
            Artist a = (Artist)data.get("Artists").get(id);
            if(a.getName().toLowerCase().equals(s.toLowerCase())){
                return a;
            }
        }
        return null;
    }

    public Song findSongByName(String s){
        for(int id: data.get("Songs").keySet()){
            Song song = (Song)data.get("Songs").get(id);
            if(song.getTitle().toLowerCase().equals(s.toLowerCase())){
                return song;
            }
        }
        return null;
    }

    public void removeMedia(SpotifyObject o){
        if(data.containsKey(o.getMediaType())){
            //there is a map of this media type
            if(data.get(o.getMediaType()).containsKey(o.getObjectId())){
                data.get(o.getMediaType()).remove(o.getObjectId());

                for(String mediaType: data.keySet()){
                    for(int objectId: data.get(mediaType).keySet()){
                        data.get(mediaType).get(objectId).removeReferencesFor(o.getObjectId());
                    }
                }
            }
        }
    }

    public List<String> getMediaTypeList(){
        List<String> list = new ArrayList<>();
        for(String key: data.keySet()){
            list.add(key);
        }
        Collections.sort(list);
        return list;
    }

    public List<SpotifyObject> getMediaForMediaType(String mediaType, String keyword){
        List<SpotifyObject> result = new ArrayList<>();
        if(data.containsKey(mediaType)){
            for(int objectId: data.get(mediaType).keySet()){
                if(data.get(mediaType).get(objectId).matchesSearch(keyword)){
                    result.add(data.get(mediaType).get(objectId));
                }
            }
        }
        Collections.sort(result);
        return result;
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
            s.addMedia(Artist.load(in, s));
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
