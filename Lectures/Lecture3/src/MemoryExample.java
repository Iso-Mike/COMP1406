public class MemoryExample {
    public static void main(String[] args){
        //Memory is initially 'empty' (not really, but we haven't created
        // any with our code)

        //The below allocates stack memory to store our Address object
        //This is a fixed size, because it is just a memory reference
        Address x;

        //Instantiate a new address object
        //This takes up heap memory where the address will be stored
        //Java knows how much space is required (1 integer, 5 references)
        x = new Address();

        //On the right hand side, we create a new string instance
        //This allocates heap memory to store the 5 characters
        //The name attribute of x now points to that heap location
        //Regardless of the size of the string, name is still just a
        // fixed-size reference
        //So our Address object's size in memory is unchanged
        x.name = new String("Ricky");

        //If we change the name to something longer...
        //The new string is put in heap memory
        //Our Address size stays the same, but the pointer changes
        x.name = new String("Ricky Lahey");

        //The line below allocates new stack (to store y's location) memory
        //as well as new heap memory(to store the Address object data)
        Address y = new Address();

        //When our method ends, the local variables (x/y) can be cleared
        // from stack memory
        //Ultimately, Java will clear the heap memory for the strings too
        //It does this using a process called 'garbage collection'
        //(if you take a C course, you get to manage this on your own...)
    }
}
