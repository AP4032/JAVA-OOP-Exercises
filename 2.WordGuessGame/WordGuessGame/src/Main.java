import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        Player player = new Player(name);

        System.out.println("Welcome, " + player.getName() + "! Let's play Word Guessing Game.");

        boolean running = true;
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Start Game");
            System.out.println("2. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Game game = new Game();
                    game.play();
                    break;

                case 2:
                    running = false;
                    System.out.println("Exiting... You exited the game!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }
}