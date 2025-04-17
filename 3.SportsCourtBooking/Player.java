import java.util.Map;

public class Player {
    private String name;
    private int playerId;
    private static int idCounter = 1;

    public Player(String name) {
        this.name = name;
        this.playerId = idCounter++;

    }

    public String getName() {
        return name;
    }

    public int getId(){
        return playerId;
    }


    public boolean bookCourt(Court court) {
        if (court.bookCourt()) {
            System.out.println(name + " successfully booked a " + court.getSportType() + " court.");
            return true;
        }
        System.out.println("Court is already booked!");
        return false;
    }

}