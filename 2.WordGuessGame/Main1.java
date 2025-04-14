import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) throws IOException {
        Scanner wordScanner = new Scanner(System.in);
        System.out.print("Guess O' Guess!\nWelcome to the word guess game!\nSelect playing mode:\n1.singlePlayer\n2.multiplayer\n");
        int mode = wordScanner.nextInt();
        if (mode == 1) {
            System.out.print("Enter your name: ");
            String name = wordScanner.next();
            Player player = new Player(name);
            Game game = new Game();
            game.singlePlay(player);
        }else if (mode == 2) {
            System.out.println("enter player's name / or type done to start the game:");
            String option = wordScanner.next();
            ArrayList<Player> players = new ArrayList<Player>();
            while(!option.equals("done")) {
                players.add(new Player(option));
                System.out.println("enter player's name / or type done to start the game:");
                option = wordScanner.next();
            }
            Game game = new Game();
            game.multiPlay(players);
        }
    }
}
