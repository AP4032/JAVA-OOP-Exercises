import java.util.ArrayList;
import java.util.List;

public class Admin {

    private List<Court> courts;

    public Admin() {
        this.courts = new ArrayList<>();
    }
    public void addCourt(Court court) {
        courts.add(court);
        System.out.println("Added " + court.getSportType() + " court (ID: " + court.getCourtId() + ")");
    }

    public boolean removeCourtById(int courtId) {
        for (Court court : courts) {
            if (court.getCourtId() == courtId) {
                courts.remove(court);
                System.out.println("✔ Removed court with ID: " + courtId);
                return true;
            }
        }
        System.out.println(" No court found with ID: " + courtId);
        return false;
    }


    public List<Court> findAvailableCourts(String sportType, java.time.LocalDateTime start, java.time.LocalDateTime end) {
        List<Court> availableCourts = new ArrayList<>();
        for (Court court : courts) {
            if (court.getSportType().equalsIgnoreCase(sportType) && court.isAvailable(start, end)) {
                availableCourts.add(court);
            }
        }
        return availableCourts;
    }

    public List<Court> getAllCourts() {
        return courts;
    }
}
