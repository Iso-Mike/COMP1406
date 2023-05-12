package Spotify;

public class Podcast extends SpotifyObject {
    private int podcastId;
    private String title;
    private Artist artist;
    private String[] keywords;

    public Podcast(String title, Artist artist, String[] keywords){
        this.title = title;
        this.artist = artist;
        this.keywords = keywords;
    }

    public String getTitle(){
        return title;
    }

    public Artist getArtist() {
        return artist;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public boolean matchesSearch(String search){
        search = search.toLowerCase();

        if(title.toLowerCase().contains(search)){
            return true;
        }

        if(artist.getName().toLowerCase().contains(search)){
            return true;
        }

        for(int i = 0; i < keywords.length; i++){
            if(keywords[i].toLowerCase().contains(search)){
                return true;
            }
        }

        return false;
    }
}
