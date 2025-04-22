import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Admin {
    private List<Court> courts;


    public Admin() {
        this.courts = new ArrayList<>();
    }

    public void addCourt(Court court) {
        courts.add(court);
        System.out.println("Added " + court.getSportType() + " court.");
    }

    public List<Court> getCourts() {
        return courts;
    }
    public void printCourts() {
        for (Court court : courts) {
            System.out.println(court.getSportType());
        }
    }
}