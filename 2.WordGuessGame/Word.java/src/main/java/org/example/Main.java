package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player[] players = new Player[100];
        int playerCount = 0;
        Game game = null;
        while (true){
            System.out.println("--- Word Guess Game ---");
            System.out.println("1. Start game");
            System.out.println("2. Show words");
            System.out.println("3. Exit");
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.println("How many players? ");
                    playerCount = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < playerCount; i++){
                        System.out.println("Enter name of player " + (i + 1) + ": " );
                        players[i] = new Player(scanner.nextLine());
                    }
                    for (int i = 0; i< playerCount; i++){
                        System.out.println("--- Player " + players[i].getName() +"'s turn ---" );
                        game = new Game(players[i]);
                        game.play();
                        System.out.println("Score of " + players[i].getName() + ": " + players[i].getScore());
                    }
                    break;
                case 2:
                    if (game == null){
                        game = new Game(null);
                    }
                    game.showWordList();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

