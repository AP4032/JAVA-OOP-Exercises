package WordGuessSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*** Welcome to the Word Guessing Game ***");

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        Player player = new Player(name);

        int choice;
        do {
            System.out.println("\nHello " + player.getName() + ", what would you like to do?");
            System.out.println("1. Start Game");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a valid number (1 or 2): ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    Game game = new Game();
                    game.play();
                    break;
                case 2:
                    System.out.println("Goodbye, " + player.getName() + "!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 2);
    }
}