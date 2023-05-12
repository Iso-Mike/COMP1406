package University;

public class UniversityTester {
    public static void main(String[] args){
        Faculty dave = new Faculty("Dave McKenney", "HP 5171");
        Course comp1406 = new Course("COMP 1406", dave);

        Student s1 = new Student("name1");
        Student s2 = new Student("name2");
        Student s3 = new Student("name3");
        Student s4 = new Student("name4");
        Student s5 = new Student("name4");

        TeachingAssistant paul = new TeachingAssistant("Paul");
        TeachingAssistant earle = new TeachingAssistant("Earle");
        comp1406.addTA(paul);
        comp1406.addTA(earle);

        s1.addCourse(comp1406);
        s2.addCourse(comp1406);
        s3.addCourse(comp1406);
        s4.addCourse(comp1406);
        s5.addCourse(comp1406);

        comp1406.printStudents();
        s5.dropCourse(comp1406);
        comp1406.printStudents();


        System.out.println(earle);
        System.out.println(paul);
        System.out.println(dave);

        University carleton = new University("Carleton");
        carleton.addFaculty(dave);
        carleton.addTA(paul);
        carleton.addTA(earle);

        carleton.payEmployees();

        System.out.println(earle);
        System.out.println(paul);
        System.out.println(dave);





    }
}
