package University;

public class Faculty implements Payable {
    private String name;
    private String office;
    private int weeklySalary;
    private int totalPaid;

    public Faculty(String initName){
        this(initName, "No Office");
    }

    public Faculty(String initName, String initOffice){
        name = initName;
        office = initOffice;
        weeklySalary = 500;
        totalPaid = 0;
    }

    public void givePay(){
        //a bunch of actual banking stuff
        totalPaid += weeklySalary;
    }

    public String toString(){
        return name + " (" + office + ") has been paid " + totalPaid;
    }
}
