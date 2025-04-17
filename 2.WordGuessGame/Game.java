import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    List<String> words = new ArrayList<>();
    private String chosenWord;
    private char[] guessedWord;
    private int attempts;

    public Game() {
        words = new ArrayList<>();
        words.add("java");
        words.add("python");
        words.add("programming");
        words.add("developer");
        words.add("object");

        Random random = new Random();
        this.chosenWord = words.get(random.nextInt(words.size()));
        this.guessedWord = new char[chosenWord.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }
        this.attempts = chosenWord.length() + 3;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (attempts > 0) {
            System.out.println("Word: " + String.valueOf(guessedWord));
            System.out.print("Enter a letter: ");
            char guess = scanner.next().charAt(0);
            boolean correct = false;

            for (int i = 0; i < chosenWord.length(); i++) {
                if (chosenWord.charAt(i) == guess) {
                    guessedWord[i] = guess;
                    correct = true;
                }
            }

            if (!correct) {
                attempts--;
                System.out.println("Incorrect guess! Attempts left: " + attempts);
            }

            if (String.valueOf(guessedWord).equals(chosenWord)) {
                System.out.println("Congratulations! You guessed the word: " + chosenWord);
                for (int i = 0; i < guessedWord.length; i++) {
                    guessedWord[i] = '_';
                }
                return;
            }
        }
        System.out.println("Game Over! The word was: " + chosenWord);
    }

    public void addWord(String word) {
        words.add(word);
        System.out.println("Added word: " + word);
    }
}
