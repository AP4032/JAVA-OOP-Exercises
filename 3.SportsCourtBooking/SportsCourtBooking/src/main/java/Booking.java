import java.time.LocalDateTime;

public class Booking {
    private Player player;
    private Court court;
    private LocalDateTime start;
    private LocalDateTime end;

    public Booking(Player player, Court court, LocalDateTime start, LocalDateTime end) {
        this.player = player;
        this.court = court;
        this.start = start;
        this.end = end;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public Player getPlayer() {
        return player;
    }

    public Court getCourt() {
        return court;
    }
}
