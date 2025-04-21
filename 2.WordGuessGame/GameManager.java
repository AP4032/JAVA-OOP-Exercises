import java.util.Scanner;

public class GameManager {
    private Player player;
    private Game game;
    private Scanner scanner;

    public GameManager() {
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Welcome to Word Guessing Game!");
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        this.player = new Player(playerName);
        this.game = new Game();

        System.out.println("\nHello, " + player.getName() + "! Let's begin the game.");
        System.out.println("You have " + game.getMaxAttempts() + " attempts to guess the word.");

        game.play();

        scanner.close();
    }
}
