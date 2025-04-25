package WordGuessSystem;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private String[] words = {"java", "python", "programming", "developer", "object"};
    private String chosenWord;
    private char[] guessedWord;
    private int attempts;
    private int score;

    public Game() {
        Random random = new Random();
        this.chosenWord = words[random.nextInt(words.length)];
        this.guessedWord = new char[chosenWord.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }
        this.attempts = chosenWord.length() + 3;
        this.score = 0;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (attempts > 0) {
            System.out.println("Word: " + String.valueOf(guessedWord));
            System.out.print("Enter a letter: ");
            char guess = scanner.next().charAt(0);
            boolean correct = false;

            for (int i = 0; i < chosenWord.length(); i++) {
                if (chosenWord.charAt(i) == guess && guessedWord[i] != guess) {
                    guessedWord[i] = guess;
                    correct = true;
                    score += 10; // امتیاز برای هر حرف درست
                }
            }

            if (!correct) {
                attempts--;
                score -= 5; // کم شدن امتیاز برای حدس اشتباه
                System.out.println("Incorrect guess! Attempts left: " + attempts);
            }

            if (String.valueOf(guessedWord).equals(chosenWord)) {
                System.out.println("Congratulations! You guessed the word: " + chosenWord);
                System.out.println("Your score: " + score);
                return;
            }
        }
        System.out.println("Game Over! The word was: " + chosenWord);
        System.out.println("Your score: " + score);
    }
}
