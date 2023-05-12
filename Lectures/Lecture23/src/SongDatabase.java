import java.util.Arrays;
import java.util.Scanner;

public class SongDatabase {
    private Song[] database;

    public SongDatabase(){
        //Array holds 15 max
        database = new Song[15];

        //We only have 12 songs (so 3 nulls at end)
        database[0] = new Song("Testify", 330, 51, true);
        database[1] = new Song("Guerrilla Radio", 326, 75, false);
        database[2] = new Song("Calm Like a Bomb", 459, 44, false);
        database[3] = new Song("Mic Check", 334, 15, false);
        database[4] = new Song("Sleep Now In the Fire", 326, 75, true);
        database[5] = new Song("Born of a Broken Man", 441, 88, true);
        database[6] = new Song("Born as Ghosts", 322, 51, false);
        database[7] = new Song("Maria", 348, 34, true);
        database[8] = new Song("Voice of the Voiceless", 232, 41, true);
        database[9] = new Song("New Millennium Homes", 345, 48, true);
        database[10] = new Song("Ashes in the Fall", 437, 51, false);
        database[11] = new Song("War Within a Breath", 336, 85, true);
    }

    //Return an array with ONLY the song objects (i.e., no nulls)
    public Song[] getAllSongs(){
        /*
            1. Count how many songs we have (non-nulls)
            2. Create an array of that size
            3. Copy all songs into that array
            4. Return the array
         */

        int countSongs = 0;
        for(int i = 0; i < database.length; i++){
            if(database[i] != null){
                countSongs++;
            }
        }

        Song[] result = new Song[countSongs];
        int curIndex = 0;
        for(int i = 0; i < database.length; i++){
            if(database[i] != null){
                result[curIndex] = database[i];
                curIndex++;
            }
        }
        return result;
    }

    public Song[] getAvailableSongs(){
        /*
            1. Count how many available songs we have
            2. Create an array of that size
            3. Copy available songs into that array
            4. Return the array
         */

        int countAvailable = 0;
        for(int i = 0; i < database.length; i++){
            if(database[i] != null && database[i].isAvailable()){
                countAvailable++;
            }
        }

        Song[] availableSongs = new Song[countAvailable];
        int curIndex = 0;
        for(int i = 0; i < database.length; i++){
            if(database[i] != null && database[i].isAvailable()){
                availableSongs[curIndex] = database[i];
                curIndex++;
            }
        }
        return availableSongs;
    }

    public Song[] getLongSongs(){
        /*
            1. Count how many long songs we have
            2. Create an array of that size
            3. Copy long songs into that array
            4. Return the array

            Assumption: a long song is a song with length 400 or more
         */

        int countLong = 0;
        for(int i = 0; i < database.length; i++){
            if(database[i] != null && database[i].getLength() >= 400){
                countLong++;
            }
        }

        Song[] availableSongs = new Song[countLong];
        int curIndex = 0;
        for(int i = 0; i < database.length; i++){
            if(database[i] != null && database[i].getLength() >= 400){
                availableSongs[curIndex] = database[i];
                curIndex++;
            }
        }
        return availableSongs;
    }

    public Song[] getPopularSongs(){
        /*
            1. Count how many popular songs we have
            2. Create an array of that size
            3. Copy popular songs into that array
            4. Return the array

            Assumption: a popular song is a song that has been listened to 50 times or more
         */

        int countPopular = 0;
        for(int i = 0; i < database.length; i++){
            if(database[i] != null && database[i].getNumListens() >= 50){
                countPopular++;
            }
        }

        Song[] availableSongs = new Song[countPopular];
        int curIndex = 0;
        for(int i = 0; i < database.length; i++){
            if(database[i] != null && database[i].getNumListens() >= 50){
                availableSongs[curIndex] = database[i];
                curIndex++;
            }
        }
        return availableSongs;
    }

    public static void main(String[] args){
        SongDatabase songs = new SongDatabase();

        Song[] availableSongs = songs.getAvailableSongs();
        System.out.println("Available Songs:");
        for(Song s: availableSongs){
            System.out.println(s);
        }
        System.out.println();

        Song[] longSongs = songs.getLongSongs();
        System.out.println("Long Songs:");
        for(Song s: longSongs){
            System.out.println(s);
        }
        System.out.println();

        Song[] popularSongs = songs.getPopularSongs();
        System.out.println("Popular Songs:");
        for(Song s: popularSongs){
            System.out.println(s);
        }
        System.out.println();

        System.out.println("Setting all but first song to unavailable.");
        for(int i = 1; i < songs.database.length; i++) {
            if(songs.database[i] != null) {
                songs.database[i].setAvailable(false);
            }
        }

        System.out.println("Available Songs Now:");
        availableSongs = songs.getAvailableSongs();
        for(Song s: availableSongs){
            System.out.println(s);
        }
        System.out.println();


        //Simulate a menu
        //This is very close to how you can arrange things with ListViews in a separate view
        while(true){
            System.out.println("Select which song to change availability for (-1 to quit):");

            //Get all of the songs (we could get only available, popular, etc. by using different method)
            Song[] allSongs = songs.getAllSongs();

            //Print out a menu
            //Important detail: the index in the menu corresponds to the index in the array
            for(int i = 0; i < allSongs.length; i++){
                System.out.println("#" + i + ". " + allSongs[i]);
            }

            //Ask the user for an index choice
            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();

            //If they want to quit
            if(choice == -1){
                break;
            }

            //If the index is invalid
            if(choice >= allSongs.length || choice < -1){
                System.out.println("Invalid index.");
            }

            //If the index is valid, change the state of that Song object
            //In this case, we toggle the availability
            //But in general, we have a reference to that song object and can call any of its methods to change state
            allSongs[choice].setAvailable(!allSongs[choice].isAvailable());
        }
    }
}
