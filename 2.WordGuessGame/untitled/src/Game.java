import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private String[] wordBank = {
            "java", "python", "programming", "developer",
            "object", "oriented", "computer", "algorithm"
    };
    private String secretWord;
    private char[] guessedLetters;
    private int remainingAttempts;
    private int maxAttempts;
    private Scanner scanner;

    public Game() {
        this.scanner = new Scanner(System.in);
        initializeGame();
    }

    private void initializeGame() {
        Random random = new Random();
        this.secretWord = wordBank[random.nextInt(wordBank.length)];
        this.guessedLetters = new char[secretWord.length()];
        Arrays.fill(guessedLetters, '_');
        this.maxAttempts = secretWord.length() + 3;
        this.remainingAttempts = maxAttempts;
    }

    public void play() {
        while (remainingAttempts > 0 && !isWordGuessed()) {
            displayGameStatus();
            processGuess();
        }

        endGame();
    }

    private void displayGameStatus() {
        System.out.println("\nWord: " + String.valueOf(guessedLetters));
        System.out.println("Attempts remaining: " + remainingAttempts);
    }

    private void processGuess() {
        System.out.print("Enter a letter: ");
        char guess = scanner.next().toLowerCase().charAt(0);

        boolean correctGuess = false;
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == guess && guessedLetters[i] != guess) {
                guessedLetters[i] = guess;
                correctGuess = true;
            }
        }

        if (!correctGuess) {
            remainingAttempts--;
            System.out.println("Incorrect guess! Try again.");
        }
    }

    private boolean isWordGuessed() {
        return String.valueOf(guessedLetters).equals(secretWord);
    }

    private void endGame() {
        if (isWordGuessed()) {
            System.out.println("\nCongratulations! You guessed the word: " + secretWord);
        } else {
            System.out.println("\nGame Over! The word was: " + secretWord);
        }
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }
}
