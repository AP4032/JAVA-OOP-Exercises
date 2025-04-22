public class Player {
        private String name;
        private int score;
        public Player(String name) {
            this.name = name;
            this.score=0;
        }
        public String getName() {
            return name;
        }

    public int getScore() {
        return score;
    }

    public void addScore(){
            score++;
        }
        public void printScores(){
            System.out.println(score);
        }
    }

