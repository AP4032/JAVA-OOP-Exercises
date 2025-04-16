import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        System.out.println("*** Word Guess Game ***");
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        Player player = new Player(name);

        System.out.println("Welcome" + player.getName() + "! Let's play Word Guessing Game.");
        game.play(player);
    }
}
