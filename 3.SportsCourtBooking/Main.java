import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();

        System.out.println("=== Sports Court Booking System ===");
        boolean running = true;
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add Player");
            System.out.println("2. Add Court");
            System.out.println("3. Book Court");
            System.out.println("4. Show Booked Courts");

            System.out.println("5. Exit");
            System.out.println("6. Show All Players");
            System.out.println("7. Show All Courts");
            System.out.println("8. Remove Player");
            System.out.println("9. Remove Court");
            System.out.println("10. give Court");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter player name: ");
                    String playerName = scanner.nextLine();
                    Player player = new Player(playerName);
                    admin.addPlayer(player);
                    System.out.println("Player created with ID: " + player.getId());
                    break;

                case 2:
                    System.out.print("Enter court name: ");
                    String courtName = scanner.nextLine();
                    Court court = new Court(courtName);
                    admin.addCourt(court);
                    break;

                case 3:
                    System.out.print("Enter player ID: ");
                    int playerId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter court name: ");
                    String bookC = scanner.nextLine();
                    Court foundCourt = findCourtByName(admin, bookC);
                    Player foundPlayer = findPlayerById(admin, playerId);

                    if (foundCourt != null && foundPlayer != null) {
                        if (foundCourt.isAvailable()) {
                            foundCourt.bookCourt();
                            admin.addToBookingList(foundCourt.getSportType(), foundPlayer.getName());
                            System.out.println("Court booked: " + bookC + " for : " + findPlayerById(admin, playerId).getName());
                        } else {
                            System.out.println("Court is not available");
                        }

                    } else if (foundCourt != null) {
                        System.out.println("Court not found.");
                    } else if (foundPlayer != null) {
                        System.out.println("Player not found.");
                    }
                    break;

                case 4:
                    if (!allCourtsBooked(admin)) {
                        System.out.println("All Courts available.");
                    } else {
                        admin.getBookingList();
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting... Goodbye!");
                    break;

                case 6:
                    showAllPlayers(admin);
                    break;

                case 7:
                    showAllCourts(admin);
                    break;


                case 8:
                    System.out.print("Enter player id: ");
                    int playerIdToRemove = scanner.nextInt();
                    Player playerForRemove = findPlayerById(admin, playerIdToRemove);
                    if (playerForRemove != null) {
                        admin.removePlayer(playerForRemove);
                    } else {
                        System.out.println("Player not found.");
                    }
                    break;

                case 9:
                    System.out.print("Enter court name: ");
                    String courtNameToRemove = scanner.nextLine();
                    Court courtForRemove = findCourtByName(admin, courtNameToRemove);
                    if (courtForRemove != null) {
                        admin.removeCourt(courtForRemove);
                    } else {
                        System.out.println("Court not found.");
                    }
                    break;

                    case 10:
                        System.out.print("Enter player ID: ");
                        int pId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter court name: ");
                        String giveCourt = scanner.nextLine();
                        Court foundCourtToGive = findCourtByName(admin, giveCourt);
                        Player foundP = findPlayerById(admin, pId);

                        if (foundCourtToGive != null && foundP != null) {
                            if (!foundCourtToGive.isAvailable()) {
                                foundCourtToGive.bookCourt();
                                admin.removeFromBookingList(foundCourtToGive.getSportType(), foundP.getName());
                                System.out.println("Court is available now!");
                            } else {
                                System.out.println("Court is available");
                            }

                        } else if (foundCourtToGive != null) {
                            System.out.println("Court not found.");
                        } else if (foundP != null) {
                            System.out.println("Player not found.");
                        }
                        break;


                default:
                    System.out.println("Invalid option. Try again.");

            }
        }

    }

    public static Court findCourtByName(Admin admin, String courtName) {
        for (Court court : admin.getCourts()) {
            if (court.getSportType().equals(courtName)) {
                return court;
            }
        }
        return null;
    }

    public static Player findPlayerById(Admin admin, int id) {
        for (Player p : admin.getPlayers()) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public static boolean allCourtsBooked(Admin admin) {
        for (Court c : admin.getCourts()) {
            if (c.isAvailable()) {
                return false;
            }
        }
        return true;
    }

    public static void showAllPlayers(Admin admin) {
        for (Player p : admin.getPlayers()) {
            System.out.println(p.getId() + ". " + p.getName());
        }
    }

    public static void showAllCourts(Admin admin) {
        for (Court c : admin.getCourts()) {
            System.out.println(c.getSportType());
        }
    }

}