package Spotify;

public class SpotifyTester {
    public static void main(String[] args){
        User u1 = new User("Leeroy Jenkins");
        User u2 = new User("Delilah Bon");
        User u3 = new User("Frodo Baggins");

        Artist emeline = new Artist("Emeline");
        Artist pantera = new Artist("Pantera");
        Artist fooFighters = new Artist("Foo Fighters");
        Artist johnnyCash = new Artist("Johnny Cash");

        Song s1 = new Song("STRUT", emeline, "I like turning heads, breaking necks, high heels in the morning.");
        Song s2 = new Song("Walk", pantera, "Respect, walk, what did you say?");
        Song s3 = new Song("Walk", fooFighters, "Learning to walk again I believe I've waited long enough");
        Song s4 = new Song("Walking After You", fooFighters, "If you walk out on me I'm walking after you");
        Song s5 = new Song("I Walk the Line", johnnyCash, "Because you're mine...");

        Playlist p1 = new Playlist("Walking Songs");
        p1.addSong(s1);
        p1.addSong(s2);
        p1.addSong(s3);
        p1.addSong(s4);
        p1.addSong(s5);

        p1.printSongs();

        p1.moveUp(s4);
        p1.moveUp(s4);
        p1.moveUp(s4);
        p1.moveUp(s4);

        p1.printSongs();


        Spotify spotify = new Spotify();

        spotify.addUser(u1);
        spotify.addUser(u1);
        spotify.addUser(u2);
        spotify.addUser(u3);

        spotify.addSong(s1);
        spotify.addSong(s1);
        spotify.addSong(s2);
        spotify.addSong(s3);
        spotify.addSong(s4);
        spotify.addSong(s5);


        spotify.addPlaylist(p1);
        spotify.addPlaylist(p1);

        System.out.println(spotify);


        System.out.println("Searching for 'walk'");
        spotify.search("walk");
        System.out.println("Searching for 'strut'");
        spotify.search("strut");
        System.out.println("Searching for 'line'");
        spotify.search("line");
        System.out.println("Searching for 'o'");
        spotify.search("o");

        u3.playPlaylist(p1);
        u3.shufflePlaylist(p1);
    }
}
