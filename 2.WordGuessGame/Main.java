import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        Player player = new Player(name);
        ArrayList<Integer>scores = new ArrayList<>();
        boolean playing = true;

        while(playing)
        {
            System.out.println("Welcome, " + player.getName() + "! Let's play Word Guessing Game.");
            Game game = new Game();
            game.play();
            scores.add(game.score);
            boolean isBestScore = true;

            for (int i = 0; i < scores.size() - 1; i++)
            {
                if (scores.get(i) >= game.score)
                {
                    isBestScore = false;
                    break;
                }
            }
            if (isBestScore && scores.size() > 1)
            {
                System.out.println("Well done! " + game.score + " is your best score till now.");
            }
            System.out.println("Would you like to play again? (y/n)");
            String answer = scanner.nextLine();
            playing = answer.equalsIgnoreCase("y");
            System.out.println("Your Scores: " + scores);
        }
    }
}