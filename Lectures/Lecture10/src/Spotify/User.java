package Spotify;

public class User extends SpotifyObject {
    private String name;

    public User(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return name;
    }

    @Override
    public boolean matchesSearch(String search) {
        return name.toLowerCase().contains(search.toLowerCase());
    }
}
