import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        ArrayList<Court> courtsList = new ArrayList<>();
        ArrayList<Player> playerList = new ArrayList<>();

        initPlayerList(playerList);
        initCourtList(courtsList);

        Scanner sc = new Scanner(System.in);

        boolean keepGoing = true;
        System.out.println("\n====  Welcome to Court management system  ====\n");
        while (keepGoing) {
            showMenu();
            int ans = sc.nextInt();
            sc.nextLine();

            switch (ans) {
                case 1 -> handleBookCourt(sc, courtsList, playerList);
                case 2 -> handleCancelBooking(sc, playerList);
                case 3 -> printAvailableCourts(courtsList);
                case 4 -> addCourt(sc, courtsList, admin);
                case 5 -> removeCourt(sc, courtsList, admin);
                case 6 -> {
                    System.out.println("Closing The Panel");
                    keepGoing = false;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
        sc.close();
    }

    public static void handleBookCourt(Scanner sc, ArrayList<Court> courtsList, ArrayList<Player> playerList) {
        System.out.print("Enter your name: ");
        String playerName = sc.nextLine();

        Player player = findPlayerByName(playerList, playerName);

        if (player == null) {
            player = new Player(playerName);
            playerList.add(player);
            System.out.println("New player created.");
        } else {
            System.out.println("Welcome back, " + playerName + "!");
        }

        printAvailableCourts(courtsList);
        System.out.print("Enter your court's ID: ");
        int courtId = sc.nextInt();
        sc.nextLine();
        player.bookCourt(courtsList, courtId);
    }

    public static void handleCancelBooking(Scanner sc, ArrayList<Player> playerList) {
        System.out.print("Enter your username: ");
        String playerName = sc.nextLine();

        Player player = findPlayerByName(playerList, playerName);

        if (player == null) {
            System.out.println("There is no player by this name!");
            return;
        } else {
            System.out.println("Welcome back, " + playerName + "!");
        }

        System.out.println("Your booked courts list:");
        player.viewCurrentBooks();

        System.out.print("Enter the booked Court's ID you want to cancel: ");
        int courtID = sc.nextInt();
        sc.nextLine();

        boolean removed = player.removeBookedCourt(courtID);
        if (removed) {
            System.out.println("Court with ID " + courtID + " has been removed from your booking list.");
        } else {
            System.out.println("You didn't have a booking for court with ID " + courtID + ".");
        }
    }

    public static void addCourt(Scanner sc, ArrayList<Court> courtsList, Admin admin) {
        System.out.print("Enter the type of the court: ");
        String courtType = sc.nextLine();
        if (isCourtUnique(courtsList, courtType)) {
            admin.addCourt(courtsList, new Court(courtType));
        } else {
            System.out.println("You cannot add a court with this type :(");
        }
    }

    public static void removeCourt(Scanner sc, ArrayList<Court> courtsList, Admin admin) {
        printAvailableCourts(courtsList);
        System.out.print("Enter the ID of the court you want to remove: ");
        int targetCourtID = sc.nextInt();
        sc.nextLine();
        admin.removeCourt(courtsList, targetCourtID);
        printAvailableCourts(courtsList);
    }

    public static void showMenu() {
        System.out.println("\n~~~ Menu ~~~\n");
        System.out.println("1. Book a court");
        System.out.println("2. Cancel a book");
        System.out.println("3. Available courts");
        System.out.println("4. Add a court (Admin)");
        System.out.println("5. Remove a court (Admin)");
        System.out.println("6. Exit");
        System.out.print("\nChoose an option: ");
    }

    public static void initCourtList(ArrayList<Court> courtList) {
        courtList.add(new Court("football"));
        courtList.add(new Court("basketball"));
        courtList.add(new Court("tennis"));
    }

    public static void initPlayerList(ArrayList<Player> playerList) {
        playerList.add(new Player("John"));
        playerList.add(new Player("Sina"));
    }

    public static void printAvailableCourts(ArrayList<Court> list) {
        System.out.println("Current Court: ");
        for (Court c : list) {
            System.out.println(c);
        }
    }

    public static boolean isCourtUnique(ArrayList<Court> list, String courtType) {
        for (Court c : list) {
            if (c.getType().equalsIgnoreCase(courtType)) return false;
        }
        return true;
    }

    public static Player findPlayerByName(ArrayList<Player> players, String name) {
        for (Player p : players) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }
}
