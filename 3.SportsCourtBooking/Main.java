// Main.java
package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        Player player = new Player("");
        Court court = new Court("");
        System.out.println("Welcome to the Court Booking System!");
        Scanner input = new Scanner(System.in);
        int choice ;
        while(true){
            System.out.println("Enter your Choice : ");
            System.out.println("1) Add Court\n2) Remove Court\n3) Add player\n4) Remove player\n5) Add player to court\n6) Remove player from court\n7) Show Court\n8) Show players\n9) Exit");
            choice = validInput(input,1,9);
            switch(choice){
                case 1:
                    admin.addCourt(input);
                    break;
                case 2:
                    admin.removeCourt(input);
                    break;
                case 3:
                    player.addPlayer(input);
                    break;
                case 4:
                    player.removePlayer(input);
                    break;
                case 5:
                    court.addPlayerToCourt(input,admin,player);
                    break;
                case 6:
                    court.removePlayerFromCourt(input,admin,player);
                    break;
                case 7:
                    admin.showAllCourts();
                    break;
                case 8:
                    player.displayPlayers();
                    break;
                case 9:
                    System.out.println("Exiting program . . . ");
                    System.exit(0);
                    break;
            }
        }

    }
    public static int validInput(Scanner input , int min, int max ){
        int choice ;
        while (true) {
            if (!input.hasNextInt()) {
                System.out.println("Please enter a number");
                input.next();
                continue;
            }
            choice = input.nextInt();
            input.nextLine();
            if(choice >=min && choice <= max){
                return choice;
            } else {
                System.out.println("Enter a number between " + min + " and " + max);
            }
        }
    }
}
