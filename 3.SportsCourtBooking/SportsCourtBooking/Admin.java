import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Court> courts;

    public Admin() {
        this.courts = new ArrayList<>();
      courts.add( new Court("Football (Artificial Grass)"));
        courts.add( new Court("Football (Natural Grass)"));
        courts.add( new Court("Futsal"));
        courts.add( new Court("Beach Volleyball"));
        courts.add( new Court("Indoor Volleyball"));
        courts.add( new Court("Basketball"));

    }
    public void showCourts() {
        System.out.println("List of available courts:");
for(int i= 0 ; i<courts.size();i++){
    Court court = courts.get(i);
    System.out.println((i+1)+"." + court.getSportType());
}


    }

    public void addCourt(Court court) {
        courts.add(court);
        System.out.println("Added " + court.getSportType() + " court.");

    }

    public List<Court> getCourts() {
        return courts;
    }
    public Court findCourt(String sportType) {
        for (Court court : courts) {
            if (court.getSportType().equalsIgnoreCase(sportType)) {
                return court;
            }
        }
        return null;
    }
}

