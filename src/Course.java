import java.util.ArrayList;
import java.util.List;

public class Course {  
    int id;
    String name;
    List<Student> studentsList = new ArrayList<>();

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public List<Student> getStudents() {
        return studentsList;
    }
    public void addStudent(Student student) {
        studentsList.add(student);
    }
    public void removeStudent(Student student) {
        studentsList.remove(student);
    }


    @Override
    public String toString() {
        return "Course [id=" + id + ", name=" + name + ", students=" + studentsList + "]";
    }
    
}
