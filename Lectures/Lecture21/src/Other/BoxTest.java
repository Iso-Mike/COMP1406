package Other;

public class BoxTest {
  public static void main(String[] args) {
    Box mainBox, a, b, c, d, e, f, g, h, i, j;
    mainBox = new Box();
    // Create the left blue box and its contents
    a = new Box(); // box 10
    b = new Box(); // box 11
    b.addBox(new Box()); // box 23
    c = new Box(); // box 4
    c.addBox(a);
    c.addBox(b);
    d = new Box(); // box 12
    d.addBox(new Box()); // box 24
    e = new Box(); // box 5
    e.addBox(d);
    f = new Box(); // box 13
    f.addBox(new Box()); // box 25
    g = new Box(); // box 14
    h = new Box(); // box 15
    h.addBox(new Box()); // box 26
    i = new Box(); // box 6
    i.addBox(f);
    i.addBox(g);
    i.addBox(h);
    j = new Box(); // box 1
    j.addBox(c);
    j.addBox(e);
    j.addBox(i);
    mainBox.addBox(j);
    // Create the top right blue box and its contents
    a = new Box(); // box 7
    a.addBox(new Box()); // box 16
    b = new Box(); // box 8
    b.addBox(new Box()); // box 17
    b.addBox(new Box()); // box 18
    b.addBox(new Box()); // box 19
    b.addBox(new Box()); // box 20
    b.addBox(new Box()); // box 21
    c = new Box(); // box 2
    c.addBox(a);
    c.addBox(b);
    mainBox.addBox(c);
    // Create the bottom right blue box and its contents
    a = new Box(); // box 22
    a.addBox(new Box()); // box 27
    a.addBox(new Box()); // box 28
    b = new Box(); // box 9
    b.addBox(a);
    c = new Box(); // box 3
    c.addBox(b);
    mainBox.addBox(c);
    System.out.println(mainBox.unwrap3());
  }
} 