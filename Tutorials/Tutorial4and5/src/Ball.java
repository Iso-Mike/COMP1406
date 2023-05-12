public class Ball extends MovableObject implements Harmful{
    private boolean isBeingHeld;

    public Ball(Point2D loc) {
        super(0, 0, loc);
        isBeingHeld = false;
    }

    // The get/set methods
    public boolean isBeingHeld() { return isBeingHeld; }
    public void setIsBeingHeld(boolean newHoldStatus) { isBeingHeld = newHoldStatus; }

    public void update(){
        moveForward();
        if(speed > 0) {
            speed -= 1;
        }
        draw();
    }

    public void draw(){
        System.out.println("Ball is at " + location + " facing " + direction +  " degrees and moving at " + speed + " pixels per second");
    }

    public String toString() {
        return "Ball" + " at (" + (int)location.getX() + "," + (int)location.getY() + ") facing " + direction +
                " degrees going " + speed + " pixels per second";
    }

    public int getDamageAmount() {
        return -200;
    }
}