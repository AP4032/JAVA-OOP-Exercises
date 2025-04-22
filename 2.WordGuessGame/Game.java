import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private String[] words = {"java", "python", "programming", "developer", "object","apple", "computer", "samsung", "asus", "wifi","elonmusk","telegram","ps5","microsoft","adaptor","calender", "calculator", "netflix", "callofduty", "spotify","chatgpt","clashroyal","soccerstars","shareit","8ballpool","biology", "chemistry", "civilengineering", "architect","lawyer","commander","datascience","president","tailor","machinelearning"};
    private String[] mode = words;
    private String[] easywords = {"apple", "computer", "samsung", "asus", "wifi","elonmusk","telegram","ps5","microsoft","adaptor"};
    private String[] meduimwords = {"calender", "calculator", "netflix", "callofduty", "spotify","chatgpt","clashroyal","soccerstars","shareit","8ballpool"};
    private String[] hardwords = {"biology", "chemistry", "civilengineering", "architect","lawyer","commander","datascience","president","tailor","machinelearning"};
    public String chosenWord;
    private char[] guessedWord;
    private int attempts;
    public ArrayList<Integer> multiattempts ;
    private Player player;
    public Game(Player player) {
        multiattempts = new ArrayList<>();
        this.player = player;
        Random random = new Random();
        this.chosenWord = mode[random.nextInt(mode.length)];
        this.guessedWord = new char[chosenWord.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }
        this.attempts = chosenWord.length() + 3;
    }
    public void resetGame() {
        Random random = new Random();
        this.chosenWord = mode[random.nextInt(mode.length)];
        this.guessedWord = new char[chosenWord.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }
        this.attempts = chosenWord.length() + 3;
    }

    public void gamelevel(){
        boolean play = true;
        while(play) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(player.names + " points : " +player.points );
            System.out.println("Choose your level");
            System.out.println("1. Easy");
            System.out.println("2. Medium");
            System.out.println("3. Hard");
            System.out.println("*****");
            System.out.println("4. Exit Game");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    mode = easywords;
                    resetGame();
                    oneplayermode();
                    break;
                case 2:
                    if (player.points.get(0) > 20) {
                        mode = meduimwords;
                        resetGame();
                        oneplayermode();
                    } else {
                        System.out.println("You dont have enough points");
                    }
                    break;
                case 3:
                    if (player.points.get(0) > 50) {
                        mode = hardwords;
                        resetGame();
                        oneplayermode();
                    } else {
                        System.out.println("You dont have enough points");
                    }
                    break;
                    case 4:
                        System.out.println(player.names + " points : " +player.points );
                        play = false;
            }
        }
    }

    public void oneplayermode() {
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
                    if(correct) {
                        if (mode == easywords) {
                            player.points.set(0, player.points.get(0) + 1);
                        } else if (mode == meduimwords) {
                            player.points.set(0, player.points.get(0) + 2);
                        } else if (mode == hardwords) {
                            player.points.set(0, player.points.get(0) + 3);
                        }
                    }
                }
            }

            if (!correct) {
                attempts--;
                System.out.println("Incorrect guess! Attempts left: " + attempts);
            }

            if (String.valueOf(guessedWord).equals(chosenWord)) {
                System.out.println("Congratulations! You guessed the word: " + chosenWord);
                return;
            }
        }
        System.out.println("Game Over! The word was: " + chosenWord);
    }
    public void multiplayermode(int players) {
        System.out.println(" *** Welcome to multiplayer mode *** ");
        System.out.println("If you guess a letter give 1 point and if you guess the last letter of word give 3 points.");
        Scanner scanner = new Scanner(System.in);
        int j = 0 ;
        boolean turn  = true;
        while (turn ) {
            while (j < players) {
                System.out.println(player.names.get(j) + "  turn : ");
                System.out.println("Player " +player.names.get(j) + " points: " +  player.points.get(j));
                System.out.println("Word: " + String.valueOf(guessedWord));
                System.out.print("Enter a letter: ");
                char guess = scanner.next().charAt(0);
                boolean correct = false;

                for (int i = 0; i < chosenWord.length(); i++) {
                    if (chosenWord.charAt(i) == guess) {
                        guessedWord[i] = guess;
                        player.points.set(j, player.points.get(j) + 1);
                        System.out.println("Correct!");
                        System.out.println("Player " +player.names.get(j) + " points: " +  player.points.get(j));
                        correct = true;

                    }
                }


                if (!correct) {
                    multiattempts.set(j,multiattempts.get(j)-1);
                    System.out.println("Incorrect guess! Attempts left: " + multiattempts.get(j));
                    j++;
                }

                if (String.valueOf(guessedWord).equals(chosenWord)) {
                    player.points.set(j, player.points.get(j) + 3);
                    System.out.println("Congratulations! You guessed the word: " + chosenWord);
                    for (int i =0;i<players;i++) {
                        System.out.println(player.names.get(i) + " points:  " + player.points.get(i));
                    }
                    turn = false;
                    break;
                }

            }

j=0;
        }
        System.out.println(" The word was: " + chosenWord);
    }
}
