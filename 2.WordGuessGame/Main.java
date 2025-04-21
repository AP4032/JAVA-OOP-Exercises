// Main.java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);

        // Get word list from user
        List<String> wordList = getWordListFromUser(scanner);

        Game game = new Game(player, wordList);
        game.play(scanner);

        System.out.println("\nGame Over!");
        System.out.println(player);
    }

    private static List<String> getWordListFromUser(Scanner scanner) {
        List<String> wordList = new ArrayList<>();
        System.out.print("Enter the number of words you want to add: ");
        int numWords = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter the words, one per line:");
        for (int i = 0; i < numWords; i++) {
            String word = scanner.nextLine();
            wordList.add(word);
        }
        return wordList;
    }
}
