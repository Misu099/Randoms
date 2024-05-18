import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InteractiveStudentGrades {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public static void main(String[] args) {
        HashMap<Integer, String> studentGrades = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudentGrade(studentGrades, scanner);
                    break;
                case 2:
                    retrieveGrade(studentGrades, scanner);
                    break;
                case 3:
                    updateGrade(studentGrades, scanner);
                    break;
                case 4:
                    removeStudent(studentGrades, scanner);
                    break;
                case 5:
                    displayAllGrades(studentGrades);
                    break;
                case 6:
                    exit = true;
                    System.out.println(ANSI_GREEN + "Exiting the application. Goodbye!" + ANSI_RESET);
                    break;
                default:
                    System.out.println(ANSI_RED + "Invalid choice! Please try again." + ANSI_RESET);
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println(ANSI_BLUE + "\nStudent Grades Management System" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "1. Add Student Grade" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "2. Retrieve Student Grade" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "3. Update Student Grade" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "4. Remove Student" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "5. Display All Grades" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "6. Exit" + ANSI_RESET);
        System.out.print(ANSI_YELLOW + "Enter your choice: " + ANSI_RESET);
    }

    private static void addStudentGrade(HashMap<Integer, String> studentGrades, Scanner scanner) {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (studentGrades.containsKey(id)) {
            System.out.println(ANSI_RED + "Student ID already exists, please use update." + ANSI_RESET);
            return;
        }
        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();
        studentGrades.put(id, grade);
        System.out.println(ANSI_GREEN + "Grade added successfully!" + ANSI_RESET);
    }

    private static void retrieveGrade(HashMap<Integer, String> studentGrades, Scanner scanner) {
        System.out.print("Enter student ID to retrieve grade: ");
        int id = scanner.nextInt();
        String grade = studentGrades.get(id);
        if (grade != null) {
            System.out.println("Grade for student ID " + id + " is: " + ANSI_BLUE + grade + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Student ID not found!" + ANSI_RESET);
        }
    }

    private static void updateGrade(HashMap<Integer, String> studentGrades, Scanner scanner) {
        System.out.print("Enter student ID to update grade: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (studentGrades.containsKey(id)) {
            System.out.print("Enter new grade: ");
            String newGrade = scanner.nextLine();
            studentGrades.put(id, newGrade);
            System.out.println(ANSI_GREEN + "Grade updated successfully!" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Student ID not found!" + ANSI_RESET);
        }
    }

    private static void removeStudent(HashMap<Integer, String> studentGrades, Scanner scanner) {
        System.out.print("Enter student ID to remove: ");
        int id = scanner.nextInt();
        if (studentGrades.remove(id) != null) {
            System.out.println(ANSI_GREEN + "Student removed successfully!" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Student ID not found!" + ANSI_RESET);
        }
    }


    private static void displayAllGrades(HashMap<Integer, String> studentGrades) {
        System.out.println(ANSI_BLUE + "\nAll Student Grades:" + ANSI_RESET);
        for (Map.Entry<Integer, String> entry : studentGrades.entrySet()) {
            System.out.println("Student ID: " + entry.getKey() + ", Grade: " + ANSI_BLUE + entry.getValue() + ANSI_RESET);
        }
    }
}

