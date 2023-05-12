package Other;

public class MazeTest {
  public static void main(String[] args) {
    Maze m = Maze.sampleMaze();
    Rat r = new Rat();
    r.moveTo(1,1);
    //uncomment below to create an opening so the rat can find the cheese
    //m.removeWallAt(4,11);
    m.display(1,1);
    System.out.println("Can find cheese ... " + r.canFindCheeseIn(m));
    m.display(1,1);
  }
} 