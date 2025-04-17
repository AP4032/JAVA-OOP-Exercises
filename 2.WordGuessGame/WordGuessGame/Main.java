import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        Player player = new Player(name);

        System.out.println("Welcome, " + player.getName() + "! Let's play Word Guessing Game.");


            System.out.println("****Menu****");

                System.out.println("1.Start game");



            System.out.println("2. Exit");

            System.out.println("Enter your choice:");

            Scanner NUMBER = new Scanner(System.in);
            int number = NUMBER.nextInt();
            switch (number) {
                case 1:
                    System.out.println("start game");
                    Game game = new Game();
                    game.play();
                    break;
                case 2:
                    System.out.println("Exiting the game...");
                    return;


                default:
                    System.out.println("Eror...");
            }
            Game game = new Game();
            game.play();
        }
    }
