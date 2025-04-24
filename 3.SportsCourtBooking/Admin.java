import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<SportCourt> courts;
    private List<Player> players;

    public Admin() {
        this.courts = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    public void addCourt(SportCourt court) {
        courts.add(court);
        System.out.println("Added " + court.getSportType() + " court.");
    }

    public List<SportCourt> getCourts() {
        return courts;
    }
    public void changeCost(String sportType, int cost) {
        for (SportCourt court : courts) {
            if (court.getSportType().equals(sportType)) {
                court.setCost(cost);
                System.out.println("Changed cost of " + court.getSportType() + " successfully.");
            }
        }

    }

    public List<Player> getPlayers() {
        return players;
    }
    public void addPlayer(Player player) {
        players.add(player);
    }
}