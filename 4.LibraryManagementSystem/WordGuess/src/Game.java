import java.util.Random;
import java.util.Scanner;

public class Game {
    private String[] words = {"java", "python", "programming", "developer", "object"};
    private String chosenWord;
    private char[] guessedWord;
    private int attempts;
    private Scanner scanner = new Scanner(System.in);

    public Game() {
        chosenWord = words[new Random().nextInt(words.length)];
        guessedWord = new char[chosenWord.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }
        attempts = chosenWord.length() + 3;
    }

    public void play() {
        while (attempts > 0) {
            System.out.println("\nWord: " + String.valueOf(guessedWord));
            System.out.print("Enter a letter: ");
            char guess = Character.toLowerCase(scanner.next().charAt(0));

            if (!updateGuessedWord(guess)) {
                attempts--;
                System.out.println("Wrong guess! Attempts left: " + attempts);
            }

            if (String.valueOf(guessedWord).equals(chosenWord)) {
                System.out.println("🎉 Congratulations! You guessed the word: " + chosenWord);
                return;
            }
        }
        System.out.println("😢 Game Over! The word was: " + chosenWord);
    }

    private boolean updateGuessedWord(char guess) {
        boolean correct = false;
        for (int i = 0; i < chosenWord.length(); i++) {
            if (chosenWord.charAt(i) == guess) {
                guessedWord[i] = guess;
                correct = true;
            }
        }
        return correct;
    }
}