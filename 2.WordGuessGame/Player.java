public class Player {
    private String name;
    int score = 0;
    public Player(String name) {
        this.name = name;

    }
    public void upGrade_score(){
        this.score++;
    }
    public int getScore() {
        return this.score;
    }
    public String getName() {
        return name;
    }
}