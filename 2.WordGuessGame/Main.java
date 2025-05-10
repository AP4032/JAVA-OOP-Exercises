import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int playerNum=1;
    private static boolean singleMode;
    private static List<Player> players = new ArrayList<>();
    private static Scanner inputInt = new Scanner(System.in);
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("======* Welcome to Word Guess Game! *======");
        mainMenu();
    }
    private static boolean askReplay() {
        Scanner s = new Scanner(System.in);
        System.out.println("Play again? (yes/no)");
        return s.next().equalsIgnoreCase("yes");
    }
    private static void playGame() {
        Game game = new Game();
        System.out.println("Subjects : [ Food | Programming | Car | Color | Game | Country | Name ]");
        System.out.println("Please enter the name of the subject that you want to guess the words for:");
        String subject = scanner.nextLine().toLowerCase();
        boolean correct = false;
        for (String string : Subject.getSubjects()){
            if (string.equals(subject)) {
                correct = true;

                switch (subject) {
                    case "food":
                        game.setWords(Subject.getFood());
                        break;
                    case "programming":
                        game.setWords(Subject.getProgramming());
                        break;
                    case "car":
                        game.setWords(Subject.getCar());
                        break;
                    case "color":
                        game.setWords(Subject.getColor());
                        break;
                    case "game":
                        game.setWords(Subject.getGame());
                        break;
                    case "country":
                        game.setWords(Subject.getCountry());
                        break;
                    case "name":
                        game.setWords(Subject.getName());
                        break;
                }
                break;
            }
        }
        if (!correct) {
            System.out.println("Invalid input. Try again.");
            playGame();
        }
        game.chooseWord();
        for (Player player : players) {
            player.setAttempts(game.getChosenWord().length() + 3);
        }
        if (singleMode) {
            game.playSingle(players.getFirst());
        }
        else {
            while (true){
                for (Player player : players) {
                    if(game.isGameOver())
                        return;
                    game.multiplayerMode(player);
                }
            }
        }
    }
    private static void askName(){
        players.clear();
        for (int i = 1; i <= playerNum; i++){
            System.out.println("Player "+i+",Enter your name:");
            String name = scanner.nextLine();
            if(name.isBlank()){
                System.out.println("Invalid input. Try again.");
                askName();
            }
            else
                players.add(new Player(name));
        }
    }
    private static void askPlayerNumber(){
        System.out.println("How many players would you like to play?");
        playerNum = inputInt.nextInt();

    }
    private static void modeMenu(){
        System.out.println("******** Game Mode ********");
        System.out.println("1. Single ");
        System.out.println("2. Multiplayer");
        System.out.println("3. Back to Main Menu");
        System.out.println("****************************");
        System.out.print("Enter your choice:");
        do {
            int choice = inputInt.nextInt();
            switch (choice) {
                case 1:
                    singleMode=true;
                    askName();
                    playGame();
                    return;
                case 2:
                    singleMode=false;
                    askPlayerNumber();
                    askName();
                    playGame();
                    return;
                case 3:
                    mainMenu();
                    return;
                default:
                    System.out.print("Invalid choice, try again:");
            }
        }while (true);
    }
    private static void mainMenu(){
        System.out.println("-------* Main Menu *-------");
        System.out.println("1. play Game");
        System.out.println("2. Scoreboard");
        System.out.println("3. Exit");
        System.out.print("Enter your choice:");
        int choice = scanner.nextInt();
        scanner.nextLine();
        do {
            switch (choice) {
                case 1:
                    modeMenu();
                    do {
                        if (askReplay()) {
                            playGame();
                        } else {
                            mainMenu();
                            return;
                        }
                    }while (true);
                case 2:
                    showScoreboard();
                    mainMenu();
                    return;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }while (true);
    }
    private static void showScoreboard(){
        List<Player> sortedPlayers = new ArrayList<>(players);
        sortedPlayers.sort(Comparator.comparingInt(Player::getScore).reversed());
        int rank = 1;
        if (players.isEmpty()){
            System.out.println("⛔ No game has been played yet! ⛔");
        }
        else{
            for (Player p : sortedPlayers) {
                System.out.println("Rank " + rank + ": " + p.getName() + " - Score: " + p.getScore());
                rank++;
            }
        }
    }
}
