package Spotify;
import java.util.*;
public class User extends SpotifyObject {
    private String name;
    private Map<Song, Integer> listenCount;

    public User(String name){
        this.name = name;
        listenCount = new HashMap();
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return name;
    }

    //Returns true if this user matches the given search argument
    public boolean matchesSearch(String search) {
        return name.toLowerCase().contains(search.toLowerCase());
    }

    //Simulates playing a playlist in an ordered manner
    public void playPlaylist(Playlist p){
        System.out.println("Playing songs for playlist: " + p.getName());
        for(Song s: p.getSongs()) {
            listenToSong(s);
        }
    }

    //Simulates playing a playlist in shuffled order
    public void shufflePlaylist(Playlist p){
        System.out.println("Shuffling songs for playlist: " + p.getName());
        for(Song s: p.getShuffledSongs()) {
            listenToSong(s);
        }
    }

    public void createUserDrivenPlaylist(Playlist p){
        //play P songs with priority for songs the user likes

        //get a copy of the list
        //sort the list with comparator based on listen frequency

        /*
        {a, b, c, d, e}
        {a, a, a, a, b, b, b, b, b, b, c, d, d}
          Create a list copy of all the songs with duplicates for each time the song has been listened to
          While there are songs remaining
            Choose a random song in the copy
            ADd it to the result
            Remove all the copies of that song from the copy
         */
        List<Song> copy = p.getSongs();
        List<Song> candidates = new ArrayList<>();
        for(Song s: copy){
            if(!listenCount.containsKey(s)){
                candidates.add(s);
            }else{
               for(int i = 0; i < listenCount.get(s); i++){
                   candidates.add(s);
               }
            }
        }

        List<Song> result = new ArrayList<>();
        Random rand = new Random();
        while(result.size() < copy.size()){
            int index = rand.nextInt(candidates.size());
            Song toAdd = candidates.get(index);
            result.add(toAdd);
            candidates.removeAll(Arrays.asList(toAdd));
        }

        for(Song s: result){
            listenToSong(s);
        }
    }

    //Simulates the user listening to the given song
    public void listenToSong(Song s){
        if(!listenCount.containsKey(s)){
            listenCount.put(s, 0);
        }
        listenCount.put(s, listenCount.get(s) + 1);
        System.out.println(name + " listened to " + s);
    }

    public void printListeningHistory(){
        System.out.println(name + " has listedn to:");
        for(Song s: listenCount.keySet()){
            System.out.println(s + " x " + listenCount.get(s));
        }
    }

    public String getMediaType(){
        return "Users";
    }
}
