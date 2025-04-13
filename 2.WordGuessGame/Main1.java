import java.io.IOException;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) throws IOException {
        Scanner wordScanner = new Scanner(System.in);
        System.out.print("Guess O' Guess!\nWelcome to the word guess game!\nenter your name: ");
        String name = wordScanner.nextLine();
        Player player = new Player(name);
        Game game = new Game();
        game.singlePlay(player);
    }
}
