import java.util.ArrayList;
import java.util.List;

public class Admin {

    private List<Course> courses;

    public Admin() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
        Print.printTitle("Removed " + course.getSportType() + " course");
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void showCourseList() {

        for (int i=0; i<courses.size(); i++) {
            Print.printGreenText("" + (i + 1));
            Print.printGreenText("- " + courses.get(i).getSportType() + " (20$)\n");
        }
    }
}
