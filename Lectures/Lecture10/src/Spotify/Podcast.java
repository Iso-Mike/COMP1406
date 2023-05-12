package Spotify;

public class Podcast extends SpotifyObject {
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

    public boolean matchesSearch(String str){
        str = str.toLowerCase();

        if(title.toLowerCase().contains(str)){
            return true;
        }

        if(artist.getName().toLowerCase().contains(str)){
            return true;
        }

        for(int i = 0; i < keywords.length; i++){
            if(keywords[i].toLowerCase().contains(str)){
                return true;
            }
        }

        return false;
    }
}
