package MyJava3;


public class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public void reserveCourt(Court court, Schedule slot) {
        Booking booking = new Booking(this, slot, court.getHourlyRate());
        if (court.addBooking(booking)) {
            System.out.println(name + " successfully booked " + court.getName() + " for " + slot);
            System.out.println("Payment of $" + booking.getAmount() + " received.");
        } else {
            System.out.println("Booking failed for " + name + ": time slot unavailable.");
        }
    }

    public String getName() {
        return name;
    }
}