public class Player {
    private String name;
    public int score = 0;
    public int attempts = 0;

    public Player(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}