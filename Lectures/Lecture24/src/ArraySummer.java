public class ArraySummer extends Thread{
 double[] values;
 int startValue;
 int endValue;
 double result;
 
 public ArraySummer(double[] iVals, int start, int end){
   values = iVals;
   startValue = start;
   endValue = end;
   result = 0;
 }
 
 public void run() {
   try{
     result = 0;
     
     for(int i = startValue; i < endValue && i < values.length; i++){
       result += values[i];
       Thread.sleep(ArraySum.delay);
     } 
   }catch(InterruptedException e){
     e.printStackTrace();
   }
 }
}