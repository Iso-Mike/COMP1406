public class Song {
    private String title;
    private int length;
    private int numListens;
    private boolean available;

    public Song(String title, int length, int numListens, boolean available){
        this.title = title;
        this.length = length;
        this.numListens = numListens;
        this.available = available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getLength() {
        return length;
    }

    public int getNumListens() {
        return numListens;
    }

    public String toString(){
        return title + ", " + length + ", " + numListens + ", " + available;
    }
}
