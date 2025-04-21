import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ScoreSystem scoreSystem = new ScoreSystem();

        System.out.println("=== Word Guessing Game ===");

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. New Game");
            System.out.println("2. Leaderboard");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    startNewGame(scanner, scoreSystem);
                    break;
                case 2:
                    scoreSystem.displayLeaderboard();
                    break;
                case 3:
                    System.out.println("Thanks for playing!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void startNewGame(Scanner scanner, ScoreSystem scoreSystem) {
        System.out.print("\nEnter player name: ");
        String playerName = scanner.nextLine();

        Player player = scoreSystem.getPlayer(playerName);
        if (player == null) {
            player = new Player(playerName);
            scoreSystem.addPlayer(player);
        }

        DifficultyLevel difficulty = selectDifficulty(scanner);
        Game game = new Game(player, difficulty);
        game.play(scoreSystem);

        System.out.print("\nPlay again? (y/n): ");
        String playAgain = scanner.next().toLowerCase();
        if (playAgain.equals("y")) {
            startNewGame(scanner, scoreSystem);
        }
    }

    private static DifficultyLevel selectDifficulty(Scanner scanner) {
        System.out.println("\nSelect Difficulty:");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1: return DifficultyLevel.EASY;
            case 2: return DifficultyLevel.MEDIUM;
            case 3: return DifficultyLevel.HARD;
            default:
                System.out.println("Invalid choice. Defaulting to Medium.");
                return DifficultyLevel.MEDIUM;
        }
    }
}