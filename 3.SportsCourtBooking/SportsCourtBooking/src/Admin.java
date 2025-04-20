import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Court> courts;

    public Admin() {
        courts = new ArrayList<>();
    }

    public void addCourt(String sportType) {
        Court court = new Court(sportType);
        courts.add(court);
        System.out.println("Admin added a " + sportType + " court.");
    }

    public List<Court> getCourts() {
        return courts;
    }

    public void displayCourts() {
        System.out.println("Available courts:");
        for (Court court : courts) {
            System.out.println("- " + court.toString());
        }
    }
}
