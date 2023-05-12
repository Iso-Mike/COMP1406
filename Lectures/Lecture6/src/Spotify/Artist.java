package Spotify;

public class Artist {
    private String name;

    public Artist(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //You can ignore this for now
    //Just a way to determine if two artists are equal
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
