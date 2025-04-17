import java.util.ArrayList;
import java.util.List;

public class Admin3 {
    private List<Court> courts;
    private List<Player3> players;

    public Admin3() {
        this.courts = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    public void addCourt(Court court) {
        courts.add(court);
        System.out.println("Added " + court.getSportType() + " court.");
    }

    public void addPlayer(Player3 player) {
        players.add(player);
        System.out.println("Added Player: " + player.getName());
    }

    public List<Court> getCourts() {
        return courts;
    }

    public List<Player3> getPlayers() {
        return players;
    }
}