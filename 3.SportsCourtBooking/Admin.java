import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Admin {
    private List<Court> courts;
    private List<Player> players;
    private Map<String, String> bookingList;

    public Admin() {
        this.courts = new ArrayList<>();
        this.players = new ArrayList<>();
        this.bookingList = new HashMap<>();
    }

    public void getBookingList() {
        for (String s : bookingList.keySet()) {
            System.out.println(s + " -> " + bookingList.get(s));
        }
    }

    public void addToBookingList(String court, String player) {
        bookingList.put(court, player);
    }

    public void removeFromBookingList(String court, String player) {
        bookingList.remove(court, player);
    }

    public void addCourt(Court court) {
        courts.add(court);
        System.out.println("Added " + court.getSportType() + " court.");
    }

    public void removeCourt(Court court) {
        courts.remove(court);
        System.out.println("Removed " + court.getSportType() + " court.");
    }


    public void addPlayer(Player player) {
        players.add(player);
        System.out.println("Added player: " + player.getName());
    }

    public void removePlayer(Player player) {
        players.remove(player);
        System.out.println("Removed player: " + player.getName());
    }


    public List<Court> getCourts() {
        return courts;
    }

    public List<Player> getPlayers() {
        return players;
    }
}