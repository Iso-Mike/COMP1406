package Spotify;

public class Artist {
    private String name;

    public Artist(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return name;
    }

    //Returns true if the calling Artist is the same as argument o
    public boolean equals(Object o){
        if(o == null){
            return false;
        }

        if(o instanceof Artist){
            return ((Artist) o).name.equals(this.name);
        }
        return false;
    }
}
