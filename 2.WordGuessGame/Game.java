
package org.example;

import java.util.Random;
import java.util.Scanner;

public class Game {
    Scanner input = new Scanner(System.in);
    private String[] words = {"BARCELONA", "MILAN", "SPURS", "PSV", "CELTIC"};
    private String chosenWord;
    private int chosenGuess;
    private int guessCount;
    private boolean[] revealedLetters;

    public Game() {
        Random rand = new Random();
        this.chosenGuess = rand.nextInt(words.length);
        this.chosenWord = words[chosenGuess];
        this.guessCount = chosenWord.length() + 3;
        this.revealedLetters = new boolean[chosenWord.length()];
    }

    public void Play() {
        System.out.println("Please enter a letter : ");
        System.out.println("Attempts to guess the word : " + guessCount);
        int remainingLetters = chosenWord.length();

        do {
            char guessedLetter = input.next().toUpperCase().charAt(0);
            boolean found = false;
            boolean alreadyRevealed = false;

            for (int i = 0; i < chosenWord.length(); i++) {
                if (guessedLetter == chosenWord.charAt(i)) {
                    if (!revealedLetters[i]) {
                        revealedLetters[i] = true;
                        remainingLetters--;
                        found = true;
                    } else {
                        alreadyRevealed = true;
                    }
                }
            }

            if (!found && !alreadyRevealed) {
                guessCount--;
                System.out.println("Incorrect letter. Remaining guesses: " + guessCount);
            } else if (found) {
                System.out.println("Correct letter! Remaining guesses: " + guessCount);
            } else {
                System.out.println("You already guessed this letter.");
            }

        } while (guessCount > 0 && remainingLetters > 0);

        if (guessCount == 0) {
            System.out.println("You couldn't guess the word : " + chosenWord);
            System.out.println("1- PLAY 2- EXIT 3- SET MANUALLY");
            int choice = Main.validInpute(input, 3, 1);
            input.nextLine();

            if (choice == 1) {
                Game newGame = new Game();
                newGame.Play();
            } else if (choice == 2) {
                System.out.println("Thank you for playing!");
                System.exit(0);
            } else if (choice == 3) {
                System.out.println("Enter a word for the game: ");
                String word = input.nextLine().toUpperCase();
                setChosenWord(word);
                Play();
            }

        } else if (remainingLetters == 0) {
            System.out.println("You have guessed the word : " + chosenWord);
            System.exit(0);
        }
    }

    public void setChosenWord(String chosenWord) {
        this.chosenWord = chosenWord;
        this.guessCount = chosenWord.length() + 3;
        this.revealedLetters = new boolean[chosenWord.length()];
    }
}
