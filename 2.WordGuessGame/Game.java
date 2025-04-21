// Game.java
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private String secretWord;
    private String guessedWord;
    private Player player;
    private int attempts;
    private List<String> wordList;

    public Game(Player player, List<String> wordList) {
        this.player = player;
        this.wordList = wordList;
        this.secretWord = chooseRandomWord();
        this.guessedWord = generateHiddenWord();
        this.attempts = 6;
    }

    private String chooseRandomWord() {
        Random random = new Random();
        int index = random.nextInt(wordList.size());
        return wordList.get(index);
    }

    private String generateHiddenWord() {
        StringBuilder hiddenWord = new StringBuilder();
        for (int i = 0; i < secretWord.length(); i++) {
            hiddenWord.append("_");
        }
        return hiddenWord.toString();
    }

    public void play(Scanner scanner) {
        while (attempts > 0 && !guessedWord.equals(secretWord)) {
            System.out.println("\nWord: " + guessedWord);
            System.out.println("Attempts left: " + attempts);
            System.out.print("Guess a letter: ");
            String guess = scanner.nextLine();

            if (guess.length() != 1) {
                System.out.println("Please enter a single letter.");
                continue;
            }

            char guessedChar = guess.charAt(0);
            if (secretWord.contains(String.valueOf(guessedChar))) {
                updateGuessedWord(guessedChar);
            } else {
                attempts--;
                System.out.println("Incorrect guess.");
            }
        }

        if (guessedWord.equals(secretWord)) {
            System.out.println("\nCongratulations, " + player.getName() + "! You guessed the word: " + secretWord);
            player.incrementScore();
        } else {
            System.out.println("\nYou ran out of attempts. The word was: " + secretWord);
        }
    }

    private void updateGuessedWord(char guessedChar) {
        StringBuilder newGuessedWord = new StringBuilder(guessedWord);
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == guessedChar) {
                newGuessedWord.setCharAt(i, guessedChar);
            }
        }
        guessedWord = newGuessedWord.toString();
    }
}
