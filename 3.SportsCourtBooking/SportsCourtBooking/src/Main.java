import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin(10);

        System.out.println("=== Sports Court Booking System ===");

        boolean running = true;
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add Court");
            System.out.println("2. Show All Courts");
            System.out.println("3. Book Court");
            System.out.println("4. Release Court");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter sport type (Football, Basketball, Tennis, ...): ");
                    String sportType = scanner.nextLine();
                    Court court = new Court(sportType);
                    admin.addCourt(court);
                    System.out.println("Court added for " + sportType);
                    break;

                case 2:
                    showAllCourts(admin);
                    break;

                case 3:
                    System.out.print("Enter your name: ");
                    String playerName = scanner.nextLine();
                    Player player = new Player(playerName);
                    System.out.print("Enter sport type to book: ");
                    String sportToBook = scanner.nextLine();
                    System.out.print("Enter booking time: ");
                    String bookingTime = scanner.nextLine();
                    Court courtToBook = findCourtBySportType(admin, sportToBook);
                    if (courtToBook != null) {
                        player.bookCourt(courtToBook, bookingTime);
                    } else {
                        System.out.println("Court not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter sport type to release: ");
                    String sportToRelease = scanner.nextLine();
                    Court courtToRelease = findCourtBySportType(admin, sportToRelease);
                    if (courtToRelease != null) {
                        courtToRelease.releaseCourt();
                        System.out.println("Released the " + sportToRelease + " court.");
                    } else {
                        System.out.println("Court not found.");
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting... You exited.");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }

    public static Court findCourtBySportType(Admin admin, String sportType) {
        for (Court c : admin.getCourts()) {
            if (c != null && c.getSportType().equalsIgnoreCase(sportType)) {
                return c;
            }
        }
        return null;
    }

    public static void showAllCourts(Admin admin) {
        System.out.println("--- List of Courts ---");
        Court[] courts = admin.getCourts();
        if (courts.length == 0) {
            System.out.println("No courts available.");
        } else {
            for (Court c : courts) {
                if (c != null) {
                    System.out.println("Sport Type: " + c.getSportType() + " | Available: " + (c.isAvailable() ? "Yes" : "No"));
                }
            }
        }
    }
}