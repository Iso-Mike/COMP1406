package Spotify;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Artist extends SpotifyObject {
    private String name;
    private List<Integer> songs;
    private Spotify owner;

    public Artist(int id, String name, List<Integer> songs, Spotify owner){
        super(id);
        this.name = name;
        this.songs = songs;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return name;
    }

    public boolean matchesSearch(String search) {
        return name.toLowerCase().contains(search.toLowerCase());
    }

    @Override
    public String getMediaType() {
        return "Artists";
    }

    public static Artist load(BufferedReader in, Spotify owner) throws IOException {
        int id = Integer.parseInt(in.readLine());
        String name = in.readLine();
        int numSongs = Integer.parseInt(in.readLine());

        List<Integer> songIds = new ArrayList();
        for(int i = 0; i < numSongs; i++){
            songIds.add(Integer.parseInt(in.readLine()));
        }

        return new Artist(id, name, songIds, owner);


    }

    public void save(PrintWriter out){
        out.println(getObjectId());
        out.println(name);
        out.println(songs.size());
        for(Integer songId: songs) {
            out.println(songId);
        }
    }

    public int compareTo(SpotifyObject o){
        if(o instanceof Artist) {
            return this.name.compareTo(((Artist)o).name);
        }
        return 0;
    }


    /*public Alert getDisplayInformation(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Information for " + toString() + "(ID#" + getObjectId() +")");
        String result = "Name: " + name + "\n";
        result += "Artist's Songs\n";
        for(int objectId: songs){
            SpotifyObject o = owner.getObjectWithId(objectId);
            if(o != null){
                result += o + "\n";
            }
        }
        alert.setContentText(result);
        return alert;
    }*/

    public List<Integer> getReferences(){
        List<Integer> references = new ArrayList<>();
        for(int objectId: songs){
            references.add(objectId);
        }

        return references;
    }

    public void removeReferencesFor(int objectId){
        songs.remove(Integer.valueOf(objectId));
    }
}
