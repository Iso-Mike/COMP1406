package Spotify;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Song extends SpotifyObject{
    private String title;
    private String lyrics;
    private List<Integer> artists;
    private String label;
    private String youtube;
    private String spotify;
    private Spotify owner;


    public Song(String title, List<Integer> artistIds, String label, String yt, String spot, Spotify owner){
        super();
        this.lyrics = "";
        this.title = title;
        artists = artistIds;
        this.label = label;
        youtube = yt;
        spotify = spot;
        this.owner = owner;
    }

    public Song(int id, String title, List<Integer> artistIds, String label, String yt, String spot, Spotify owner){
        super(id);
        this.lyrics = "";
        this.title = title;
        artists = artistIds;
        this.label = label;
        youtube = yt;
        spotify = spot;
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public String getLyrics() {
        return lyrics;
    }

    public String getArtistNames(){
        String result = "";
        for(int id: artists){
            Artist a = (Artist)owner.getObjectWithId(id);
            result += a.getName() + ", ";
        }
        return result.substring(0,result.length()-2);
    }

    public String toString(){
        return title + " by " + getArtistNames();
    }

    //Returns true if this song matches the given search argument
    public boolean matchesSearch(String search){
        search = search.toLowerCase();

        if(title.toLowerCase().contains(search)){
            return true;
        }


        if(getArtistNames().toLowerCase().contains(search)){
            return true;
        }


        if(lyrics.toLowerCase().contains(search)){
            return true;
        }

        return false;
    }

    public String getMediaType(){
        return "Songs";
    }

    public static Song load(BufferedReader in, Spotify owner) throws IOException {
        int id = Integer.parseInt(in.readLine());
        String title = in.readLine();
        int numArtists = Integer.parseInt(in.readLine());

        List<Integer> artistIds = new ArrayList();
        for(int i = 0; i < numArtists; i++){
            artistIds.add(Integer.parseInt(in.readLine()));
        }

        String label = in.readLine();
        String yt = in.readLine();
        String spot = in.readLine();

        Song s = new Song(id, title, artistIds, label, yt, spot, owner);
        return s;

    }

    public void save(PrintWriter out){
        out.println(getObjectId());
        out.println(title);
        out.println(artists.size());
        for(Integer artistId: artists){
            out.println(artistId);
        }
        out.println(label);
        out.println(youtube);
        out.println(spotify);
    }

    public int compareTo(SpotifyObject o){
        if(o instanceof Song) {
            return this.title.compareTo(((Song)o).title);
        }
        return 0;
    }

    /*public Alert getDisplayInformation(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Information for " + toString() + "(ID#" + getObjectId() +")");
        String result = "Title: " + title + "\n";
        result += "Artists: " + getArtistNames() + "\n";
        result += "Label: " + label + "\n";
        result += "YouTube: " + youtube;

        alert.setContentText(result);
        return alert;
    }*/

    public List<Integer> getReferences(){
        List<Integer> references = new ArrayList<>();
        for(int objectId: artists){
            references.add(objectId);
        }

        return references;
    }

    public void removeReferencesFor(int objectId){
        artists.remove(Integer.valueOf(objectId));
    }
}
