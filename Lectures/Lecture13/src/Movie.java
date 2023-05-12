import java.util.*;
public class Movie {
  private String title, type;
  private ArrayList<String> actors;
  
  public String getTitle() { return title; }
  public String getType() { return type; }
  public ArrayList<String> getActors() { return actors; }
  
  public Movie() {
    this("???", "???");
  }
  
  public Movie(String aTitle, String aType) {
    title = aTitle;
    type = aType;
    actors = new ArrayList<String>();
  }

  public boolean equals(Object o){
    if(o instanceof Movie){
      return ((Movie) o).title.equals(this.title);
    }
    return false;
  }

  public int hashCode(){
    return title.hashCode();
  }
  
  public String toString() { return("Movie: \"" + title + "\""); }
  
  public void addActor(String anActor) { actors.add(anActor); }
  
  public static Movie example1() {
    Movie aMovie = new Movie("The Matrix","SciFic");
    aMovie.addActor("Keanu Reeves");
    aMovie.addActor("Laurence Fishburne");
    aMovie.addActor("Carrie-Anne Moss");
    return aMovie;
  }
  public static Movie example2() {
    Movie aMovie = new Movie("Blazing Saddles","Comedy");
    aMovie.addActor("Cleavon Little");
    aMovie.addActor("Gene Wilder");
    return aMovie;
  }
  public static Movie example3() {
    Movie aMovie = new Movie("The Matrix Reloaded","SciFic");
    aMovie.addActor("Keanu Reeves");
    aMovie.addActor("Laurence Fishburne");
    aMovie.addActor("Carrie-Anne Moss");
    return aMovie;
  }
  public static Movie example4() {
    Movie aMovie = new Movie("The Adventure of Sherlock Holmes' Smarter Brother",
                             "Comedy");
    aMovie.addActor("Gene Wilder");
    aMovie.addActor("Madeline Kahn");
    aMovie.addActor("Marty Feldman");
    aMovie.addActor("Dom DeLuise");
    return aMovie;
  }
  public static Movie example5() {
    Movie aMovie = new Movie("The Matrix Revolutions","SciFic");
    aMovie.addActor("Keanu Reeves");
    aMovie.addActor("Laurence Fishburne");
    aMovie.addActor("Carrie-Anne Moss");
    return aMovie;
  }
  public static Movie example6() {
    Movie aMovie = new Movie("Meet the Fockers","Comedy");
    aMovie.addActor("Robert De Niro");
    aMovie.addActor("Ben Stiller");
    aMovie.addActor("Dustin Hoffman");
    return aMovie;
  }
  public static Movie example7() {
    Movie aMovie = new Movie("Runaway Jury","Drama");
    aMovie.addActor("John Cusack");
    aMovie.addActor("Gene Hackman");
    aMovie.addActor("Dustin Hoffman");
    return aMovie;
  }
  public static Movie example8() {
    Movie aMovie = new Movie("Meet the Parents","Comedy");
    aMovie.addActor("Robert De Niro");
    aMovie.addActor("Ben Stiller");
    aMovie.addActor("Teri Polo");
    aMovie.addActor("Blythe Danner");
    return aMovie;
  }
  public static Movie example9() {
    Movie aMovie = new Movie("The Aviator","Drama");
    aMovie.addActor("Leonardo DiCaprio");
    aMovie.addActor("Cate Blanchett");
    return aMovie;
  }
  public static Movie example10() {
    Movie aMovie = new Movie("Envy","Comedy");
    aMovie.addActor("Ben Stiller");
    aMovie.addActor("Jack Black");
    aMovie.addActor("Rachel Weisz");
    aMovie.addActor("Amy Poehler");
    return aMovie;
  }
}