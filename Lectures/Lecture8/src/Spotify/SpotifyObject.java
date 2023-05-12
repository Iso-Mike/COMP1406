package Spotify;

//Going to represent ALL types of media/searchable things that we have in spotify
public abstract class SpotifyObject {
    private int objectId;
    private static int nextObjectId = 0;

    public SpotifyObject(){
        objectId = nextObjectId++;
    }

    public abstract boolean matchesSearch(String search);

    public boolean equals(Object o){
        if(o instanceof SpotifyObject){
            return ((SpotifyObject)o).objectId == this.objectId;
        }
        return false;
    }

}
