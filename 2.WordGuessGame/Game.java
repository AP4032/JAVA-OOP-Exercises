import java.util.Random;
import java.util.Scanner;
public class Game {
    private String[] words = {"java","object","oop","scanner","python", "programming", "developer"};
    private String chosenWord;
    private char[] guessedWord;
    private int attempts;

    public Game(){
        Random random = new Random();
        this.chosenWord = words[random.nextInt(words.length)];
        this.guessedWord = new char[chosenWord.length()];
        for (int i = 0; i < guessedWord.length ; i++) {
            guessedWord[i] = '_';
        }
        this.attempts = (int)(1.5 * chosenWord.length());
    }

    public void play(Player player){
        Scanner scanner = new Scanner(System.in);
        while (attempts > 0){
            System.out.println("Word: " + String.valueOf(guessedWord));
            System.out.print("Enter a letter: ");
            char guess = scanner.next().charAt(0);
            boolean correct = false;
            boolean validInput = true;

            for ( int j = 0 ; j < guessedWord.length ; j++ ){
                if(guessedWord[j] == guess){
                    validInput = false;
                }
            }
            if(validInput){
                for (int i = 0; i < chosenWord.length() ; i++) {
                    if( chosenWord.charAt(i) == guess){
                        guessedWord[i] = guess;
                        correct = true;
                        player.score += 3;
                    }
                }
                if (!correct) {
                    if(player.score > 0){
                        player.score--;
                    }
                    attempts--;
                    System.out.println("Incorrect guess! Attempts left: " + attempts);
                    System.out.println(player.getName() + " score:" + player.score);
                }else{
                    System.out.println("The guess was correct! \n" + player.getName() + " score:" + player.score);
                }

                if (String.valueOf(guessedWord).equals(chosenWord)) {
                    System.out.println("Congratulations! You guessed the word: " + chosenWord);
                    System.out.println(player.getName() + " score: " + player.score);
                    return;
                }
            }else{
                System.out.println("invalid input! try again.");
            }

        }
        System.out.println("Game Over! The word was: " + chosenWord);
    }

}
