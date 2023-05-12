import java.util.ArrayList;
import java.util.List;

public class HashBasedMap implements MapInterface{
    HashBasedSet data;

    public HashBasedMap(){
        data = new HashBasedSet();
    }
    @Override
    public void put(Object key, Object value) {
        Pair newEntry = new Pair(key, value);
        if(data.contains(newEntry)){
            data.remove(newEntry);
        }
        data.add(newEntry);
    }

    @Override
    public Object get(Object key) {
        Pair target = new Pair(key, null);
        Object result = data.get(target);
        if(result != null){
            return ((Pair)result).getValue();
        }
        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        Pair target = new Pair(key, null);
        return data.contains(target);
    }

    @Override
    public List<Object> keySet() {
        List items = data.getItems();
        List result = new ArrayList();
        for(Object o: items){
            result.add(((Pair)o).getKey());
        }
        return result;
    }

    public static void main(String[] args){
        HashBasedMap map = new HashBasedMap();

        System.out.println(map.get("name"));
        map.put("name", "dave");
        System.out.println(map.get("name"));
        map.put("name", "dave mckenney");
        System.out.println(map.get("name"));
        map.put("studentid", "100831327");
        map.put("age", 37);
        for(Object key: map.keySet()){
            System.out.println("key=" + key + " value=" + map.get(key));
        }
    }
}
