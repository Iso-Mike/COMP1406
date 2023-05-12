import java.util.*;

public class MusicExchangeCenter {
    private List<User> users;
    private Map<String, Float> royalties;
    private List<Song> downloadedSongs;

    public MusicExchangeCenter() {
        users = new ArrayList<>();
        royalties = new HashMap<>();
        downloadedSongs = new ArrayList<>();
    }

    public List<Song> getDownloadedSongs() { return downloadedSongs; }

    public List<User> onlineUsers() {
        List<User> onlineUsers = new ArrayList<>();

        for(User i : users) {
            if(i.isOnline()) {
                onlineUsers.add(i);
            }
        }
        return onlineUsers;
    }

    public List<Song> allAvailableSongs() {
        List<Song> availableSong = new ArrayList<>();
        for(User i: onlineUsers()) {
            availableSong.addAll(i.getSongList());
        }
        return availableSong;
    }

    public String toString() {
        return "Music Exchange Center (" + onlineUsers().size() + " users online, " + allAvailableSongs().size() + " songs available)";
    }

    public User userWithName(String s) {
        for(User i: users) {
            if(i.getUserName().equals(s)) {
                return i;
            }
        }
        return null;
    }

    public void registerUser(User x) {
        if(userWithName(x.getUserName()) == null) {
            users.add(x);
        }
    }

    public List<Song> availableSongsByArtist(String artist) {
        List<Song> availableSongs = new ArrayList<>();

        for(Song i: allAvailableSongs()) {
            if(i.getArtist().equals(artist)) {
                availableSongs.add(i);
            }
        }
        return availableSongs;
    }

    public Song getSong(String title, String ownerName) {
        for(User k: onlineUsers()) {
            if(k.getUserName().equals(ownerName)) {
                if(k.songWithTitle(title) != null) {
                    Song nameOfSong = k.songWithTitle(title);
                    downloadedSongs.add(nameOfSong);
                    if(!royalties.containsKey(nameOfSong.getArtist())) {
                        royalties.put(nameOfSong.getArtist(), 0f);
                    }
                    float amount = royalties.get(nameOfSong.getArtist()) + 0.25f;
                    royalties.put(nameOfSong.getArtist(), amount);
                    return k.songWithTitle(title);
                }
            }
        }
        return null;
    }

    public void displayRoyalties() {
        System.out.println("Amount\tArtist");
        System.out.println("---------------");
        for(String i: royalties.keySet()) {
            System.out.printf("$%.2f\t%s\n", royalties.get(i), i);
        }
    }

    public TreeSet<Song> uniqueDownloads() {
        return new TreeSet<>(downloadedSongs);
    }

    public ArrayList<Pair<Integer, Song>> songsByPopularity() {
        ArrayList<Pair<Integer, Song>> songsByPopularity = new ArrayList<>();

        HashMap<Song, Integer> downloads = new HashMap<>();

        for (Song i: downloadedSongs) {
            downloads.putIfAbsent(i, 0);
            downloads.put(i, downloads.get(i) + 1);
        }

        for(Song i: downloads.keySet()) {
            songsByPopularity.add(new Pair<>(downloads.get(i), i));
        }

        Collections.sort(songsByPopularity, new Comparator<Pair<Integer, Song>>() {
            public int compare(Pair<Integer, Song> p1, Pair<Integer, Song> p2) {
                return p2.getKey().compareTo(p1.getKey());
            }
        });
        return songsByPopularity;
    }
}
