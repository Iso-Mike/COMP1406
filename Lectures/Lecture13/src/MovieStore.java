import java.util.*;
public class MovieStore {
  /*
    One way: use a list for storage
    A giant list that stores all of our movies
    addMovie: just add the movie on the list
    removeMovie: go through the list until you find movie, then remove it (if you find it)
    listMoviesByActor: go through list, if movie's actor list contains actor name, add to result list
    listMoviesByType: same as above, but checking the type
   */

  private Map<String, Movie> movieMap; //key=title of the movie, value=movie object
  private Map<String, List<Movie>> actorMap; //key=actor name, value=list of movies that actor was in
  private Map<String, List<Movie>> typeMap; // key=genre of the movie, value = list of movies with that genre

  public MovieStore() {
    movieMap = new HashMap<String, Movie>();
    actorMap = new HashMap<String, List<Movie>>();
    typeMap = new HashMap<String, List<Movie>>();
  }


  public String toString() {
    return ("MovieStore with " + movieMap.size() + " movies.");
  }

  //This method adds a movie to the movieStore.
  public void addMovie(Movie aMovie) {
    if(aMovie == null){
      return;
    }

    if(movieMap.containsKey(aMovie.getTitle())){
      return;
    }

    //update our movie map
    movieMap.put(aMovie.getTitle(), aMovie);

    //update the actor map for each actor in the movie
    for(String actorName: aMovie.getActors()){
      //if the actor name does not exist in the map
      if(!actorMap.containsKey(actorName)){
        actorMap.put(actorName, new ArrayList());
      }

      //update that actor's movie map to contain aMovie
      actorMap.get(actorName).add(aMovie);
    }

    //update the genre map for the genre of this movie
    if(!typeMap.containsKey(aMovie.getType())){
      typeMap.put(aMovie.getType(), new ArrayList());
    }
    typeMap.get(aMovie.getType()).add(aMovie);
  }
  
  private void removeMovie(Movie aMovie) {
    //if that movie doesn't exist in our data
    //we don't need to anything
    if(!movieMap.containsKey(aMovie.getTitle())){
      return;
    }

    //we need to remove it from the type list
    typeMap.get(aMovie.getType()).remove(aMovie);
    if(typeMap.get(aMovie.getType()).isEmpty()){
      typeMap.remove(aMovie.getType());
    }

    //we need to remove it from each actor's list
    for(String actor: aMovie.getActors()){
      actorMap.get(actor).remove(aMovie);
      if(actorMap.get(actor).isEmpty()){
        actorMap.remove(actor);
      }
    }

    //we need to remove it from our movie map
    movieMap.remove(aMovie.getTitle());

  } 
  
  public void removeMovieWithTitle(String aTitle) {
    //find a movie with the given title, and take it out
    if(movieMap.containsKey(aTitle)){
      removeMovie(movieMap.get(aTitle));
    }
  }
  
  //This method lists all movie titles that are in the store
  public void listMovies() {
    for(String title: movieMap.keySet()){
      System.out.println(movieMap.get(title));
    }
  }

  //This method lists all movies that star the given actor
  public void listMoviesWithActor(String anActor) {
    if(actorMap.containsKey(anActor)){
      for(Movie aMovie: actorMap.get(anActor)){
        System.out.println(aMovie);
      }
    }
  } 
  
  //This method lists all movies that have the given type
  public void listMoviesOfType(String aType) {
    if(typeMap.containsKey(aType)){
      for(Movie aMovie: typeMap.get(aType)){
        System.out.println(aMovie);
      }
    }
  }
} 