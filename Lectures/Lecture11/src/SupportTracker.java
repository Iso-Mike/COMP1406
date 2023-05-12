import java.util.*;

public class SupportTracker{
    Queue<String> data;

    public SupportTracker(){
        data = new LinkedList<String>();
    }

    public void receiveRequest(String s){
        data.add(s);
    }

    public String handleRequest(){
        if(!data.isEmpty()){
            return data.remove();
        }
        return "Currently no requests available.";
    }

    public static void main(String[] args){
        Random rand = new Random();
        String[] reqs = {"I can't turn my computer on.", "My printer won't print.", "My printer won't stop printing.", "I forget my password."};
        SupportTracker track = new SupportTracker();

        for(int i = 0; i < 15; i++){
            int action = rand.nextInt(2);
            if(action == 0){
                String req = reqs[rand.nextInt(reqs.length)];
                System.out.println("Receiving request: " + req);
                track.receiveRequest(req);
                System.out.println("Request queue is now: " + track.data);
            }else if(action == 1){
                String req = track.handleRequest();
                System.out.println("Handling request: " + req);
                System.out.println("Request queue is now: " + track.data);
            }
        }


    }

}