public class Player {
    private String name;
    private int score;
    private int gamesPlayed;
    private int gamesWon;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.gamesPlayed = 0;
        this.gamesWon = 0;
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

    public void incrementGamesPlayed() {
        gamesPlayed++;
    }

    public void incrementGamesWon() {
        gamesWon++;
    }

    public double getWinRate() {
        return gamesPlayed == 0 ? 0 : (double) gamesWon / gamesPlayed * 100;
    }

    @Override
    public String toString() {
        return String.format("%s - Score: %d | Games: %d | Wins: %d | Win Rate: %.1f%%",
                name, score, gamesPlayed, gamesWon, getWinRate());
    }
}