package University;

public class Student {
    private String name;
    private int studentNumber;
    private Course[] registeredCourses;
    private static final int MAX_COURSES = 10;
    private static int nextStudentId = 10000;

    public Student(String initName){
        name = initName;
        studentNumber = nextStudentId;
        nextStudentId++;
        registeredCourses = new Course[MAX_COURSES];
    }

    public boolean addCourse(Course aCourse){
        for(int i = 0; i < registeredCourses.length; i++){
            if(registeredCourses[i] == null){
                registeredCourses[i] = aCourse;
                aCourse.addStudent(this);
                return true;
            }
        }
        return false;
    }

    public boolean dropCourse(Course aCourse){
        for(int i = 0; i < registeredCourses.length; i++){
            if(registeredCourses[i].equals(aCourse)){
                registeredCourses[i] = null;
                aCourse.removeStudent(this);
                return true;
            }
        }
        return false;
    }

    public boolean isSameAs(Student s){
        return this.studentNumber == s.studentNumber;
    }

    public String toString(){
        return name + "(" + studentNumber + ")";
    }
}
