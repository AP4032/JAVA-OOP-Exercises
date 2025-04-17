import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();

        admin.addCourt(new Court("Basketball Court"));
        admin.addCourt(new Court("Tennis Court"));
        admin.addCourt(new Court("Football Court"));
        admin.addCourt(new Court("Badminton Court"));

        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);
        admin.addPlayer(player);

        System.out.println("Welcome " + playerName + "!");

        boolean running = true;

        System.out.println("=== Sports Court Booking System ===");

        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add Court(admin only)");
            System.out.println("2. Remove Court(admin only)");
            System.out.println("3. Show All Courts");
            System.out.println("4. Show All Players");
            System.out.println("5. Book Court");
            System.out.println("6. Show Court Schedule");
            System.out.println("7. Remove Player(admin only)");
            System.out.println("8. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter court name to add: ");
                    String courtNameToAdd = scanner.nextLine();
                    admin.addCourt(new Court(courtNameToAdd));
                    break;

                case 2:
                    System.out.print("Enter court name to remove: ");
                    String courtNameToRemove = scanner.nextLine();
                    Court courtToRemove = findCourtByName(admin, courtNameToRemove);
                    if (courtToRemove != null) {
                        admin.removeCourt(courtToRemove);
                    } else {
                        System.out.println("Court not found.");
                    }
                    break;

                case 3:
                    showAllCourts(admin);
                    break;

                case 4:
                    showAllPlayers(admin);
                    break;
                case 5:
                    System.out.print("Enter court name to book: ");
                    String courtNameToBook = scanner.nextLine();
                    Court courtToBook = findCourtByName(admin, courtNameToBook);

                    if (courtToBook != null) {
                        System.out.print("Enter booking date (yyyy-MM-dd): ");
                        String dateInput = scanner.nextLine();

                        System.out.print("Enter booking time (HH:mm): ");
                        String timeInput = scanner.nextLine();

                        boolean isAvailable = true;

                        for (int i = 0; i < courtToBook.getBookings().size(); i++) {
                            Booking booking = courtToBook.getBookings().get(i);

                            if (booking.getDate().equals(dateInput) && booking.getTime().equals(timeInput)) {
                                isAvailable = false;
                                break;
                            }
                        }


                        if (isAvailable) {
                            player.bookCourt(courtToBook, dateInput, timeInput);
                            makePayment(courtToBook);
                        } else {
                            System.out.println("That time is already booked.");
                        }

                    } else {
                        System.out.println("Court not found.");
                    }
                    break;


                case 6:
                    System.out.print("Enter court name to see schedule: ");
                    String courtScheduleName = scanner.nextLine();
                    Court courtToSchedule = findCourtByName(admin, courtScheduleName);
                    if (courtToSchedule != null) {
                        admin.showingCourtSchedule(courtToSchedule);
                    } else {
                        System.out.println("Court not found.");
                    }
                    break;

                case 7:
                    System.out.print("Enter player name to remove: ");
                    String playerNameToRemove = scanner.nextLine();
                    Player playerToRemove = findPlayerByName(admin, playerNameToRemove);
                    if (playerToRemove != null) {
                        admin.removePlayer(playerToRemove);
                    } else {
                        System.out.println("Player not found.");
                    }
                    break;

                case 8:
                    running = false;
                    System.out.println(" Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }

    public static Court findCourtByName(Admin admin, String courtName) {
        for (Court court : admin.getCourts()) {
            if (court.getCourtName().equalsIgnoreCase(courtName)) {
                return court;
            }
        }
        return null;
    }

    public static Player findPlayerByName(Admin admin, String playerName) {
        for (Player player : admin.getPlayers()) {
            if (player.getName().equalsIgnoreCase(playerName)) {
                return player;
            }
        }
        return null;
    }

    public static void showAllCourts(Admin admin) {
        System.out.println("--- List of Courts ---");
        if (admin.getCourts().isEmpty()) {
            System.out.println("No courts available.");
        } else {
            for (Court court : admin.getCourts()) {
                System.out.println("Court Name: " + court.getCourtName());
            }
        }
    }

    public static void showAllPlayers(Admin admin) {
        System.out.println("--- List of Players ---");
        if (admin.getPlayers().isEmpty()) {
            System.out.println("No players available.");
        } else {
            for (Player player : admin.getPlayers()) {
                System.out.println("Player Name: " + player.getName());
            }
        }
    }

    public static void makePayment(Court court) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("You are paying for: " + court.getCourtName());

        System.out.print("Enter payment amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter payment method (Card, Cash): ");
        String paymentMethod = scanner.nextLine();

        Payment payment = new Payment(amount, paymentMethod);

        if (payment.processingPayment()) {
            System.out.println("Payment successful. Booking confirmed.");
        } else {
            System.out.println("Payment failed. Please try again.");
        }
    }


}
