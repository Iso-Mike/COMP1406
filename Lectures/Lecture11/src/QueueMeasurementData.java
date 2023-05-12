    import java.util.*;

public class QueueMeasurementData{
    private QueueInterface measurements;
    private int maxSize;
    private int totalData;

    public QueueMeasurementData(int maxSize){
        measurements = new ListQueue();
        this.maxSize = maxSize;
        totalData = 0;
    }

    public void measure(int value){
        measurements.add(value);
        totalData += value;

        if(measurements.size() > maxSize){
            totalData -= (Integer)measurements.remove();
        }
    }

    public double getAverage(){
        //the total values
        //the number of values
        if(measurements.size() > 0) {
            return totalData / (double) measurements.size();
        }
        return 0;
    }

    public static void main(String[] args){
        QueueMeasurementData q = new QueueMeasurementData(2);

        q.measure(8);
        q.measure(6);
        q.measure(4);
        q.measure(10);
        q.measure(12);
        q.measure(14);
        System.out.println(q.getAverage());
    }

}