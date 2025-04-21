public class GameResult {

    public static boolean isGameOver(char[] guessWors, int attempts) {
        for (int i=0; i<guessWors.length; i++) {
            if (guessWors[i] == '_' && attempts != 0)
                return false;
        }
        return true;
    }
}
