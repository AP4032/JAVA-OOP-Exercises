import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

    public class Game {
        private String[] words = {"java", "python", "programming", "developer", "object"};
        private String chosenWord;
        private char[] guessedWord;
        private int attempts;
        private List<Player> players;

        public Game() {
            Random random = new Random();
            this.players = new ArrayList<>();
            this.chosenWord = words[random.nextInt(words.length)];
            this.guessedWord = new char[chosenWord.length()];
            for (int i = 0; i < guessedWord.length; i++) {
                guessedWord[i] = '_';
            }
            this.attempts = chosenWord.length() + 3;
        }

        public void addPlayers() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the number of players: ");
            int numberOfPlayers = scanner.nextInt();
            scanner.nextLine();
            for (int i = 1; i <= numberOfPlayers; i++) {
                System.out.println("Enter the name of Player " + i);
                Player player = new Player(scanner.nextLine());
                players.add(player);
            }
        }

        public void play() {
            Scanner scanner = new Scanner(System.in);
            while (attempts > 0) {
                for (Player player : players) {
                    System.out.println(player.getName() + "'s turn: ");
                    System.out.println("Word: " + String.valueOf(guessedWord));
                    System.out.print("Enter a letter: ");
                    char guess = scanner.next().charAt(0);
                    boolean correct = false;

                    for (int i = 0; i < chosenWord.length(); i++) {
                        if (chosenWord.charAt(i) == guess) {
                            guessedWord[i] = guess;
                            correct = true;
                            player.addScore();
                            System.out.println("Correct! " + player.getName() + " earned a point!");
                        }
                    }

                    if (!correct) {
                        attempts--;
                        System.out.println("Incorrect guess! Attempts left: " + attempts);
                    }

                    if (String.valueOf(guessedWord).equals(chosenWord)) {
                        System.out.println("Congratulations! You guessed the word: " + chosenWord);
                        for (Player p : players) {
                            System.out.println(p.getName() + "'s score: " + p.getScore());
                            return;
                        }
                    }
                }
            }
                System.out.println("Game Over! The word was: " + chosenWord);
                for (Player p : players) {
                    System.out.println(p.getName() + "'s score: " + p.getScore());
                }
            }
        }



