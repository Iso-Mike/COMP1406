package University;

public class University {
    private Faculty[] faculty;
    private int numFaculty;
    private TeachingAssistant[] tas;
    private int numTAs;
    private Student[] students;
    private int numStudents;
    private Course[] courses;
    private int numCourses;

    public University(String name){
        faculty = new Faculty[1000];
        tas = new TeachingAssistant[1000];
        students = new Student[1000];
        courses = new Course[1000];
        numFaculty = 0;
        numStudents = 0;
        numCourses = 0;
        numTAs = 0;
    }

    public boolean addFaculty(Faculty f){
        if(numFaculty >= faculty.length){
            return false;
        }

        faculty[numFaculty] = f;
        numFaculty++;
        return true;
    }

    public boolean addStudent(Student s){
        if(numStudents >= students.length){
            return false;
        }

        students[numStudents] = s;
        numStudents++;
        return true;
    }

    public boolean addCourse(Course c){
        if(numCourses >= courses.length){
            return false;
        }

        courses[numCourses] = c;
        numCourses++;
        return true;
    }

    public boolean addTA(TeachingAssistant ta){
        if(numTAs >= tas.length){
            return false;
        }

        tas[numTAs] = ta;
        numTAs++;
        return true;
    }

    public void payEmployees(){
        //for each faculty
        // f.getPaid()
        //for each TA
        // ta.getPaid()
    }
}
