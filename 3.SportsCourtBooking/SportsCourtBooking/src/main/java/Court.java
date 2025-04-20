import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Court {

    private static int idCounter = 1;
    private int courtId;
    private String sportType;
    private List<Booking> bookings;

    public Court(String sportType) {
        this.sportType = sportType;
        this.courtId = idCounter++;
        this.bookings = new ArrayList<>();
    }


    public boolean bookCourt(Player player, LocalDateTime start, LocalDateTime end) {
        if (isAvailable(start, end)) {
            bookings.add(new Booking(player, this, start, end));
            System.out.println("✔ " + sportType + " court (ID: " + courtId + ") successfully booked by " +
                    player.getName() + " from " + start + " to " + end);
            return true;
        } else {
            System.out.println("This court is already booked during the selected time.");
            return false;
        }
    }


    public boolean isAvailable(LocalDateTime start, LocalDateTime end) {
        for (Booking booking : bookings) {
            if (booking.getStart().isBefore(end) && start.isBefore(booking.getEnd())) {
                return false;
            }
        }
        return true;
    }


    public String getSportType() {
        return sportType;
    }

    public int getCourtId() {
        return courtId;
    }

    public List<Booking> getBookings() {
        return bookings;
    }
}
