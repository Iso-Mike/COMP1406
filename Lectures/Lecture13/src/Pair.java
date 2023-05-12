public class Pair {
    private Object key;
    private Object value;

    public Pair(Object key, Object value){
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public int hashCode() {
        return key.hashCode();
    }

    public boolean equals(Object o){
        if(o instanceof Pair){
            return ((Pair)o).key.equals(this.key);
        }
        return false;
    }

}
