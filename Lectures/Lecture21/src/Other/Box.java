package Other;

import java.util.ArrayList;
public class Box {
  private ArrayList<Box> internalBoxes;
  // A constructor that makes a box with no boxes in it
  public Box() {
    internalBoxes = new ArrayList<Box>();
  }
  // Get method
  public ArrayList<Box> getInternalBoxes() { return internalBoxes; }
  // Method to add a box to the internal boxes
  public void addBox(Box b) {
    internalBoxes.add(b);
  }
  // Method to remove a box from the internal boxes
  public void removeBox(Box b) {
    internalBoxes.remove(b);
  }
  
  public int unwrap() {
    if (internalBoxes.size() == 0){
      return 1;
    }
    // Count this box
    int count = 1;
    // Count each of the inner boxes
    for (Box b: internalBoxes)
      count = count + b.unwrap();
    return count;
  }

  //Destructive version
  public int unwrap2() {
    if (internalBoxes.size() == 0){
      return 1;
    }
    // Remove one internal box, if there is one
    Box insideBox = internalBoxes.remove(0);
    // Unwrap the rest of this box as well as the one just removed
    return this.unwrap2() + insideBox.unwrap2();
  }

  //Temporarily destructive but not actually destructive solution
  public int unwrap3() {
    if (internalBoxes.size() == 0){
      return 1;
    }
    // Remove one internal box, if there is one
    Box insideBox = internalBoxes.remove(0);
    // Unwrap the rest of this box as well as the one just removed
    int result = this.unwrap3() + insideBox.unwrap3();
    // Put the box back in at position 0 (i.e., same order)
    internalBoxes.add(0,insideBox);
    return result;
  }
} 