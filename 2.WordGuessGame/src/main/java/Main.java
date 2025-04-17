//Aria Razavi 

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Player previousPlayer = null; 
    private static ArrayList<Player> allPlayers = new ArrayList<>(); 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = null;
        System.out.println("Welcome to Word Guessing Game!");

        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Start New Game");
            System.out.println("2. Show Score");
            System.out.println("3. Exit");
            System.out.print("Choose an option (1-3): ");
            String choice = scanner.next().trim();
            scanner.nextLine(); 

            switch (choice) {
                case "1":
                    if (player != null) {
                        previousPlayer = player;
                        updateOrAddPlayer(player);
                    }
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine().trim();
                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty!");
                        break;
                    }

                    player = findPlayerByName(name);
                    if (player == null) {
                        player = new Player(name);
                    }
                    player.resetScore();
                    System.out.println("Hello, " + player.getName() + "! Let's start the game.");
                    Game game = new Game(player);
                    game.play(scanner);
                    break;

                case "2":
                    System.out.println("\n=== Scores ===");
                    if (player == null) {
                        System.out.println("No current player yet!");
                    } else {
                        System.out.println("Current player: " + player.getName() + "'s score: " + player.getScore());
                    }
                    if (previousPlayer != null) {
                        System.out.println("Previous player: " + previousPlayer.getName() + "'s score: " + previousPlayer.getScore());
                    } else {
                        System.out.println("No previous player yet!");
                    }
                    System.out.println("\nAll players:");
                    if (allPlayers.isEmpty()) {
                        System.out.println("No players have played yet!");
                    } else {
                        for (Player p : allPlayers) {
                            System.out.println(p.getName() + "'s score: " + p.getScore());
                        }
                    }
                    break;

                case "3":
                    System.out.println("Thanks for playing!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option! Please choose 1, 2, or 3.");
            }
        }
    }

    // پیدا کردن بازیکن با نام
    private static Player findPlayerByName(String name) {
        for (Player p : allPlayers) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    // به‌روزرسانی یا اضافه کردن بازیکن به لیست
    private static void updateOrAddPlayer(Player player) {
        for (Player p : allPlayers) {
            if (p.getName().equals(player.getName())) {
                p.addScore(player.getScore());
                return;
            }
        }
        
        allPlayers.add(player);
    }
}