import java.time.*;
public class ArraySum{
  static int delay = 0;
  
  public static void main(String[] args){
   int size = 1000000;
   double[] values = new double[size];
   for(int i = 0; i < values.length; i++){
     values[i] = Math.random();
   }
   
   Instant seqStart = null;
   Instant seqEnd = null;
   try{
     //Single thread sum
     seqStart = Instant.now();
     double total = 0;
     for(int i = 0; i < values.length; i++){
       total += values[i];
       Thread.sleep(delay);
     }
    seqEnd = Instant.now();
     System.out.println("Sequential total: " + total);
     System.out.println("Seq Time: " + Duration.between(seqStart, seqEnd).getNano());
   }catch(InterruptedException e){
     e.printStackTrace();
   }
   
   Instant multiStart = Instant.now();
   int numThreads = 4;
   int perThread = size/numThreads;
   Thread[] threads = new Thread[numThreads];
   for(int i = 0; i < numThreads; i++){
     threads[i] = new ArraySummer(values, (i * perThread), ((i*perThread) + perThread));
     threads[i].start();
   }
   
   try{
     double total = 0;
     for(int i = 0; i < numThreads; i++){
       threads[i].join();
       total += ((ArraySummer)threads[i]).result;
     }
     System.out.println("Parallel total: " + total);
   }catch(InterruptedException e){
     e.printStackTrace();
   }
   Instant multiEnd = Instant.now();
   System.out.println("Multi Time: " + Duration.between(multiStart, multiEnd).getNano());
   
   System.out.println("Parallel is " + ((double)Duration.between(seqStart, seqEnd).getNano() / Duration.between(multiStart, multiEnd).getNano()) + " times faster");
  }
  
}