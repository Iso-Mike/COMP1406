package Spotify;

import javafx.scene.control.Alert;

import java.io.Serializable;

public abstract class SpotifyObject implements Serializable, Comparable<SpotifyObject> {
    private int objectId;
    private static int nextObjectId = 0;

    public SpotifyObject(){
        objectId = nextObjectId++;
    }

    public SpotifyObject(int id){
        objectId = id;
        nextObjectId = Math.max(objectId+1, nextObjectId);
    }

    public int getObjectId(){
        return objectId;
    }
    //Returns true if the calling SpotifyObject is identical to o
    public boolean equals(Object o){
        if(o == null){
            return false;
        }

        if(o instanceof SpotifyObject){
            return ((SpotifyObject) o).objectId == this.objectId;
        }
        return false;
    }

    public int hashCode(){
        return objectId;
    }

    public abstract boolean matchesSearch(String search);
    public abstract String getMediaType();
    public void removeReferencesFor(int objectId){

    }

    public Alert getDisplayInformation(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Information for object id#" + objectId);
        alert.setContentText("id=" + objectId);
        return alert;
    }

    public int compareTo(SpotifyObject o){
        return 0;
    }
}
