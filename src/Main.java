import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SchoolManager manager = new SchoolManager();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Kursverwaltung ===");
            System.out.println("1: Student hinzufügen");
            System.out.println("2: Kurs hinzufügen");
            System.out.println("3: Student zu Kurs zuordnen");
            System.out.println("4: Kurse anzeigen");
            System.out.println("5: Studenten eines Kurses anzeigen");
            System.out.println("0: Beenden");
            System.out.print("Eingabe: ");           
            
            int choice = sc.nextInt();
            sc.nextLine(); // Zeilenumbruch einlesen

            switch (choice) {
                case 1 -> {
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    manager.addStudent(new Student(name, email));
                    System.out.println("✅ Student hinzugefügt!");
                }
                case 2 -> {
                    System.out.print("Kursname: ");
                    String name = sc.nextLine();
                    manager.addCourse(new Course(name));
                    System.out.println("✅ Kurs hinzugefügt!");
                }
                case 3 -> {
                    System.out.print("Student-ID: ");
                    int sId = sc.nextInt();
                    System.out.print("Kurs-ID: ");
                    int cId = sc.nextInt();
                    sc.nextLine();
            
                    Student s = manager.findStudentById(sId);
                    Course c = manager.findCourseById(cId);

                    if (s != null && c != null){ manager.assignStudentToCourse(s, c);
                        System.out.println("✅ Student zu Kurs zugeordnet!");
                    }
                     else System.out.println("⚠️ Ungültige IDs!");
                }
                case 4 ->{
                    System.out.println("📚 Kurse:"); 
                    manager.getCourses().forEach(System.out::println);
                }
                case 5 -> {
                    System.out.print("Kurs-ID: ");
                    int cId = sc.nextInt();
                    sc.nextLine();
                    Course c = manager.getCourses().stream().filter(st -> st.getId() == cId).findFirst().orElse(null);
                    if (c != null) {
                        System.out.println("Gefundener Kurs: " + c.getName() + ", Studentenanzahl: " + c.getStudents().size());
                        c.getStudents().forEach(System.out::println);
                    } else {
                        System.out.println("Kein Kurs mit dieser ID gefunden.");
                    }
                }
                case 0 -> {
                    running = false;
                    System.out.println("Programm beendet.");
                }
                default -> System.out.println("Ungültige Eingabe. Bitte erneut versuchen.");
            }               
        }
        sc.close();
    }
}
