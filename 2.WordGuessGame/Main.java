import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[] programming = {"java", "python", "programming", "developer", "object"};
        String[] foods = {"tacos", "burger", "spaghetti", "sushi", "steak"};
        String[] movies = {"interstellar", "gladiator", "godfather", "inception", "crash"};
        String[] colores = {"red", "blue", "black", "white", "orange"};

        Scanner scanner = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        boolean running = true;
        int choice ;
        while (running) {
            System.out.println("===Word Guessing Game===");
            System.out.println("1. start the game");
            System.out.println("2. exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();

            switch (choice){

                case 1:
                    System.out.println("enter your name : ");
                    String playername = scanner.nextLine();
                    Player user = new Player(playername);

                    System.out.println("Welcome, " + user.getName() + "! Let's play Word Guessing Game.");

                    System.out.println("select a category : ");
                    System.out.println("1. programming");
                    System.out.println("2. foods");
                    System.out.println("3. movies");
                    System.out.println("4. colors");
                    System.out.println("enter your choice: ");
                    int choice2 = input.nextInt();


                    switch (choice2){

                        case 1:
                            Game game1 = new Game(programming);
                            game1.play();
                            break;

                        case 2:
                            Game game2 = new Game(foods);
                            game2.play();
                            break;

                        case 3:
                            Game game3 = new Game(movies);
                            game3.play();
                            break;

                        case 4 :
                            Game game4 = new Game(colores);
                            game4.play();
                            break;

                        default :
                            System.out.println("wrong choice");
                    }
                    break;

                case 2:
                    running = false;
                    System.out.println("Exiting... Goodbye!");
                    break;

                default :
                    System.out.println("Invalid choice");

            }
        }


    }
}