package MyJava2;

import java.util.*;


public class Game {
    private final String[] wordBank = {"engineer", "universe", "keyboard", "programmer", "variable"};
    private String secretWord;
    private char[] display;
    private int maxGuesses;
    private int remainingTries;
    private Set<Character> guessedLetters;

//    public Game() {
//        Random rand = new Random();
////        String[] wordBank = {"engineer", "universe", "keyboard", "inheritance", "variable"};
//        secretWord = wordBank[rand.nextInt(wordBank.length)];
//        display = new char[secretWord.length()];
//        Arrays.fill(display, '_');
//        remainingTries = secretWord.length() + 2;
//        guessedLetters = new HashSet<>();
//    }

    public void start(String playerName) {
        Random rand = new Random();
        secretWord = wordBank[rand.nextInt(wordBank.length)];
        display = new char[secretWord.length()];
        Arrays.fill(display, '_');

        maxGuesses = secretWord.length() + 3;
        remainingTries = maxGuesses;
        guessedLetters = new HashSet<>();

        Scanner input = new Scanner(System.in);
        System.out.println("\n" + playerName + "'s guess is: ");
        System.out.println("You have " + remainingTries + " tries.");

        while (remainingTries > 0) {
            System.out.println("\nWord: " + String.valueOf(display));
            System.out.print("Your guess: ");
            char guess = input.next().toLowerCase().charAt(0);

            if (guessedLetters.contains(guess)) {
                System.out.println("You already tried '" + guess + "'. Try something else.");
                continue;
            }

            guessedLetters.add(guess);

            boolean found = false;
            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == guess) {
                    display[i] = guess;
                    found = true;
                }
            }

            if (found) {
                System.out.println("Nice! '" + guess + "' is in the word.");
            } else {
                remainingTries--;
                System.out.println("Oops! '" + guess + "' is not in the word. Tries left: " + remainingTries);
            }

            if (String.valueOf(display).equals(secretWord)) {
                System.out.println("\nCongrats! You guessed the word: " + secretWord);
                return;
            }
        }

        System.out.println("\nGame Over. The word was: " + secretWord);
    }
    public int getScore() {
        return remainingTries * 10;
    }
}
