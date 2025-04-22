public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void bookCourt(Court court) {
        if (court.bookCourt()) {
            System.out.println(name + " booked a " + court.getSportType() + " court");
        }
        System.out.println("Court is already booked!");
    }
}
