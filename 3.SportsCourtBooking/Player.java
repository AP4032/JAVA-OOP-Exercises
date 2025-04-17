public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void bookCourt(Court court, String date, String time) {
        if (court.bookCourt(this, date, time)) {
            System.out.println(name + " booked " + court.getCourtName() + " on " + date + " at " + time);
        } else {
            System.out.println("Booking failed.");
        }
    }
}
