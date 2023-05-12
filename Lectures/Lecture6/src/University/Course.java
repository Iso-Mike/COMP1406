package University;

public class Course {
    private String courseCode;
    private Faculty instructor;
    private TeachingAssistant[] tas;
    private Student[] registeredStudents;

    public Course(String courseCode, Faculty instructor){
        this.courseCode = courseCode;
        this.instructor = instructor;
        tas = new TeachingAssistant[100];
        registeredStudents = new Student[100];
    }

    public boolean addTA(TeachingAssistant ta){
        for(int i = 0; i < tas.length; i++){
            if(tas[i] == null){
                tas[i] = ta;
                return true;
            }
        }
        return false;
    }

    public boolean addStudent(Student s){
        for(int i = 0; i < registeredStudents.length; i++){
            if(registeredStudents[i] == null){
                registeredStudents[i] = s;
                return true;
            }
        }
        return false;
    }

    /*
    Go through all the indices of our registeredStudents array
    Find the index of a student that matches 's'
    Set that index to null
     */
    public boolean removeStudent(Student s){
        for(int i = 0; i < registeredStudents.length; i++){
            if(registeredStudents[i].isSameAs(s)){ //whats wrong here?
                registeredStudents[i] = null;
                return true;
            }
        }
        return false;
    }

    public void printStudents(){
        System.out.println("Students registered in " + courseCode);
        for(Student s: registeredStudents){
            if(s != null){
                System.out.println(s);
            }
        }
    }

}
