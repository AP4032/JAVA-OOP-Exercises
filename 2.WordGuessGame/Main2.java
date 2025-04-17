import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner numScanner = new Scanner(System.in);
        Scanner strScanner = new Scanner(System.in);

        System.out.println("=== Word Guess Game ===");

        boolean running = true;
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. New Game");
            System.out.println("2. Add Word to List");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = numScanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(game.words.size());
                    System.out.print("Enter your name: ");
                    String name = strScanner.nextLine();
                    Player player = new Player(name);

                    System.out.println("Welcome, " + player.getName() + "! Let's play Word Guessing Game.");
                    game.play();
                    break;

                case 2:
                    System.out.print("Enter the word you want to add: ");
                    String newWord = strScanner.nextLine();
                    game.addWord(newWord);
                    break;

                case 3:
                    running = false;
                    System.out.println("Exiting... See you next time!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        numScanner.close();
        strScanner.close();
    }
}
