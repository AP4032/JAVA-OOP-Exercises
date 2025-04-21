public class Course {

    private String sportType;
    private boolean isAvailable;

    public Course(String sportType) {
        this.sportType = sportType;
        isAvailable = true;
    }

    public boolean bookCourse() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }

    public void releaseCourse() {
        isAvailable = true;
    }

    public String getSportType() {
        return sportType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
