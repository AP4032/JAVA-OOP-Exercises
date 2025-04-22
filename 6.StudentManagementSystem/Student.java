import java.util.HashMap;
import java.util.Map;

public class Student {
    private static int idCounter = 100;
    private String name;
    private int studentId;
    private Map<String, Double> grades;

    public Student(String name) {
        this.name = name;
        this.studentId = idCounter++;
        this.grades = new HashMap<>();
    }

    public void enrollInCourse(String course) {
        grades.put(course, null);
        System.out.println(name + " enrolled in " + course);
    }

    public void assignGrade(String course, double grade) {
        if (grades.containsKey(course)) {
            grades.put(course, grade);
            System.out.println("Grade assigned: " + grade + " in " + course);
        } else {
            System.out.println("Student not enrolled in " + course);
        }
    }

    public void printGrades() {
        System.out.println("Grades for " + name + ": " + grades);
    }

    public String getName() {
        return name;
    }

    public int getStudentId() {
        return studentId;
    }
}
