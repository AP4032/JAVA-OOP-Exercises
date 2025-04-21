import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class Game {
    private String chosenWord;
    private char[] guessedWord;
    private int attempts;
    private Set<Character> guessedLetters;
    private WordBank wordBank;
    private DifficultyLevel difficulty;
    private Player currentPlayer;

    public Game(Player player, DifficultyLevel difficulty) {
        this.currentPlayer = player;
        this.difficulty = difficulty;
        this.wordBank = new WordBank(difficulty);
        this.chosenWord = wordBank.getRandomWord();
        this.guessedWord = new char[chosenWord.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }
        this.attempts = calculateInitialAttempts();
        this.guessedLetters = new HashSet<>();
    }

    private int calculateInitialAttempts() {
        return (int) (chosenWord.length() * (1.5 + difficulty.getMultiplier() * 0.5));
    }

    public void play(ScoreSystem scoreSystem) {
        Scanner scanner = new Scanner(System.in);
        currentPlayer.incrementGamesPlayed();

        System.out.println("\nWelcome, " + currentPlayer.getName() + "!");
        System.out.println("Difficulty: " + difficulty);
        System.out.println("Word length: " + chosenWord.length());
        System.out.println("Attempts left: " + attempts);

        while (attempts > 0) {
            displayGameStatus();

            System.out.print("Enter a letter or guess the whole word: ");
            String input = scanner.next().toLowerCase();

            if (input.length() > 1) {
                handleWholeWordGuess(input, scoreSystem);
                return;
            } else {
                handleLetterGuess(input.charAt(0), scoreSystem);
            }

            if (isWordGuessed()) {
                handleWin(scoreSystem);
                return;
            }
        }

        handleLoss();
    }

    private void displayGameStatus() {
        System.out.println("\nWord: " + String.valueOf(guessedWord));
        System.out.println("Attempts left: " + attempts);
        System.out.println("Guessed letters: " + guessedLetters);
    }

    private void handleWholeWordGuess(String guess, ScoreSystem scoreSystem) {
        if (guess.equals(chosenWord)) {
            Arrays.fill(guessedWord, guessedWord[0]);
            System.out.println("\nWord: " + String.valueOf(guessedWord));
            System.out.println("Congratulations! You guessed the word!");
            handleWin(scoreSystem);
        } else {
            attempts--;
            System.out.println("Wrong guess! Attempts left: " + attempts);
        }
    }

    private void handleLetterGuess(char guess, ScoreSystem scoreSystem) {
        if (!Character.isLetter(guess)) {
            System.out.println("Please enter a valid letter.");
            return;
        }

        if (guessedLetters.contains(guess)) {
            System.out.println("You already guessed this letter!");
            return;
        }

        guessedLetters.add(guess);
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
    }

    private boolean isWordGuessed() {
        return String.valueOf(guessedWord).equals(chosenWord);
    }

    private void handleWin(ScoreSystem scoreSystem) {
        int pointsEarned = chosenWord.length() * difficulty.getMultiplier() * attempts;
        currentPlayer.addScore(pointsEarned);
        currentPlayer.incrementGamesWon();
        scoreSystem.updateScore(currentPlayer.getName(), pointsEarned);

        System.out.println("Congratulations, " + currentPlayer.getName() + "!");
        System.out.println("You earned " + pointsEarned + " points!");
        System.out.println("Your total score: " + currentPlayer.getScore());
    }

    private void handleLoss() {
        System.out.println("\nGame Over! The word was: " + chosenWord);
        System.out.println("Better luck next time, " + currentPlayer.getName() + "!");
    }
}