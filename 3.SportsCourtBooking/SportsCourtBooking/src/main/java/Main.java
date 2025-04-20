import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();

        System.out.println(" Welcome to the Sports Court Booking System ");

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Court");
            System.out.println("2. Show All Courts");
            System.out.println("3. Find Available Courts");
            System.out.println("4. Book a Court");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter sport type : ");
                    String type = scanner.nextLine();
                    Court court = new Court(type);
                    admin.addCourt(court);
                    break;

                case 2:
                    List<Court> allCourts = admin.getAllCourts();
                    if (allCourts.isEmpty()) {
                        System.out.println("No courts available.");
                    } else {
                        System.out.println(" All Courts:");
                        for (Court c : allCourts) {
                            System.out.println("ID: " + c.getCourtId() + " | Type: " + c.getSportType());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter sport type: ");
                    String sport = scanner.nextLine();
                    System.out.print("Start time (yyyy-MM-dd HH:mm): ");
                    LocalDateTime start = LocalDateTime.parse(scanner.nextLine().replace(" ", "T"));
                    System.out.print("End time (yyyy-MM-dd HH:mm): ");
                    LocalDateTime end = LocalDateTime.parse(scanner.nextLine().replace(" ", "T"));

                    List<Court> availableCourts = admin.findAvailableCourts(sport, start, end);
                    if (availableCourts.isEmpty()) {
                        System.out.println(" No available courts for that time.");
                    } else {
                        System.out.println(" Available Courts:");
                        for (Court availableCourt : availableCourts) {
                            System.out.println("ID: " + availableCourt.getCourtId() + " | Type: " + availableCourt.getSportType());
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    Player player = new Player(name);

                    System.out.print("Enter court ID: ");
                    int courtId = scanner.nextInt();
                    scanner.nextLine();

                    Court selectedCourt = null;
                    for (Court c : admin.getAllCourts()) {
                        if (c.getCourtId() == courtId) {
                            selectedCourt = c;
                            break;
                        }
                    }

                    if (selectedCourt == null) {
                        System.out.println(" Court not found.");
                        break;
                    }

                    System.out.print("Start time (yyyy-MM-dd HH:mm): ");
                    LocalDateTime bookingStart = LocalDateTime.parse(scanner.nextLine().replace(" ", "T"));
                    System.out.print("End time (yyyy-MM-dd HH:mm): ");
                    LocalDateTime bookingEnd = LocalDateTime.parse(scanner.nextLine().replace(" ", "T"));

                    player.bookCourt(selectedCourt, bookingStart, bookingEnd);
                    break;

                case 5:
                    System.out.println(" Exiting the system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println(" Invalid option. Please try again.");
            }
        }
    }
}
