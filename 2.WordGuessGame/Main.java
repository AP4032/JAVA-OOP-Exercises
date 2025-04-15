import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("\033[31m██     ██  ██████  ██████  ██████ ");
        System.out.println("██     ██ ██    ██ ██   ██ ██   ██");
        System.out.println("██  █  ██ ██    ██ ██   ██ ██   ██");
        System.out.println("██ ███ ██ ██    ██ ██   ██ ██   ██");
        System.out.println(" ███ ███   ██████  ██████  ██████ \033[0m");

        System.out.println(); // فاصله

        // Guess
        System.out.println("\033[34m  ██████   ██    ██ ███████ ███████");
        System.out.println(" ██    ██  ██    ██ ██      ██     ");
        System.out.println(" ██    ██  ██    ██ █████   █████  ");
        System.out.println(" ██ ▄▄ ██  ██    ██ ██      ██     ");
        System.out.println("  ██████    ██████  ███████ ███████\033[0m");

        System.out.println(); // فاصله

        // Game
        System.out.println("\033[32m  ██████   █████  ███    ███ ███████");
        System.out.println(" ██       ██   ██ ████  ████ ██     ");
        System.out.println(" ██   ███ ██   ██ ██ ████ ██ █████  ");
        System.out.println(" ██    ██ ██   ██ ██  ██  ██ ██     ");
        System.out.println("  ██████   █████  ██      ██ ███████\033[0m");
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("\033[33mWelcome to WordGuessGame!\uD83D\uDCA5\uD83D\uDD25 \033[0m");
            System.out.println("\033[41mSelect the options below: \033[0m ");
            System.out.println("\033[36m1.play game   \033[0m");
            System.out.println("\033[35m2.exit \033[0m ");
            String choice = input.nextLine();
            switch (choice) {
                case "1":
                    System.out.println( "please enter your name:");
                    String name = input.nextLine();
                    Player player = new Player(name);
                    System.out.println("Welcome, " + player.getName() + "! Let's play Word Guessing Game.");
                    Game game = new Game(player);
                    game.play();
                    break;
                case "2":
                    System.out.println("Thank you very much for playing.");
                    System.exit(0);
                    break;
            }
        }
    }
}
