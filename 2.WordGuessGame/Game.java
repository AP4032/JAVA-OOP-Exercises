import java.util.Random;
public class Game {
    private final String[] words = {"java", "python", "programming", "developer", "object"};
    private String chosenWord;
    private char[] guessedWord;
    private int attempts;

    public void startNewGame() {
        Random random = new Random();
        this.chosenWord = words[random.nextInt(words.length)];
        this.guessedWord = new char[chosenWord.length()];
        for (int i = 0; i < guessedWord.lengthd; i++) {
            guessedWord[i] = '_';
        }
        this.attempts = 6;
        System.out.println("\nNew game started!");
        displayWord();
    }

    public boolean isGameOver() {
        return attempts == 0 || isWordGuessed();
    }

    public boolean isWordGuessed() {
        return chosenWord.equals(new String(guessedWord));
    }

    public void processGuess(char guess) {
        boolean correct = false;
        for (int i = 0; i < chosenWord.length(); i++) {
            if (chosenWord.charAt(i) == guess && guessedWord[i] == '_') {
                guessedWord[i] = guess;
                correct = true;
            }
        }
        if (!correct) {
            attempts--;
            System.out.println("Wrong guess! Remaining attempts: " + attempts);
        } else {
            System.out.println("Correct guess!");
        }
    }

    public void displayWord() {
        for (char c : guessedWord) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public String getChosenWord() {
        return chosenWord;
    }
}