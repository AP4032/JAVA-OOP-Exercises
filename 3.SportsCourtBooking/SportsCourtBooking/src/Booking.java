public class Booking {
    private String dateTime;
    private Court court;
    private Player player;

    public Booking(String dateTime, Court court, Player player) {
        this.dateTime = dateTime;
        this.court = court;
        this.player = player;
    }

    public String getDateTime() {
        return dateTime;
    }

    public Court getCourt() {
        return court;
    }

    public Player getPlayer() {
        return player;
    }
}