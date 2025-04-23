public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public boolean bookCourt(Court court, String dateTime) {
        if (court.bookCourt(dateTime, this)) {
            System.out.println(name + " successfully booked a " + court.getSportType() + " court at " + dateTime);
            return true;
        }
        System.out.println("Court is already booked!");
        return false;
    }

    public String getName() {
        return name;
    }
}