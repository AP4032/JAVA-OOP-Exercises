import java.util.Random;
import java.util.Scanner;

public class Game {
    private int hint=1;
    private boolean isGetHint=false;
    private boolean gameOver=false;
    private String[] words;
    private String chosenWord;
    private char[] guessedWord;

    public void playSingle(Player player) {
        Scanner scanner = new Scanner(System.in);

        while (player.getAttempts() > 0) {
            System.out.println("**************************************");
            System.out.println("Your Score = "+player.getScore());
            System.out.println("If you want get Hint, enter 'H' .");
            System.out.println("Word: " + String.valueOf(guessedWord));
            System.out.println("Attempts left: " + player.getAttempts());
            System.out.print("Enter a letter: ");
            char guess = scanner.next().charAt(0);
            boolean correct = false;

            if (guess == 'H'){
                if (!isGetHint){
                    getHint();
                    hint--;
                    if (hint == 0){
                        isGetHint=true;
                    }
                }
                else{
                    System.out.println("**************************************");
                    System.out.println("‼️Error : You used all your hint‼️");
                }
            }
            else {
                for (int i = 0; i < chosenWord.length(); i++) {
                    if (chosenWord.charAt(i) == guess) {
                        guessedWord[i] = guess;
                        correct = true;
                    }
                }

                if (!correct) {
                    player.setAttempts(player.getAttempts() - 1);
                    System.out.println("Incorrect guess! Attempts left: " + player.getAttempts());
                }

                if (String.valueOf(guessedWord).equals(chosenWord)) {
                    System.out.println("Congratulations! You guessed the word: " + chosenWord);
                    player.setScore(player.getScore() + 1);
                    return;
                }
            }
        }
        System.out.println("Game Over! The word was: " + chosenWord);
    }
    public void multiplayerMode(Player player) {
        boolean turn=true;

        Scanner scanner = new Scanner(System.in);
        if (player.getAttempts() ==0){
            System.out.println("Game Over! The word was: " + chosenWord);
            gameOver = true;
            return;
        }
        while (turn) {
            System.out.println("**************************************");
            System.out.println(player.getName()+"'s turn: ");
            System.out.println("Your Score = "+player.getScore());
            System.out.println("If you want get Hint, enter 'H' .");
            System.out.println("Word: " + String.valueOf(guessedWord));
            System.out.println("Attempts left: " + player.getAttempts());
            System.out.print("Enter a letter: ");
            char guess = scanner.next().charAt(0);
            boolean correct = false;

            if (guess == 'H'){
                if (!isGetHint){
                    getHint();
                    hint--;
                    if (hint == 0){
                        isGetHint=true;
                    }
                }
                else{
                    System.out.println("**************************************");
                    System.out.println("‼️Error : You used all your hint‼️");
                }
            }
            else {
                for (int i = 0; i < chosenWord.length(); i++) {
                    if (chosenWord.charAt(i) == guess) {
                        guessedWord[i] = guess;
                        correct = true;
                    }
                }

                if (!correct) {
                    player.setAttempts(player.getAttempts() - 1);
                    System.out.println("Incorrect guess! Attempts left: " + player.getAttempts());
                    turn=false;
                }

                if (String.valueOf(guessedWord).equals(chosenWord)) {
                    System.out.println("Congratulations! You guessed the word: " + chosenWord);
                    player.setScore(player.getScore() + 1);
                    gameOver = true;
                    System.out.println("***************************************");
                    System.out.println("Winner is " + player.getName()+" 🎉🎉");
                    System.out.println("***************************************");
                    return;
                }
            }
        }
    }
    public void setWords(String[] words){
        this.words = words;

    }
    private void getHint(){
        for (int i = 0; i < guessedWord.length; i++) {
            if(guessedWord[i] == '_'){
                guessedWord[i] = chosenWord.charAt(i);
                break;
            }
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void chooseWord() {
        Random random = new Random();
        this.chosenWord = words[random.nextInt(words.length)];
        this.guessedWord = new char[chosenWord.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

    }

    public String getChosenWord() {
        return chosenWord;
    }
}