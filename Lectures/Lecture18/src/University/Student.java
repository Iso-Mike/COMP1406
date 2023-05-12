package University;
import java.util.*;
public class Student {
    private String name;
    private int studentNumber;
    private List<Course> registeredCourses;
    private static final int MAX_COURSES = 10;
    private static int nextStudentId = 10000;

    public Student(String initName){
        name = initName;
        studentNumber = nextStudentId;
        nextStudentId++;
        registeredCourses = new ArrayList();
    }

    public String getName(){
        return name;
    }

    //Attempts to register this student in the given course
    //Returns true if successfully registered, false otherwise
    public boolean addCourse(Course aCourse){
        if(aCourse.addStudent(this)){
            registeredCourses.add(aCourse);
            return true;
        }

        return false;
    }

    //Attempts to de-register this student from the given course
    //Returns true if successfully dropped, false otherwise
    public boolean dropCourse(Course aCourse){
        if(aCourse.removeStudent(this)){
            return true;
        }
        return false;
    }

    //Returns true if the calling Student is the same as the argument Student
    public boolean isSameAs(Student s){
        return this.studentNumber == s.studentNumber;
    }

    public String toString(){
        return name + "(" + studentNumber + ")";
    }
}
