import java.util.Scanner;

public class Main {
    private static Player player;
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("======* Welcome to Word Guess Game! *======");
        System.out.println("-------* Main Menu *-------");
        System.out.println("1. play Game");
        System.out.println("2. exit");
        System.out.print("Enter your choice:");
        int choice = scanner.nextInt();
        scanner.nextLine();
        do {
            switch (choice) {
                case 1:
                    askName();
                    playGame();
                    if (askReplay()) {
                        playGame();
                    }
                    else{
                        System.out.println("Game Over!");
                    }
                    return;
                case 2:
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }while (true);
    }
    private static boolean askReplay() {
        System.out.println("Play again? (yes/no)");
        return scanner.next().equalsIgnoreCase("yes");
    }
    private static void playGame() {
        Game game = new Game();
        System.out.println(player.getName()+",Please enter the name of the subject that you want to guess the words for:");
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
            }
        }
        if (!correct) {
            System.out.println("Invalid input. Try again.");
            playGame();
        }
        game.play();
    }
    private static void askName(){
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        if(name.isBlank()){
            System.out.println("Invalid input. Try again.");
            askName();
        }
        else
            player = new Player(name);
    }
}
