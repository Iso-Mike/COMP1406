package Business;
public class PolymorphismExample{
  public static void main(String[] args){
   Manager dave = new Manager("Dave", 1, 1000);
   Employee farah = new Employee("Farah", 2, 500);
   Customer steve = new Customer("Steve", 2500);
   
   dave.addSubordinate(farah);
   System.out.println(dave);
   System.out.println(farah);
   System.out.println(steve);
   
   //Create Person variables for each of the previous objects
   //Note, we cannot use "new Person" because Person is abstract
   //We can, however, create new instances of subclasses and treat them as Person objects
   Person p1 = (Person)dave;
   Person p2 = (Person)farah;
   Person p3 = (Person)steve;
   Person p4 = new Customer("Sonia", 5000);
   
   //The behaviour (i.e., implementation is the same)
   //We are just limited to the methods we can call (those supported by Person type)
   System.out.println(dave);
   System.out.println(p1);
   System.out.println(farah);
   System.out.println(p2);
   System.out.println(steve);
   System.out.println(p3);


   System.out.println(farah.getEmployeeID());
   //p2 and farah are the same objects
   //So why will the line below cause a compile error?
   //System.out.println(p2.getEmployeeID());
   
   //Create an Insurable version of dave
   Insurable i1 = dave;
   System.out.println(i1.getPolicyNumber());
   System.out.println(dave.getPolicyNumber());
   
   //What will happen if we uncomment this line?
   //Why?
   //Manager m = (Manager)farah;
  }
}