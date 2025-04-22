package MyJava2;


public class Player {
    private final String name;
    private int score;

    public Player(String name) {
        this.name = name.trim();
        this.score = 0;
    }

    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }
    public void addScore(int points) {
        score += points;
    }
}
