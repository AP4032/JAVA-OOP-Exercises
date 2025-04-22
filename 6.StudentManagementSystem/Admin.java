import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Student> students;
    private List<Course> courses;

    public Admin() {
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Added student: " + student);
    }

    public void addCourse(Course course) {
        courses.add(course);
        System.out.println("Added course: " + course.getName());
    }

    public List<Student> getStudents(){
        return this.students;
    }

    public List<Course> getCourses(){
        return this.courses;
    }
}
