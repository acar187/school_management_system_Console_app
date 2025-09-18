import java.util.ArrayList;
import java.util.List;

public class SchoolManager {
    private List<Course> coursesList = new ArrayList<>();
    private List<Student> studentsList = new ArrayList<>();

    public void addCourse(Course course) {
        coursesList.add(course);
    }
    public void addStudent(Student student) {
        studentsList.add(student);
    }

    public void assignStudentToCourse(Student student, Course course) {
        if(studentsList.contains(student) && coursesList.contains(course)) {
            course.addStudent(student);
        }
    }
    
    public List<Course> getCourses() {
        return coursesList;
    }

}
