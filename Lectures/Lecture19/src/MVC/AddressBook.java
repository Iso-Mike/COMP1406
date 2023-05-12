package MVC;
public class AddressBook{
    private Person[] people;
    private int curPeople;
    private final int MAX_PEOPLE = 100;

    public AddressBook(){
        people = new Person[MAX_PEOPLE];
        curPeople = 0;
    }

    public void addPerson(Person p){
        if(curPeople < people.length){
            people[curPeople] = p;
            curPeople++;
        }
    }

    public void removePerson(int index){
        if(index >= 0 && index < curPeople){
            people[index] = null;
            for(int i = index+1; i < curPeople; i++){
                Person temp = people[i-1];
                people[i-1] = people[i];
                people[i] = temp;
            }
            curPeople--;
        }
    }

    public Person getPerson(int index){
        if(index >= 0 && index < curPeople){
            return people[index];
        }
        return null;
    }

    public int getCurPeople(){
        return curPeople;
    }

    public Person[] getPeople(){
        return people;
    }

    public Person[] getMatchingPeople(String name){
        int count = 0;
        for(int i = 0; i < curPeople; i++){
            if(people[i].getName().toLowerCase().contains(name.toLowerCase())){
                count++;
            }
        }
        Person[] result = new Person[count];
        int index = 0;
        for(int i = 0; i < curPeople; i++){
            if(people[i].getName().toLowerCase().contains(name.toLowerCase())){
                result[index] = people[i];
                index++;
            }
        }
        return result;
    }

    public String toString(){
        String result = "";
        for(int i = 0; i < curPeople; i++){
            result += people[i].getName() + "\n";
        }
        return result;
    }


    public static void main(String[] args){
        AddressBook b = AddressBook.createBook();
        System.out.println(b);
        b.removePerson(0); //dave
        b.removePerson(2); //martha
        b.removePerson(4); //carlos
        System.out.println(b);
        b.removePerson(4);
        b.removePerson(-1);
        System.out.println(b);
    }

    public static AddressBook createBook(){
        AddressBook b = new AddressBook();
        Person p1 = new Person("Dave");
        p1.setPrimary(new Address("Dave Ave.", "Davetown", "ON", "K1R7L2"));
        p1.setSecondary(new Address("Dave St.", "Davisville", "ON", "K1R7L2"));
        b.addPerson(p1);
        p1 = new Person("Mathilda");
        p1.setPrimary(new Address("Mathildas St", "Mathildavilla", "ON", "K3V5N2"));
        p1.setSecondary(new Address("Mathildas Other St.", "Mathildaville", "ON", "POST"));
        b.addPerson(p1);
        p1 = new Person("Reginald");
        p1.setPrimary(new Address("Murray St.", "Ottawa", "ON", "K1R7L2"));
        p1.setSecondary(new Address("Nepean Ave.", "Ottawa", "ON", "K1R7L2"));
        b.addPerson(p1);
        p1 = new Person("Martha");
        p1.setPrimary(new Address("177 Macy Blvd", "Ottawa", "ON", "K1R7L2"));
        p1.setSecondary(new Address("219 Bell St. N", "Ottawa", "ON", "K1R7L2"));
        b.addPerson(p1);
        p1 = new Person("George");
        p1.setPrimary(new Address("3 Maple Lake", "Sunnyvale", "ON", "K1R7L2"));
        p1.setSecondary(new Address("2 Bonnyview", "Sunnyvale", "ON", "K1R7L2"));
        b.addPerson(p1);
        p1 = new Person("Tiffany");
        p1.setPrimary(new Address("133 Albert St.", "Ottawa", "ON", "K1R7L2"));
        p1.setSecondary(new Address("99 Bank St.", "Ottawa", "ON", "K1R7L2"));
        b.addPerson(p1);
        p1 = new Person("Carlos");
        p1.setPrimary(new Address("Tired of creating addresses St.", "Toronto", "ON", "K1R7L2"));
        p1.setSecondary(new Address("847 Thorton Dr.", "Toronto", "ON", "K1R7L2"));
        b.addPerson(p1);
        return b;

    }
}