package MyJava3;


public class Booking {
    private final Player player;
    private Schedule schedule;
    private final double amount;

    public Booking(Player player, Schedule Schedule, double hourlyRate) {
        this.player = player;
        this.schedule = Schedule;
        this.amount = hourlyRate;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public double getAmount() {
        return amount;
    }

    public String toString() {
        return player.getName() + " reserved from " + schedule + " ($" + amount + ")";
    }
}
