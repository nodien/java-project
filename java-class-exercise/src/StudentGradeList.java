import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentGradeList {
    private final List<String> studentList = new ArrayList<>(100);
    private final List<Double> gradeList   = new ArrayList<>(100);
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new StudentGradeList().run();
    }

    public void run() {
        studentList.add("Nguyễn Văn A");
        studentList.add("Nguyễn Văn B");
        studentList.add("Nguyễn Văn C");
        studentList.add("Nguyễn Văn D");
        studentList.add("Nguyễn Văn E1");
        studentList.add("Nguyễn Văn E2");
        studentList.add("Nguyễn Văn E3");
        studentList.add("Nguyễn Văn E4");
        studentList.add("Nguyễn Văn E5");

        gradeList.add(3.0);
        gradeList.add(4.0);
        gradeList.add(4.0);
        gradeList.add(5.0);
        gradeList.add(6.0);
        gradeList.add(7.0);
        gradeList.add(8.0);
        gradeList.add(9.0);
        gradeList.add(9.0);


        int choice;
        do {
            menu();
            while (!sc.hasNextInt()) {
                System.out.print("Invalid input. Enter a number 1–6: ");
                sc.next();
            }
            choice = sc.nextInt();
            switch (choice) {
                case 1: addStudent();      break;
                case 2: showAllStudents(); break;
                case 3: showStatistics();  break;
                case 4: searchByGrade();   break;
                case 5: showClassification(); break;
                case 6: showStudentsSortedByGradeBubbleSort(); break;
                case 7:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Choice must be 1–6; try again.");
                    continue;
            }
        } while (choice != 7 );
    }

    void menu() {
        System.out.println("\n=== STUDENT LIST MENU ===");
        System.out.println("1. Add a student");
        System.out.println("2. Show all students");
        System.out.println("3. Show statistics (average, count ≥5, max & min)");
        System.out.println("4. Search for students by grade");
        System.out.println("5. Show academic performance classification");
        System.out.println("6. Show student grades sort by grade");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    void addStudent() {
        sc.nextLine();
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        double grade;
        while (true) {
            System.out.print("Enter student grade (0.0–10.0): ");
            if (!sc.hasNextDouble()) {
                System.out.println("Not a number. Try again.");
                sc.next();
                continue;
            }
            grade = sc.nextDouble();
            if (grade < 0 || grade > 10) {
                System.out.println("Grade must be between 0 and 10.");
                continue;
            }
            break;
        }

        studentList.add(name);
        gradeList.add(grade);
        System.out.println("Student added successfully.");
    }

    void showAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students yet. Please add some first.");
            return;
        }
        System.out.println("\nAll students:");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.printf("%d. %s – %.2f%n",
                    i + 1, studentList.get(i), gradeList.get(i));
        }
    }

    void showStatistics() {
        if (gradeList.isEmpty()) {
            System.out.println("No data. Add students first.");
            return;
        }
        double sum = 0;
        int passCount = 0;
        double max = gradeList.getFirst();
        double min = gradeList.getFirst();

        for (double g : gradeList) {
            sum += g;
            if (g >= 5.0) passCount++;
            if (g > max) max = g;
            if (g < min) min = g;
        }

        double average = sum / gradeList.size();
        System.out.printf("Average grade: %.2f%n", average);
        System.out.println("Number of students passing (≥5): " + passCount);
        System.out.println("Highest grade: " + max);
        System.out.println("Lowest grade: " + min);
    }

    void searchByGrade() {
        if (studentList.isEmpty()) {
            System.out.println("No data. Add students first.");
            return;
        }
        System.out.print("Enter grade to search for: ");
        if (!sc.hasNextDouble()) {
            System.out.println("Invalid number. Returning to menu.");
            sc.next();
            return;
        }
        double target = sc.nextDouble();
        System.out.printf("%nStudents with grade %.2f:%n", target);

        boolean found = false;
        for (int i = 0; i < gradeList.size(); i++) {
            if (!gradeList.get(i).equals(target)) {
                continue;
            }
            System.out.printf("%d. %s%n", i + 1, studentList.get(i));
            found = true;
        }
        if (!found) {
            System.out.println("None found.");
        }
    }

    void showClassification() {
        if (studentList.isEmpty()) {
            System.out.println("No data. Add students first.");
            return;
        }
        System.out.println("\nAcademic Performance Classification:");
        for (int i = 0; i < gradeList.size(); i++) {
            double g = gradeList.get(i);
            String cls;
            if (g >= 8.0)      cls = "Excellent";
            else if (g >= 6.5) cls = "Good";
            else if (g >= 5.0) cls = "Average";
            else               cls = "Poor";

            System.out.printf("%d. %s – %.2f : %s%n",
                    i + 1, studentList.get(i), g, cls);
        }
    }


    public void showStudentsSortedByGradeBubbleSort() {
        if (studentList.isEmpty()) {
            System.out.println("No students yet. Please add some first.");
            return;
        }

        int n = gradeList.size();
        int[] idx = new int[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }

        for (int pass = 0; pass < n - 1; pass++) {
            for (int j = 0; j < n - 1 - pass; j++) {
                double g1 = gradeList.get(idx[j]);
                double g2 = gradeList.get(idx[j + 1]);
                if (g1 > g2) {
                    int tmp = idx[j];
                    idx[j] = idx[j + 1];
                    idx[j + 1] = tmp;
                }
            }
        }

        System.out.println("\nStudents sorted by grade (lowest → highest):");
        for (int rank = 0; rank < n; rank++) {
            int i = idx[rank];
            System.out.printf("%d. %s – %.2f%n",
                    rank + 1,
                    studentList.get(i),
                    gradeList.get(i));
        }
    }




}
