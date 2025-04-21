import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static Scanner input = new Scanner(System.in);
    static Scanner inputS = new Scanner(System.in);
    static ArrayList<Player> playersSM= new ArrayList<>();
    static ArrayList<Player> playersMM= new ArrayList<>();
    static ArrayList<Player> playersSMAT= new ArrayList<>();
    static ArrayList<Player> playersMMAT= new ArrayList<>();
    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu(){
        System.out.println("*** Main menu ***");
        System.out.println("1. Play");
        System.out.println("2. Scores");

        System.out.println("Enter your choice: ");
        int choice = input.nextInt();

        switch (choice){
            case 1:
                playMenu();
                return;
            case 2:
                scoresMenu();
                return;
            default:
                System.out.println("Wrong input!");
                playMenu();
                return;
        }
    }

    public static void playMenu(){
        System.out.println("*** Play ***");
        System.out.println("1. Single player");
        System.out.println("2. Multiple players");
        System.out.println("3. Main menu");

        System.out.println("Enter your choice: ");
        int choice = input.nextInt();

        switch (choice){
            case 1:
                singlePlayer();
                mainMenu();
                return;
            case 2:
                multiplePlayers();
                mainMenu();
                return;
            case 3:
                mainMenu();
                return;
            default:
                System.out.println("Wrong input!");
                playMenu();
                return;
        }
    }

    public static void scoresMenu(){
        System.out.println("*** Scores ***");
        System.out.println("1. Single player");
        System.out.println("2. Multiple players");
        System.out.println("3. Main menu");

        System.out.println("Enter your choice: ");
        int choice = input.nextInt();

        switch (choice){
            case 1:
                System.out.println("Single players scores: ");
                showScores(playersSMAT);
                mainMenu();
                return;
            case 2:
                System.out.println("Multiple players scores: ");
                showScores(playersMMAT);
                mainMenu();
                return;
            case 3:
                mainMenu();
                return;
            default:
                System.out.println("Wrong input!");
                playMenu();
                return;
        }
    }

    public static void singlePlayer(){
        playersSM.clear();
        System.out.print("Enter your name: ");
        String name = inputS.nextLine();
        Player player = new Player(name);
        playersSM.add(player);
        
        System.out.println("Welcome, " + player.getName() + "! Let's play Word Guessing Game.");
        Game game = new Game();
        game.play(playersSM);
        playersSMAT.add(player);
    }

    public static void multiplePlayers(){
        playersMM.clear();

        System.out.println("Enter number of players: ");
        int NOP = input.nextInt();
        while(NOP < 2){
            System.out.println("Wrong input!");
            System.out.println("Enter number of players: ");
            NOP = input.nextInt();
        }
        while(NOP > 0){
            System.out.print("Enter your name: ");
            String name = inputS.nextLine();
            Player player = new Player(name);
            playersMM.add(player);
            NOP--;
        }
        
        System.out.println("Let's play Word Guessing Game.");
        Game game = new Game();
        game.play(playersMM);
        
        for(Player player : playersMM){
            playersMMAT.add(player);
        }
    }

    public static void showScores(ArrayList<Player> players){
        int n = 1;
        for (Player player : players){
            System.out.println(n + ". " + player.getName() + ": " + player.score);
            n++;
        }

    }
}