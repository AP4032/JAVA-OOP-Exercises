package org.example;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private String[] words = {"java", "python", "programming", "developer", "object"};
    private String chosenWord;
    private char[] guessedWord;
    private int attempts;
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

            if (correct){
                System.out.println("Correct guess!");
                if (player != null){
                    player.increase(10);
                }
            }else {
                attempts--;
                System.out.println("Incorrect Guess! Attemps left: " + attempts);
            }

            if (String.valueOf(guessedWord).equals(chosenWord)) {
                System.out.println("Congratulations! You guessed the word: " + chosenWord);
                return;
            }
        }
        System.out.println("Game Over! The word was: " + chosenWord);
    }
    public void showWordList() {
        System.out.println("Words: ");
        for (String word : words){
            System.out.println("- " + word);
        }
    }
}