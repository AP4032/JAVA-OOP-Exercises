import java.time.LocalDateTime;

public class Player {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    public boolean bookCourt(Court court, LocalDateTime start, LocalDateTime end) {
        return court.bookCourt(this, start, end);
    }

    public String getName() {
        return name;
    }
}
