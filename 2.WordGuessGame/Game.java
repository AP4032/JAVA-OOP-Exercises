import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private String[] words;
    private String chosenWord;
    private char[] guessedWord;
    private int attempts;

    public Game() {
        words = TextFileWordLoader.loadWordsFromTextFile("words.txt");
        Random random = new Random();
        this.chosenWord = words[random.nextInt(words.length)];
        this.guessedWord = new char[chosenWord.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }
        this.attempts = chosenWord.length() + 3;
    }

    public boolean play() {
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
                return true;
            }
        }
        System.out.println("Game Over! The word was: " + chosenWord);
        return false;
    }
    public void scoreBoard2(Player player1 , Player player2) {
        System.out.println( player1.getName()+" Score :" + player1.score );

    }
    public static void addWordToFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to add to the file: ");
        String word = scanner.nextLine().trim().toLowerCase();

        try (FileWriter writer = new FileWriter("words.txt", true)) {
            writer.write(word + "\n");
            System.out.println("Word added successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }
}