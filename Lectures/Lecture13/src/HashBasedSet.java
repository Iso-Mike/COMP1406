import java.util.ArrayList;
import java.util.List;

public class HashBasedSet implements SetInterface{

    private List[] data;
    private int size;
    private static final int DATA_SIZE = 5000;

    public HashBasedSet(){
        data = new List[DATA_SIZE];
        for(int i = 0; i < data.length; i++){
            data[i] = new ArrayList();
        }
        size = 0;
    }

    public int getIndex(Object o){
        return Math.abs(o.hashCode()) % data.length;
    }

    //This should be ~O(1)
    public void add(Object o) {
        int index = getIndex(o);
        if(!data[index].contains(o)){
            data[index].add(o);
            size++;
        }
    }

    //Ignore this for now
    //In fact, there is a sneaky bug in here
    //That will break your map implementation if you use this
    public Object get(Object o){
        int index = getIndex(o);

        for(int i = 0; i < data[index].size(); i++){
            if(data[index].get(i).equals(o)){
                return data[index].get(i);
            }
        }

        return null;
    }

    @Override
    //~O(1)
    public boolean contains(Object o) {
        int index = getIndex(o);
        return data[index].contains(o);
    }

    @Override
    public void remove(Object o) {
        int index = getIndex(o);
        if(data[index].remove(o)){
            size--;
        }
    }

    @Override
    public boolean isEmpty(Object o) {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for(List x: data){
            x.clear();
        }
    }

    public List getItems(){
        List result = new ArrayList();
        for(List x: data){
            for(Object o: x){
                result.add(o);
            }
        }
        return result;
    }

    @Override
    public void print() {
        System.out.println("Here are the items in the set:");
        //CODE TO PRINT ITEMS HERE
        for(List x: data){
            for(Object o: x){
               //DO SOMETHING
                System.out.println(o);
            }
        }
        System.out.println();
        System.out.println();

    }
}
