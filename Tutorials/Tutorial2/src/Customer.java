public class Customer {
    String name;
    int age;
    float money;
    boolean admitted;

    public Customer() {
        name = "Person";
        age = 0;
        money = 0;
        admitted = false;
    }

    public Customer(String initname) {
        name = initname;
        age = 0;
        money = 0.0f;
        admitted = false;
    }

    public Customer(String initname, int initAge){
        name = initname;
        age = initAge;
        money = 0.0f;
        admitted = false;
    }

    public Customer(String initname, int initAge, float initMoney){
        name = initname;
        age = initAge;
        money = initMoney;
        admitted = false;
    }

    public float computeFee() {
        float fee;

        if(age >= 18 && age < 65) {
            fee = 12.75f;
        }

        else if(age >= 65) {
            fee = 0.5f * 12.75f;
        }

        else if(age <= 3) {
            fee = 0;
        }

        else if(age >= 4 && age <=17) {
            fee = 8.5f;
        }

        else {
            fee = 12.75f;
        }

        return fee;
    }

    public boolean spend(float amount) {

        if(amount < 0){
            return false;
        }

        else if(money >= amount) {
            money = money - amount;
            return true;
        }

        return false;
    }

    public boolean hasMoreMoneyThan(Customer c){
        if(money > c.money){
            return true;
        }

        return false;
    }

    public void payAdmission(){
        if(spend(computeFee())) {
            admitted = true;
        }
    }

    public  String toString() {
        if(!admitted) {
            return "Customer " + name + ": a " + age + " year old with $" + money + " who has not been admitted";
        }
        return "Customer " + name + ": a " + age + " year old with $" + money + " who has been admitted";
    }
}
