import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Court> courts;
    private List<Player> players;

    public Admin() {
        courts = new ArrayList<>();
        players = new ArrayList<>();
    }

    public void addCourt(Court court) {
        courts.add(court);
        System.out.println(court.getCourtName() + " has been added.");
    }

    public void removeCourt(Court court) {
        courts.remove(court);
        System.out.println(court.getCourtName() + " has been removed.");
    }

    public void addPlayer(Player player) {
        players.add(player);
        System.out.println("Player " + player.getName() + " added.");
    }

    public void removePlayer(Player player) {
        players.remove(player);
        System.out.println("Player " + player.getName() + " removed.");
    }

    public List<Court> getCourts() {
        return courts;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void showingCourtSchedule(Court court) {
        List<Booking> courtBookings = court.getBookings();
        if (courtBookings.isEmpty()) {
            System.out.println("No bookings for " + court.getCourtName());
        } else {
            for (Booking booking : courtBookings) {
                System.out.println("Date: " + booking.getDate() + " Time: " + booking.getTime() + " - Player: " + booking.getPlayer().getName());
            }
        }
    }

}
