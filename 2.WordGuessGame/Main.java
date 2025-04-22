import java.util.Scanner;

public class Main {
   static Player player = new Player();
    static Game game = new Game(player);

    public static void main(String[] args) {
        System.out.println(" *** Welcome to WordGuessGame! *** ");
        System.out.println("Choose an option:");
        System.out.println("1.Single player ");
        System.out.println("2.Multiplayer ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1) {
            singleplayer();
        }else {
multiplayer();
        }



    }
    public static void singleplayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        player.oneplayer(name);
        System.out.println("Welcome, " + name + "! Let's play Word Guessing Game.");
        player.points.add(0);
        game.gamelevel();

    }
    public static void multiplayer() {
        System.out.println("Enter number of players:");
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        int players = scanner.nextInt();
        for (int i = 0; i < players; i++) {
            System.out.println("player" + (i+1) + " : ");
            String name = scanner2.nextLine();
            game.multiattempts.add(game.chosenWord.length()+3);
            player.points.add(0);
            player.multiplayer(name);
        }


game.multiplayermode(players);

    }
}
