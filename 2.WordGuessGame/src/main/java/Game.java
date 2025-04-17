import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private String[] words = {"java", "python", "programming", "developer", "object"};
    private String chosenWord;
    private char[] guessedWord;
    private int attempts;
    private ArrayList<Character> guessedLetters; 
    private Player player;

    public Game(Player player) {
        this.player = player;
        Random random = new Random();
        this.chosenWord = words[random.nextInt(words.length)];
        this.guessedWord = new char[chosenWord.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }
        this.attempts = chosenWord.length() + 3;
        this.guessedLetters = new ArrayList<>();
    }

    public boolean play(Scanner scanner) {
        while (attempts > 0) {
            System.out.println("\nWord: " + String.valueOf(guessedWord));
            System.out.println("Guessed letters: " + guessedLetters);
            System.out.println("Attempts left: " + attempts);
            char guess = getValidGuess(scanner);

            if (guessedLetters.contains(guess)) {
                System.out.println("You already guessed '" + guess + "'!");
                continue;
            }
            guessedLetters.add(guess);

            boolean correct = false;
            for (int i = 0; i < chosenWord.length(); i++) {
                if (chosenWord.charAt(i) == guess) {
                    guessedWord[i] = guess;
                    correct = true;
                }
            }

            if (correct) {
                player.addScore(10); 
                System.out.println("Correct guess!");
            } else {
                attempts--;
                System.out.println("Incorrect guess!");
            }

            if (String.valueOf(guessedWord).equals(chosenWord)) {
                player.addScore(50); 
                System.out.println("Congratulations, " + player.getName() + "! You guessed the word: " + chosenWord);
                System.out.println("Your score: " + player.getScore());
                return true; 
            }
        }
        System.out.println("Game Over! The word was: " + chosenWord);
        System.out.println("Your score: " + player.getScore());
        return false; 
    }

    private char getValidGuess(Scanner scanner) {
        while (true) {
            System.out.print("Enter a letter: ");
            String input = scanner.next().toLowerCase();
            if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                return input.charAt(0);
            }
            System.out.println("Please enter a single letter!");
            scanner.nextLine(); 
        }
    }
}