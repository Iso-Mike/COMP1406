package Spotify;

public abstract class SpotifyObject {
    private int objectId;
    private static int nextObjectId = 0;

    public SpotifyObject(){
        objectId = nextObjectId++;
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

    public abstract boolean matchesSearch(String search);
    public abstract String getMediaType();
}
