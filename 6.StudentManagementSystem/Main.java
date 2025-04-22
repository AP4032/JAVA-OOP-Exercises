import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();

        System.out.println("=== Student Management System ===");

        boolean running = true;
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Student in Course");
            System.out.println("4. Assign Grade");
            System.out.println("5. Show Student Grades");
            System.out.println("6. Exit");
            System.out.println("7. Show All Students");
            System.out.println("8. Show All Courses");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    Student student = new Student(studentName);
                    admin.addStudent(student);
                    System.out.println("Student created with ID: " + student.getStudentId());
                    break;

                case 2:
                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();
                    Course course = new Course(courseName);
                    admin.addCourse(course);
                    break;

                case 3:
                    System.out.print("Enter student ID: ");
                    int sidEnroll = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter course name: ");
                    String courseEnroll = scanner.nextLine();

                    Student foundStudent = findStudentById(admin, sidEnroll);
                    if (foundStudent != null) {
                        foundStudent.enrollInCourse(courseEnroll);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter student ID: ");
                    int sidGrade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter course name: ");
                    String courseGrade = scanner.nextLine();
                    System.out.print("Enter grade: ");
                    double grade = scanner.nextDouble();
                    scanner.nextLine();

                    Student studentForGrade = findStudentById(admin, sidGrade);
                    if (studentForGrade != null) {
                        studentForGrade.assignGrade(courseGrade, grade);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter student ID: ");
                    int sidPrint = scanner.nextInt();
                    scanner.nextLine();

                    Student studentForPrint = findStudentById(admin, sidPrint);
                    if (studentForPrint != null) {
                        studentForPrint.printGrades();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 6:
                    running = false;
                    System.out.println("Exiting... Goodbye!");
                    break;

                case 7:
                    showAllStudents(admin);
                    break;

                case 8:
                    showAllCourses(admin);
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }

    public static Student findStudentById(Admin admin, int studentId) {
        for (Student s : admin.getStudents()) {
            if (s.getStudentId() == studentId) {
                return s;
            }
        }
        return null;
    }

    public static void showAllStudents(Admin admin) {
        System.out.println("--- List of Students ---");
        if (admin.getStudents().isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student s : admin.getStudents()) {
                System.out.println("Name: " + s.getName() + " | ID: " + s.getStudentId());
            }
        }
    }

    public static void showAllCourses(Admin admin) {
        System.out.println("--- List of Courses ---");
        if (admin.getCourses().isEmpty()) {
            System.out.println("No courses available.");
        } else {
            for (Course c : admin.getCourses()) {
                System.out.println("Course Name: " + c.getName());
            }
        }
    }
}
