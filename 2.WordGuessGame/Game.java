import java.util.Random;
import java.util.Scanner;

public class Game {
    //    private final int hint=1;
//    private boolean isgethint=false;
    private String[] words;
    private String chosenWord;
    private char[] guessedWord;
    private int attempts;

    public void play(Player player) {
        Random random = new Random();

        this.chosenWord = words[random.nextInt(words.length)];
        this.guessedWord = new char[chosenWord.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }
        this.attempts = chosenWord.length() + 3;
        Scanner scanner = new Scanner(System.in);
        while (attempts > 0) {
            System.out.println("Your Score = "+player.getScore());
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
                player.setScore(player.getScore() + 1);
                return;
            }
        }
        System.out.println("Game Over! The word was: " + chosenWord);
    }
    public void setWords(String[] words){
        this.words = words;

    }
//    private boolean askGetHint() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Stuck!? Do you need a hint?(Y/N):");
//        String answer = scanner.next().toUpperCase();
//
//
//
//    }
//    private void getHint(){
//        for (int i = 0; i < guessedWord.length; i++) {
//            if(guessedWord[i] == '_'){
//                guessedWord[i] = chosenWord.charAt(i);
//                break;
//            }
//        }
//    }

}