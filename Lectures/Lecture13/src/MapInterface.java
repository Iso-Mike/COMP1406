import java.util.List;

public interface MapInterface {
    void put(Object key, Object value);
    Object get(Object key);
    boolean containsKey(Object key);
    List<Object> keySet();
}
