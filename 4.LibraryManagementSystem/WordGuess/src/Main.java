import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        Player player = new Player(name);

        System.out.println("Welcome, " + player.getName() + "! Let's play Word Guessing Game.");
        Game game = new Game();
        game.play();

        scanner.close();
    }
}