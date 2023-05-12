package University;
import java.util.*;
public class University {
    private List<Faculty> faculty;
    private int numFaculty;
    private List<TeachingAssistant> tas;
    private int numTAs;
    private List<Student> students;
    private int numStudents;
    private List<Course> courses;
    private int numCourses;
    private List<Payable> employees;
    private int numEmployees;

    public University(String name){
        faculty = new ArrayList();
        tas = new ArrayList();
        students = new ArrayList();
        courses = new ArrayList();
        employees = new ArrayList();
    }

    //Adds the given faculty member to the list of faculty
    public boolean addFaculty(Faculty f){
        if(faculty.contains(f) || f == null){
            return false;
        }

        faculty.add(f);
        employees.add(f);
        return true;
    }

    //Adds the given student to the list of students
    public boolean addStudent(Student s){
        if(students.contains(s) || s == null){
            return false;
        }

        students.add(s);
        return true;
    }

    //Adds the given course to the list of courses
    public boolean addCourse(Course c){
        if(courses.contains(c) || c == null){
            return false;
        }

        courses.add(c);
        return true;
    }

    //Adds the given TA to the list of TA
    public boolean addTA(TeachingAssistant ta){
        if(tas.contains(ta) || ta == null){
            return false;
        }

        tas.add(ta);
        tas.add(ta);
        return true;
    }

    //Simulate paying all of the employees
    public void payEmployees(){
        for(Payable employee: employees){
            employee.givePay();
        }
    }
}
