public class MovieStoreTester {
    public static void main(String args[]) {
        MovieStore aStore = new MovieStore();
        aStore.addMovie(Movie.example1());
        aStore.addMovie(Movie.example2());
        aStore.addMovie(Movie.example3());
        aStore.addMovie(Movie.example4());
        aStore.addMovie(Movie.example5());
        aStore.addMovie(Movie.example6());
        aStore.addMovie(Movie.example7());
        aStore.addMovie(Movie.example8());
        aStore.addMovie(Movie.example9());
        aStore.addMovie(Movie.example10());
        System.out.println("Here are the movies in: " + aStore);
        aStore.listMovies();
        System.out.println();
        //Try some removing now
        System.out.println("Removing The Matrix");
        aStore.removeMovieWithTitle("The Matrix");
        System.out.println("Trying to remove Mark's Movie");
        aStore.removeMovieWithTitle("Mark's Movie");
        //Do some listing of movies
        System.out.println("\nHere are the Comedy movies in: " + aStore);
        aStore.listMoviesOfType("Comedy");
        System.out.println("\nHere are the Science Fiction movies in: " + aStore);
        aStore.listMoviesOfType("SciFic");
        System.out.println("\nHere are the movies with Ben Stiller:");
        aStore.listMoviesWithActor("Ben Stiller");
        System.out.println("\nHere are the movies with Keanu Reeves:");
        aStore.listMoviesWithActor("Keanu Reeves");
    }
} 