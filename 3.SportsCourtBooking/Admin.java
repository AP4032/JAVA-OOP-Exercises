import java.util.ArrayList;
import java.util.List;
public class Admin {
    private List<Court> courts;
    private List<Player> players;

    public Admin(){
        this.courts = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    public void addCourt(Court court){
        courts.add(court);
        System.out.println("Added " + court.getSportType() + " court.");
    }

    public void addPlayer(Player player){
        players.add(player);
        System.out.println("Added " + player.getName() + " to players.");
    }

    public void removeCourt(Court court){
        courts.remove(court);
        System.out.println("Removed " + court.getSportType() + " court.");
    }

    public List<Court> getCourts() {
        return courts;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
