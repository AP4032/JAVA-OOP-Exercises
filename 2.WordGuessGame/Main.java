package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("Enter your name for the game ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Welcome " + name + "  to the game (HANGMAN)\n1-PLAY \n2-EXIT\n3-ADD MANNUALLY ");
        do {
            System.out.print("Enter your choice : ");
            int choice = validInpute(scanner,3,1);
            if (choice == 1) {
                game = new Game();
                game.Play();
            }else if (choice == 2) {
                System.out.println("Thank you for playing!");
                return;
            }else if (choice == 3) {
                System.out.println("Enter a word for the game ");
                scanner.nextLine();
                String word = scanner.nextLine().toUpperCase();
                game.setChosenWord(word);
                game.Play();

            }
            else {
                System.out.println("Wrong choice. Try again");
            }
        }while (true);



        }
    public static int validInpute(Scanner input, int max, int min) {
        int choice;
        while (true) {
            while (!input.hasNextInt()) {
                System.out.println("Invalid choice, please try again:");
                input.nextLine();

            }

            choice = input.nextInt();..

            if (choice >= min && choice <= max) {
                return choice;
            } else if(max==min){
                System.out.println("Invalid input try again");
            } else {
                System.out.println("Enter a number between " + min + " and " + max);
            }

        }
    }



}