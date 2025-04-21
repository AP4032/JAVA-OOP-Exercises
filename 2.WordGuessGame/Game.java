import java.util.random.RandomGenerator;

public class Game {

    private String[] words = {"Nima","Mahbod","Erfan","Farhad"};
    private String chosenWord;
    private char[] guessedWord;
    private int attempts;

    public Game() {
        this.chosenWord = words[RandomGenerator.getDefault().nextInt(words.length)];
        this.guessedWord = new char[chosenWord.length()];
        for (int i=0; i<guessedWord.length; i++) {
            guessedWord[i] = '_';
        }
        this.attempts = 3;
    }

    public void play() {

        while (!GameResult.isGameOver(guessedWord,attempts)) {
            Print.printGuessWord(guessedWord);
            Print.printText("Enter a letter: ");
            boolean isCorrect = false;
            char guess = Input.scanner.next().charAt(0);
            for (int i=0; i<guessedWord.length; i++) {
                if (chosenWord.charAt(i) == guess) {
                    guessedWord[i] = guess;
                    isCorrect = true;
                }
            }

            if (isCorrect)
                Print.printTitle("Correct Guess");
            else {
                attempts--;
                Print.printTitle("UnCorrect Guess, You Have " + attempts + " Chance Left");
            }
        }

        if (GameResult.isGameOver(guessedWord,attempts) && attempts != 0) {
            Print.printGuessWord(guessedWord);
            Print.printGameResult("Won");
        }

        else {
            Print.printGuessWord(chosenWord.toCharArray());
            Print.printGameResult("Lost");
        }


    }

}
