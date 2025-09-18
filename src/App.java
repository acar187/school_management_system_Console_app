public class App {
    public static void main(String[] args) {
        Course course = new Course(1, "Mathematik");
        Student student1 = new Student(1, "Erkan Acar", "test@gmail.com");
        Student student2 = new Student(2, "Max Mustermann", "max@gmail.com");

        course.addStudent(student1);
        course.addStudent(student2);

        System.out.println(course);
    }
    
}
