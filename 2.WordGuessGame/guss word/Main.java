import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Game game = new Game(input);
        boolean gameRunning = true;
        System.out.println("<<<Welcome to WordGuessGame!>>>");

        while (gameRunning){
            System.out.println("1. start the game...");
            System.out.println("2. Exit!");
            System.out.println("Enter your choice: ");
            String choice = input.next();
            switch (choice){
                case "1":
                    game.start_game();
                    break;
                    case "2":
                        System.out.println("HAVE A GOOD DAY!");
                        gameRunning = false;
                        break;
            }

        }
    }
}
