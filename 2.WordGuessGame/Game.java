import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

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

    public void play(ArrayList<Player> players){
        Scanner scanner = new Scanner(System.in);
        for(Player player : players){
            player.attempts = this.attempts;
        }
        boolean isCorrect = true;
        boolean isGuessed = false;
        while (isCorrect) {
            isCorrect = false;
            for(Player player : players) {
                if (player.attempts > 0) {
                    isCorrect = true;
                    System.out.println(player.getName() + " turn:");
                    System.out.println("Word: " + String.valueOf(guessedWord));
                    System.out.print("Enter a letter: ");
                    char guess = scanner.next().charAt(0);
                    boolean correct = false;

                    for (int i = 0; i < chosenWord.length(); i++) {
                        if (chosenWord.charAt(i) == guess) {
                            guessedWord[i] = guess;
                            correct = true;
                            player.score += 1;
                        }
                    }

                    if (!correct) {
                        player.attempts--;
                        if(attempts == 0){
                            System.out.println("you lost!");
                        }
                        else {
                            System.out.println("Incorrect guess! Attempts left: " + player.attempts);
                        }
                    }

                    if (String.valueOf(guessedWord).equals(chosenWord)) {
                        System.out.println("Congratulations! You guessed the word: " + chosenWord);
                        player.score += 4;
                        isCorrect = false;
                        isGuessed = true;
                        break;
                    }
                }
            }
        }
        for(Player player : players){
            player.score += player.attempts;
        }
        if(!isGuessed) {
            System.out.println("Game Over! The word was: " + chosenWord);
        }
    }
}