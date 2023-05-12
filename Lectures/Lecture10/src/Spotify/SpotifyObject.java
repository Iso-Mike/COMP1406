package Spotify;

public abstract class SpotifyObject {
    private int objectId;
    private static int nextObjectId = 0;

    public SpotifyObject(){
        objectId = nextObjectId++;
    }

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
}
