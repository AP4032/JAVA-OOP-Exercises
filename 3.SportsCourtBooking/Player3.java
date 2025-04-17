public class Player3 {
    private String name;
    private static int id = 0;
    private int playerID;

    public Player3(String name) {
        this.name = name;
        this.playerID = id++;
    }

    public boolean bookCourt(Court court) {
        if (court.bookCourt()) {
            System.out.println(name + " successfully booked a " + court.getSportType() + " court.");
            return true;
        }
        System.out.println("Court is already booked!");
        return false;
    }

    public String getName() {
        return name;
    }

    public int getPlayerID() {
        return playerID;
    }
}
