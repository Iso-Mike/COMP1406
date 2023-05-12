package University;
import java.util.*;
public class Course {
    private String courseCode;
    private Faculty instructor;
    private List<TeachingAssistant> tas;
    private List<Student> registeredStudents;

    public Course(String courseCode, Faculty instructor){
        this.courseCode = courseCode;
        this.instructor = instructor;
        tas = new ArrayList();
        registeredStudents = new ArrayList();
    }

    //Adds the given TA to the list of TAs for the course
    public boolean addTA(TeachingAssistant ta){
        if(tas.contains(ta) || ta == null){
            return false;
        }

        tas.add(ta);
        return true;
    }

    //Adds the given student to the list of students registered in the course
    public boolean addStudent(Student s){
        if(registeredStudents.contains(s) || s == null){
            return false;
        }

        registeredStudents.add(s);
        return true;
    }

    //Removes the given student from the list of registered students
    public boolean removeStudent(Student s){
        return registeredStudents.remove(s);
    }

    //Print all students registered in the course
    public void printStudents(){
        System.out.println("Students registered in " + courseCode);
        for(Student s: registeredStudents){
            System.out.println(s);
        }
    }
}
