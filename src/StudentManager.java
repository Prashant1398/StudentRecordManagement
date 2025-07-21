import java.util.*;
import java.io.*;

public class StudentManager {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Scanner scanner) {
    String id;
    while (true) {
        System.out.print("Enter ID: ");
        id = scanner.nextLine();
        boolean exists = false;
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                exists = true;
                break;
            }
        }
        if (exists) {
            System.out.println("ID already exists. Please enter a unique ID.");
        } else {
            break;
        }
    }
    System.out.print("Enter Name: ");
    String name = scanner.nextLine();
    System.out.print("Enter Course: ");
    String course = scanner.nextLine();
    System.out.print("Enter Grade: ");
    double grade = scanner.nextDouble();
    scanner.nextLine();
    students.add(new Student(id, name, course, grade));
    System.out.println("Student added.");
}

    public void viewAllStudents() {
        if(students.isEmpty()) {
            System.out.println();
            System.out.println("No students found.");
            return;
        }
        System.out.println();
        System.out.printf("%-10s %-20s %-15s %-10s%n", "ID", "Name", "Course", "Grade");
        for (Student s : students) {
            System.out.println();
            // Table header

            // Table row
           // System.out.printf("%-10s %-20s %-15s %-10.2f%n", s.getId(), s.getName(), s.getCourse(), s.getGrade());
            // Or, if you want both formats:
        
            System.out.printf("%-10s %-20s %-15s %-10.2f%n", s.getId(), s.getName(), s.getCourse(), s.getGrade());
            
        }
    }

   public void searchStudent(Scanner scanner) {
    System.out.print("Enter ID or Name to search: ");
    String query = scanner.nextLine();
    boolean found = false;
    for (Student s : students) {
        if (s.getId().equalsIgnoreCase(query) || s.getName().equalsIgnoreCase(query)) {
            System.out.println(s);
            found = true;
        }
    }
    if (!found) {
        System.out.println("Student not found.");
    }
}

    public void updateStudent(Scanner scanner) {
        System.out.print("Enter Student ID to update: ");
        String id = scanner.nextLine();
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                System.out.print("Enter new name: ");
                s.setName(scanner.nextLine());
                System.out.print("Enter new course: ");
                s.setCourse(scanner.nextLine());
                System.out.print("Enter new grade: ");
                s.setGrade(scanner.nextDouble());
                scanner.nextLine();
                System.out.println("Student updated.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void deleteStudent(Scanner scanner) {
        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine();
        students.removeIf(s -> s.getId().equalsIgnoreCase(id));
        System.out.println("If existed, student was removed.");
    }

    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Student s : students) {
                writer.println(s);
            }
            System.out.println("Data saved.");
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    public void loadFromFile(String filename) {
        students.clear();
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextLine()) {
                students.add(Student.fromString(fileScanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            // Ignore if file doesn't exist
        }
    }
}
