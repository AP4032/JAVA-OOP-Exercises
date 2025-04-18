public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public boolean bookCourt(Court court,int duration) {
        if (court.bookCourt(duration)) {
            System.out.println(name + " successfully booked a " + court.getSportType() + " court.");
            return true;
        }

        return false;
    }
    public void extendBooking(Court court, int extraHours) {
        court.extendBooking(extraHours);
}
}
