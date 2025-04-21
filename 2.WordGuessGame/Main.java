import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the guess game!");
        menu();



    }
    public static void menu(){
        boolean x ;
        System.out.println("1. Single player");
        System.out.println("2. Play with friend");
        System.out.println("3. Add word to the library");
        System.out.println("4. Exit");
        System.out.println("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();
                Player player = new Player(name);

                System.out.println("Welcome, " + player.getName() + "! Let's play Word Guessing Game.");
                Game game = new Game();
                x=game.play();
                System.out.println("returning to main menu");
                menu();
            case "2":
                System.out.print("Enter first player name: ");
                String name1 = scanner.nextLine();
                Player player1 = new Player(name1);
                System.out.println("Enter second player name: ");
                String name2 = scanner.nextLine();
                Player player2 = new Player(name2);
                System.out.println("Welcome, " + player1.getName() + " and "+ player2.getName()+"! Let's play Word Guessing Game.");
                boolean running = true;
                do{
                    System.out.println(player1.getName()+" turn :");
                    Game game1 = new Game();
                    x=game1.play();
                    if(x){
                        player1.upGrade_score();
                    }
                    System.out.println(player2.getName()+" turn :");
                    Game game2 = new Game();
                    x=game2.play();
                    if(x){
                        player2.upGrade_score();
                    }
                    game1.scoreBoard2(player1,player2);
                    System.out.println();
                    int y = 0;
                    while(y==0) {
                        System.out.println("Do you want to play again? (Y/N)");
                        String choice2 = scanner.nextLine();
                        if (choice2.equals("N")) {
                            running = false;
                            y = 1;
                        }
                        if (choice2.equals("Y")) {
                            y = 1;
                        } else {
                            System.out.println("invalid input!");
                        }
                    }
                }while (running);
                System.out.println("returning to main menu");
                menu();
            case "3":
                Game.addWordToFile();
                System.out.println("returning to main menu ...");
                menu();
            case "4":
                System.out.println("bye bye");
                System.exit(0);
        }

    }
}