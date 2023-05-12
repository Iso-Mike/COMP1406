public class PrintingThread extends Thread{
  String name;
  public PrintingThread(String n){
    name = n;
  }
  
  public void run(){
    for(int i = 0; i < 10; i++){
     System.out.println(name);
     try{
       sleep((int)(Math.random() * 1000));
     }catch(InterruptedException e){
       e.printStackTrace();
     }
    }
  }
}