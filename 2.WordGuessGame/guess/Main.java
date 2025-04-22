public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Player player = new Player();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Word Guess Game Menu ---");
            System.out.println("1. Start New Game");
            System.out.println("2. Show Score");
            System.out.println("3. Exit");

            int choice = player.getMenuChoice();
            player.clearInputBuffer();

            switch (choice) {
                case 1:
                    game.startNewGame();
                    while (!game.isGameOver()) {
                        char guess = player.getGuess();
                        game.processGuess(guess);
                        game.displayWord();
                    }

                    if (game.isWordGuessed()) {
                        System.out.println("Congratulations! You guessed the word!");
                        player.incrementWins();
                    } else {
                        System.out.println("Game Over. The word was: " + game.getChosenWord());
                        player.incrementLosses();
                    }
                    break;

                case 2:
                    player.showScore();
                    break;

                case 3:
                    System.out.println("Exiting the game. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}