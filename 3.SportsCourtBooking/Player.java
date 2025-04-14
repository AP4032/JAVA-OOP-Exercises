public class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void bookCourt(String courtName) {
        if (Admin.courts.get(courtName).canBookCourt()) {
            System.out.println("Court " + courtName + " was successfully booked.");
        }else System.out.println("Court " + courtName + " is already booked!");

    }
}
