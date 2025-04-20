import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        List<Player> players = new ArrayList<>();

        System.out.println("🏀 Welcome to the Sports Court Booking System!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add court (Admin)");
            System.out.println("2. Show all courts");
            System.out.println("3. Register player");
            System.out.println("4. Book a court (Player)");
            System.out.println("5. Release a court");
            System.out.println("0. Exit");
            System.out.print("Enter option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // مصرف newline

            switch (choice) {
                case 1:
                    System.out.print("Enter sport type (e.g., Tennis, Basketball): ");
                    String sport = scanner.nextLine();
                    admin.addCourt(sport);
                    break;

                case 2:
                    admin.displayCourts();
                    break;

                case 3:
                    System.out.print("Enter player name: ");
                    String playerName = scanner.nextLine();
                    players.add(new Player(playerName));
                    System.out.println(playerName + " registered.");
                    break;

                case 4:
                    if (players.isEmpty()) {
                        System.out.println("No players registered.");
                        break;
                    }
                    if (admin.getCourts().isEmpty()) {
                        System.out.println("No courts available.");
                        break;
                    }

                    System.out.println("Select player:");
                    for (int i = 0; i < players.size(); i++) {
                        System.out.println(i + ". " + players.get(i).getName());
                    }
                    int playerIndex = scanner.nextInt();
                    scanner.nextLine(); // مصرف newline

                    System.out.println("Select court:");
                    List<Court> courts = admin.getCourts();
                    for (int i = 0; i < courts.size(); i++) {
                        System.out.println(i + ". " + courts.get(i).toString());
                    }
                    int courtIndex = scanner.nextInt();
                    scanner.nextLine();

                    Player selectedPlayer = players.get(playerIndex);
                    Court selectedCourt = courts.get(courtIndex);
                    selectedPlayer.bookCourt(selectedCourt);
                    break;

                case 5:
                    System.out.println("Select court to release:");
                    List<Court> courtList = admin.getCourts();
                    for (int i = 0; i < courtList.size(); i++) {
                        System.out.println(i + ". " + courtList.get(i).toString());
                    }
                    int releaseIndex = scanner.nextInt();
                    scanner.nextLine();
                    courtList.get(releaseIndex).releaseCourt();
                    System.out.println("Court released.");
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
