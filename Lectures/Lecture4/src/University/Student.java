package University;

public class Student {
    //register course
    //drop course
    String name;
    int studentNumber;
    Course[] registeredCourses;
    static final int MAX_COURSES = 10;
    static int nextStudentNumber = 10000;

    public Student(String initName){
        name = initName;
        studentNumber = nextStudentNumber;
        nextStudentNumber++;
        registeredCourses = new Course[MAX_COURSES];
    }

    public boolean addCourse(Course aCourse){
        for(int i = 0; i < registeredCourses.length; i++){
            if(registeredCourses[i] == null){
                registeredCourses[i] = aCourse;
                return true;
            }
        }
        return false;
    }

    public boolean dropCourse(Course aCourse){
        for(int i = 0; i < registeredCourses.length; i++){
            if(registeredCourses[i].equals(aCourse)){
                registeredCourses[i] = null;
                return true;
            }
        }

        return false;
    }

}
