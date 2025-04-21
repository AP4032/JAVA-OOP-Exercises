package MyJava2;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Word Guessing Challenge!");
        System.out.println("Enter number of players: ");
        int totalPlayers = Integer.parseInt(scanner.nextLine());

        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= totalPlayers; i++) {
            System.out.println("Enter player " + i + "'s name: ");
            String name = scanner.nextLine();
            players.add(new Player(name));
        }
        for (Player player : players) {
            Game game = new Game();
            game.start(player.getName());
            player.addScore(game.getScore());
        }
        System.out.println("--- Final Scores ---");
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getScore() + " points.");
        }
    }
}
