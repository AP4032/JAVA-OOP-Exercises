public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public boolean bookCourt(Court court) {
        if (court.bookCourt()) {
            System.out.println(name + " successfully booked the " + court.getSportType() + " court.");
            return true;
        } else {
            System.out.println(name + ", the " + court.getSportType() + " court is already booked!");
            return false;
        }
    }

    public String getName() {
        return name;
    }
}
