import java.util.Scanner;

public class Player {
    private final Scanner scanner = new Scanner(System.in);
    private int wins = 0;
    private int losses = 0;

    public char getGuess() {
        System.out.print("Enter a letter: ");
        String input = scanner.nextLine().toLowerCase();
        while (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            System.out.print("Invalid input. Please enter a single letter: ");
            input = scanner.nextLine().toLowerCase();
        }
        return input.charAt(0);
    }

    public int getMenuChoice() {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public void clearInputBuffer() {
        scanner.nextLine();
    }

    public void incrementWins() {
        wins++;
    }

    public void incrementLosses() {
        losses++;
    }

    public void showScore() {
        System.out.println("Your Score:");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
    }
}