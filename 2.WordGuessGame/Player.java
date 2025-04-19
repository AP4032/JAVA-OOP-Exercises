public class Player {
    private final String name;
    private int score;
    private int attempts;
    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
}
