import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.List;
import java.util.*;

public class MeasurementData{
    List data;

    public MeasurementData(){
        data = new ArrayList();
    }

    //Adds the given value to the measurement data
    public void measure(int value){
        data.add(value);
    }

    //If start and end are within an acceptable range (i.e., there is data at
    // these index values)
    //Return a new list containing the measurements from index start
    // to index end (inclusive)
    public List getMeasures(int start, int end){
        //create a new list for the result
        //verify the start/end indices are valid
        //copy the values from start index to end index (inclusive) into result
        //return the result
        if(start >= 0 && start <= end && end < data.size()) {
            List result = new ArrayList();
            for(int i = start; i <= end; i++){
                result.add(data.get(i));
            }
            return result;
        }

        return null;
    }

    public static void main(String[] args){
        Random random = new Random();
        MeasurementData m = new MeasurementData();

        for(int i = 0; i < 25; i++){
            //int next = random.nextInt(100);
            int next = i;
            System.out.println("Adding: " + next);
            m.measure(next);
        }

        for(int i = 0; i < 25; i = i + 5){
            System.out.println("Getting " + i + " to " + (i+5) + ": " + m.getMeasures(i, i+5));
        }
    }
}