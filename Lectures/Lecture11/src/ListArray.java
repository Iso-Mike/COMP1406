import java.util.Arrays;

public class ListArray implements ListInterface {
    private Object[] data;
    private static final int INITIAL_SIZE = 10;
    private int curItems;

    public ListArray() {
        data = new Object[INITIAL_SIZE];
        curItems = 0;
    }


    private void expand(){
        System.out.println("We are expanding the array.");
        int curSize = data.length;
        int newSize = curSize + 10;

        Object[] newData = new Object[newSize];

        for(int i = 0; i < data.length; i++){
            newData[i] = data[i];
        }

        data = newData;
    }

    //Runtime complexity?
    // Adding to end of the list - O(1)
    // Adding to the start of the list - O(n)
    //Index has to be >= 0
    //If index >= the number of items, add at the end
    public void add(int index, Object item) {
        if(index >= 0){
            //we need to add the item
            if(index >= curItems){
                data[curItems] = item;
                curItems++;
            }else {
                for (int i = curItems; i > index; i--) {
                    data[i] = data[i - 1];
                }
                data[index] = item;
                curItems++;
            }

            if(curItems == data.length){
                expand();
            }
        }
    }

    //Runtime complexity?
    public void add(Object item) {
        add(curItems, item);
    }

    //Runtime complexity? O(n)
    public boolean contains(Object o) {
        for(int i = 0; i < curItems; i++){
            if(data[i].equals(o)){
                return true;
            }
        }

        return false;
    }

    // data = [a, b, d, e, f, f, null, null, null, null]
    //curItems ^
    //removed = c

    private boolean isValidIndex(int index){
        return index >= 0 && index < curItems;
    }

    //Runtime complexity?
    //What about a remove(Object) method?
    public Object remove(int index) {
        if(isValidIndex(index)){
            Object removed = data[index];
            for(int i = index; i < curItems - 1; i++){
                data[i] = data[i + 1];
            }
            curItems--;
            return removed;
        }
        return null;
    }

    //Runtime complexity? O(1)
    public void set(int index, Object item) {
        if(isValidIndex(index)){
            data[index] = item;
        }
    }

    //Runtime complexity? O(1)
    public Object get(int index) {
        if (isValidIndex(index)) {
            return data[index];
        }
        return null;
    }

    public int size() {
        return curItems;
    }

    public void clear() {
        curItems = 0;
    }

    public boolean isEmpty() {
        return curItems == 0;
    }

    public String toString() {
        if (curItems == 0) {
            return "[]";
        } else if (curItems == 1) {
            return "[" + data[0] + "]";
        }

        String result = "[";
        for (int i = 0; i < curItems; i++) {
            result += data[i] + ", ";
        }
        result = result.substring(0, result.length() - 2);
        result = result + "]";
        return result;
    }


    public static void main(String[] args) {
        ListArray x = new ListArray();

        for(int i = 5; i < 10; i++){
            x.add(i);
            System.out.println(x);
        }

        for(int i = 10; i < 15; i++){
            x.add(i, i);
            System.out.println(x);
        }

        for(int i = 0; i < 5; i++){
            x.add(i, i);
            System.out.println(x);
        }

        x.add(9, -1);
        System.out.println(x);
        System.out.println(x.remove(0));
        System.out.println(x);
        System.out.println(x.remove(10));
        System.out.println(x);
        System.out.println(x.remove(3));
        System.out.println(x);

        while (!x.isEmpty()) {
            x.remove(0);
            System.out.println(x);
        }
    }
}