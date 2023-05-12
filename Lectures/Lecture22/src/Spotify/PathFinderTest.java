package Spotify;

import java.io.*;

public class PathFinderTest {
    public static void main(String[] args){
        initializeSpotifyData();

        Spotify spotify = null;
        ObjectInputStream objectIn = null;

        try {
            objectIn = new ObjectInputStream(new FileInputStream("resources" + File.separator + "final-object-spotify.txt"));
            spotify = (Spotify)objectIn.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Could not read the data. Stopping.");
            System.exit(1);
        }

        Artist fifty = spotify.findArtistByName("50 cent");
        Artist eminem = spotify.findArtistByName("eminem");
        Artist foo = spotify.findArtistByName("foo fighters");
        Artist billie = spotify.findArtistByName("Billie Eilish");
        Artist bruno = spotify.findArtistByName("bruno mars");
        Artist dua = spotify.findArtistByName("dua lipa");
        Artist cardi = spotify.findArtistByName("cardi b");
        Artist[] artists = {fifty, eminem, foo, billie, bruno, dua, cardi};

        //Testing finding a path between two artists

        for(int i = 0; i < artists.length; i++){
            for(int j = 0; j < artists.length; j++){
                Artist a1 = artists[i];
                Artist a2 = artists[j];
                System.out.println(a1 + " vs. " + a2);
                System.out.println(spotify.findPathBetween(a1, a2));
            }
        }

        //Testing find shortest path between two artists

        for(int i = 0; i < artists.length; i++){
            for(int j = 0; j < artists.length; j++){
                Artist a1 = artists[i];
                Artist a2 = artists[j];
                System.out.println(a1 + " vs. " + a2);
                System.out.println(spotify.findShortestPathBetween(a1, a2));
            }
        }




        //Testing playlist generation from song object

        System.out.println();
        System.out.println();
        System.out.println();
        Song s = spotify.findSongByName("Monkey Wrench");
        Playlist p = spotify.generatePlaylistFromSong(s);
        System.out.println(p);
        p.printSongs();

        System.out.println();
        System.out.println();
        System.out.println();
        s = spotify.findSongByName("One Kiss (with Dua Lipa)");
        p = spotify.generatePlaylistFromSong(s);
        System.out.println(p);
        p.printSongs();

        System.out.println();
        System.out.println();
        System.out.println();
        s = spotify.findSongByName("Party in the U.S.A.");
        p = spotify.generatePlaylistFromSong(s);
        System.out.println(p);
        p.printSongs();

        System.out.println();
        System.out.println();
        System.out.println();
        s = spotify.findSongByName("I Won't Back Down");
        p = spotify.generatePlaylistFromSong(s);
        System.out.println(p);
        p.printSongs();

        System.out.println();
        System.out.println();
        System.out.println();
        s = spotify.findSongByName("Umbrella");
        p = spotify.generatePlaylistFromSong(s);
        System.out.println(p);
        p.printSongs();

    }

    public static void initializeSpotifyData(){
        try {
            BufferedReader in = new BufferedReader(new FileReader("resources" + File.separator + "songs-and-artists.txt"));
            Spotify s = Spotify.load(in);
            in.close();

            Playlist p = new Playlist("Foo Fighters Songs");
            Playlist p2 = new Playlist("Walking Songs");

            for(int i = 0; i < 2500;  i++) {
                SpotifyObject o = s.getObjectWithId(i);
                if(o instanceof Song){
                    Song song = (Song)o;
                    if(song.getArtistNames().contains("Foo Fighters")){
                        p.addSong(song);
                    }
                    if(song.matchesSearch("walk")){
                        p2.addSong(song);
                    }
                }
            }

            s.addMedia(p);
            s.addMedia(p2);

            ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream("resources" + File.separator + "final-object-spotify.txt"));
            objectOut.writeObject(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
