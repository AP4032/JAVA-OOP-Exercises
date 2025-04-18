import java.util.Random;
import java.util.Scanner;

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

    public void play() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        while (attempts > 0) {
            System.out.println("Word: " + String.valueOf(guessedWord));
            System.out.print("Enter a letter: ");
            char guess = scanner.next().charAt(0);
            boolean correct = false;

            for (int i = 0; i < chosenWord.length(); i++) {

                    if (chosenWord.charAt(i) == guess) {
                        if (guessedWord[i] != '_') {
                            System.out.println(" You guessed is reiterative:" + guess + " Try a different letter.");
                           break; }
                        score += 5;
                        guessedWord[i] = guess;
                        correct = true;

                        System.out.println("your score=" + score);

                    }
                }

            if (!correct) {
                attempts--;
                System.out.println("Incorrect guess! Attempts left: " + attempts);
                System.out.println("1.Continue the game");


                System.out.println("2.Hint(1 times free)");
                System.out.println("3.Hint(30 Score = 1)");
                System.out.println("4. Exit");

                System.out.println("Enter your choice:");

                Scanner NUMBER = new Scanner(System.in);
                int number = NUMBER.nextInt();
                switch (number) {
                    case 1:
                        break;
                    case 2:
                        int Hint = 1;
                        for (int i = 0; i < Hint; i++) {


                            if (i < 1) {
                                while (true) {
                                    Random random = new Random();
                                    int j = random.nextInt(chosenWord.length());
                                    if (guessedWord[j] == '_') {
                                        guessedWord[j] = chosenWord.charAt(j);


                                        break;
                                    }
                                }

                            } else {
                                System.out.println("NO Hint!");
                            }
                        }
                        break;
                    case 3:
                        int hint = (score / 30);
                        for (int i = 0; i < hint; i++) {


                            if (i < hint) {
                                while (true) {
                                    Random random = new Random();
                                    int j = random.nextInt(chosenWord.length());
                                    if (guessedWord[j] == '_') {
                                        guessedWord[j] = chosenWord.charAt(j);
                                        break;

                                    }
                                }
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Exiting the game...");
                        return;
                }
            }
            if (String.valueOf(guessedWord).equals(chosenWord)) {
                System.out.println("Congratulations! You guessed the word: " + chosenWord);
                return;
            }
        }
        System.out.println("Game Over! The word was: " + chosenWord);


    }
}

