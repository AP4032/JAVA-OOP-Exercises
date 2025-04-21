import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Print.printTitle("Guess Word Game");
        gameExplanation();
        Print.printText("Enter your name: ");
        Player player = new Player(input.nextLine());

        Print.printTitle("Welcome To Guess Word Game " + player.getName());
        Game game = new Game();
        game.play();
    }

    private static void gameExplanation() {
        String gameRule = """
                __________________________________________________________________
                Word Guessing Game Rules:
                ● You're given a word with all the letters unknown.
                ● You must guess the word letter by letter
                ● You're allowed only 3 incorrect guesses
                __________________________________________________________________
                """;

        Print.printGameRule(gameRule);
    }
}
