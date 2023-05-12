public class QueueTester{
    public static void main(String[] args){
        QueueInterface q = new QueueArray();

        for(int i = 0; i < 100; i++){
            q.add(i);
        }

        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}