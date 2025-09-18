import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SchoolManager manager = new SchoolManager();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1: Student hinzufügen\n2: Kurs hinzufügen\n3: Student zu Kurs zuordnen\n4: Kurse anzeigen\n5: Studenten eines Kurses anzeigen\n0: Beenden");
            int choice = sc.nextInt();
            sc.nextLine(); // Zeilenumbruch einlesen

            switch (choice) {
                case 1 -> {
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    manager.addStudent(new Student(manager.getCourses().size() + 1, name, email));
                }
                case 2 -> {
                    System.out.print("Kursname: ");
                    String name = sc.nextLine();
                    manager.addCourse(new Course(manager.getCourses().size() + 1, name));
                }
                case 3 -> {
                    System.out.print("Student-ID: ");
                    int sId = sc.nextInt();
                    System.out.print("Kurs-ID: ");
                    int cId = sc.nextInt();
                    sc.nextLine();
                    Student s = manager.getCourses().stream().flatMap(c -> c.getStudents().stream()).filter(st -> st.getId() == sId).findFirst().orElse(null);
                    Course c = manager.getCourses().stream().filter(course -> course.toString().startsWith(String.valueOf(cId))).findFirst().orElse(null);
                    if (s != null && c != null) manager.assignStudentToCourse(s, c);
                }
                case 4 -> manager.getCourses().forEach(System.out::println);
                case 5 -> {
                    System.out.print("Kurs-ID: ");
                    int cId = sc.nextInt();
                    sc.nextLine();
                    Course c = manager.getCourses().stream().filter(course -> course.toString().startsWith(String.valueOf(cId))).findFirst().orElse(null);
                    if (c != null) c.getStudents().forEach(System.out::println);
                }
                case 0 -> running = false;
            }
        }
        sc.close();
    }
}
