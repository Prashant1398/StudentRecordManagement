import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.loadFromFile("data/student_data.txt");
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Save & Exit");
            System.out.print("Enter choice from listed options: ");
            while (true) {
                try {
                    choice = scanner.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid choice. Please enter a valid number.");
                    scanner.nextLine(); // Clear invalid input
                    System.out.print("Enter choice from listed options: ");
                }
            }
            scanner.nextLine();  // Consume newline
            switch (choice) {
                case 1: manager.addStudent(scanner); break;
                case 2: manager.viewAllStudents(); break;
                case 3: manager.searchStudent(scanner); break;
                case 4: manager.updateStudent(scanner); break;
                case 5: manager.deleteStudent(scanner); break;
                case 6: manager.saveToFile("data/student_data.txt"); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 6);
        scanner.close();
    }
}
