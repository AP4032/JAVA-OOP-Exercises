import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    ArrayList<String> words = WordFetcher.wordFetcher("C:\\Users\\r\\Desktop\\java\\Git projects\\javaExercises\\JAVA-OOP-Exercises\\2.WordGuessGame\\text.txt");
    Random rand = new Random();
    String chosenWord;
    private final char[] guessedWord;
    private byte attempts;
    private byte hintAttempts = 1;

    public Game() throws IOException {
        chosenWord = words.get(rand.nextInt(words.size()));
        guessedWord = new char[chosenWord.length()];
        for (int i = 0; i < chosenWord.length(); i++) {
            guessedWord[i] = '_';
        }
        attempts = (byte) (chosenWord.length() + 3);
    }

    public void hint(String chosenWord) {
        System.out.println("Hint : one of the letters is " + chosenWord.charAt(rand.nextInt(chosenWord.length())));
    }

    public void singlePlay(Player player) {
        Scanner wordScanner = new Scanner(System.in);
        while (attempts > 0) {
            System.out.println("attempts = " + attempts + "\t,\t word length = " + chosenWord.length());
            System.out.println("word: " + String.valueOf(guessedWord));
            if (hintAttempts > 0) {
                System.out.println("do you want to use a hint ?\n1.Yes\n2.No");
                byte answer = wordScanner.nextByte();
                if (answer == 1) {
                    hint(chosenWord);
                    hintAttempts--;
                }
            }
            System.out.println(player.getName() + ", enter a letter to guess: ");
            char guess = wordScanner.next().charAt(0);
            boolean found = false;

            if (new String(guessedWord).contains(String.valueOf(guess))) {
                System.out.println("You've already guessed this letter!");
                continue;
            }

            for (int i = 0; i < chosenWord.length(); i++) {
                if (chosenWord.charAt(i) == guess) {
                    found = true;
                    guessedWord[i] = guess;
                }
            }
            if (!found) {
                System.out.println("wrong guess!");
                attempts--;
            }
            if (String.valueOf(guessedWord).contentEquals(chosenWord)) {
                System.out.println("Congratulations," + player.getName() + "! You guessed the word " + chosenWord);
                break;
            } else if (attempts == 0) {
                System.out.println("you didnt guess the word! it was " + chosenWord);
                break;
            }
        }
        System.out.println("game over!");
    }

    public void multiPlay(ArrayList<Player> players) {
        Scanner wordScanner = new Scanner(System.in);
        closeThis:
        while (attempts > 0) {
            for (Player player : players) {
                System.out.println("attempts = " + attempts + "\t,\t word length = " + chosenWord.length());
                System.out.println("word: " + String.valueOf(guessedWord));
                System.out.println(player.getName() + ", enter a letter to guess: ");
                char guess = wordScanner.next().charAt(0);
                boolean found = false;

                if (new String(guessedWord).contains(String.valueOf(guess))) {
                    System.out.println("You've already guessed this letter!");
                    continue;
                }

                for (int i = 0; i < chosenWord.length(); i++) {
                    if (chosenWord.charAt(i) == guess) {
                        found = true;
                        guessedWord[i] = guess;
                    }
                }
                if (!found) {
                    System.out.println(player.getName() + ", you guessed wrong!");
                    attempts--;
                }else System.out.println(player.getName() + ", you guessed right!");


                if (String.valueOf(guessedWord).contentEquals(chosenWord)) {
                    System.out.println(player.getName() + ", Congratulations! You guessed the word " + chosenWord);
                    break closeThis;
                } else if (attempts == 0) {
                    System.out.println("you didnt guess the word! it was " + chosenWord);
                    break closeThis;
                }
            }
        }
        System.out.println("game over!");
    }
}
