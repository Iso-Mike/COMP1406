package Spotify;

import java.io.Serial;
import java.io.Serializable;

public abstract class SpotifyObject implements Serializable {
    private int objectId;
    private static int nextObjectId = 0;

    public SpotifyObject(){
        objectId = nextObjectId++;
    }

    public SpotifyObject(int id){
        objectId = id;
        nextObjectId = Math.max(id+1, nextObjectId);
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
}
