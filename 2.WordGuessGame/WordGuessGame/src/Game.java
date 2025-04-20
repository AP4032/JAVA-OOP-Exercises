import java.util.Random;
import java.util.Scanner;

public class Game {
    private String[] words = {"java", "python", "programming", "developer", "object"};
    private String chosenWord;
    private char[] guessedWord;
    private int attempts;

    public Game() {
        Random random = new Random();
        this.chosenWord = words[random.nextInt(words.length)];
        this.guessedWord = new char[chosenWord.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }
        this.attempts = chosenWord.length() + 3;
    }

    public void play(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello " + player.getName() + "! Let's start the game 🎮");

        while (attempts > 0) {
            System.out.println("\nWord: " + String.valueOf(guessedWord));
            System.out.print("Guess a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);
            boolean correct = false;

            for (int i = 0; i < chosenWord.length(); i++) {
                if (chosenWord.charAt(i) == guess && guessedWord[i] == '_') {
                    guessedWord[i] = guess;
                    correct = true;
                }
            }

            if (!correct) {
                attempts--;
                System.out.println("Wrong guess ❌ Attempts left: " + attempts);
            } else {
                System.out.println("Good job ✅");
            }

            if (String.valueOf(guessedWord).equals(chosenWord)) {
                System.out.println("\n🎉 Congratulations " + player.getName() + "! You guessed the word: " + chosenWord);
                return;
            }
        }

        System.out.println("\n😢 Game Over! The word was: " + chosenWord);
    }
}
