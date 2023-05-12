package University;

public class TeachingAssistant extends Student implements Payable {
    private int weeklySalary;
    private int totalPaid;

    public TeachingAssistant(String initName){
        super(initName);
        weeklySalary = 250;
        totalPaid = 0;
    }

    public void givePay(){
        //a bunch of actual banking stuff
        totalPaid += weeklySalary;
    }

    public String toString(){
        return getName() + " has been paid " + totalPaid;
    }
}
