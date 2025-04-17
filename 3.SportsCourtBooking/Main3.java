import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner numScanner = new Scanner(System.in);
        Scanner strScanner = new Scanner(System.in);
        Admin3 admin = new Admin3();

        System.out.println("=== Sports Court Booking ===");

        boolean running = true;
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add Court");
            System.out.println("2. Add Player");
            System.out.println("3. Book Court");
            System.out.println("4. Release Court");
            System.out.println("5. Show All Courts");
            System.out.println("6. Show All Players");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = numScanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Court Name: ");
                    String courtName = strScanner.nextLine();
                    Court court = new Court(courtName);
                    admin.addCourt(court);
                    break;

                case 2:
                    System.out.print("Enter Player Name: ");
                    String playerName = strScanner.nextLine();
                    Player3 player = new Player3(playerName);
                    admin.addPlayer(player);
                    System.out.println("Player created with ID: " + player.getPlayerID());
                    break;

                case 3:
                    String[] courtsB = new String[admin.getCourts().size()];
                    for (int i = 0; i < admin.getCourts().size(); i++) {
                        courtsB[i] = admin.getCourts().get(i).getSportType();
                    }
                    System.out.print("Enter Player ID: ");
                    int playerBID = numScanner.nextInt();
                    System.out.print("Enter Court Name: ");
                    String courtBook = strScanner.nextLine();
                    int courtBIndex = 0;
                    for (int i = 0; i < admin.getCourts().size(); i++) {
                        if (courtsB[i].equalsIgnoreCase(courtBook)) {
                            courtBIndex = i;
                        }
                    }
                    Player3 playerBook = findPlayerById(admin, playerBID);
                    if (playerBook != null) {
                        int temp = 0;
                        for (Court c: admin.getCourts()) {
                            if (courtBook.equalsIgnoreCase(c.getSportType())) {
                                temp++;
                            }
                        }
                        if (temp != 0) {
                            playerBook.bookCourt(admin.getCourts().get(courtBIndex));
                        }
                        else {
                            System.out.println("There is no court with the sport type " + courtBook);
                        }
                    } else {
                        System.out.println("Player not found with ID: " + playerBID);
                    }
                    break;

                case 4:
                    String[] courtsR = new String[admin.getCourts().size()];
                    for (int i = 0; i < admin.getCourts().size(); i++) {
                        courtsR[i] = admin.getCourts().get(i).getSportType();
                    }
                    System.out.print("Enter Court Name: ");
                    String courtRelease = strScanner.nextLine();
                    int courtRIndex = 0;
                    for (int i = 0; i < admin.getCourts().size(); i++) {
                        if (courtsR[i].equalsIgnoreCase(courtRelease)) {
                            courtRIndex = i;
                        }
                    }
                    int temp = 0;
                    for (Court cR: admin.getCourts()) {
                        if (courtRelease.equalsIgnoreCase(cR.getSportType())) {
                            temp++;
                        }
                    }
                    if (temp != 0) {
                        if (admin.getCourts().get(courtRIndex).isAvailable()) {
                            System.out.println("This court is available.");
                        } else {
                            admin.getCourts().get(courtRIndex).releaseCourt();
                        }
                    }
                    else {
                        System.out.println("There is no court with the sport type " + courtRelease);
                    }
                    break;

                case 5:
                    showAllCourts(admin);
                    break;


                case 6:
                    showAllPlayers(admin);
                    break;


                case 7:
                    running = false;
                    System.out.println("Exiting...See you next time!");
                    break;


                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        numScanner.close();
        strScanner.close();
    }

    public static Player3 findPlayerById(Admin3 admin, int PlayerId) {
        for (Player3 p : admin.getPlayers()) {
            if (p.getPlayerID() == PlayerId) {
                return p;
            }
        }
        return null;
    }

    public static void showAllCourts(Admin3 admin) {
        System.out.println("--- List of Courts ---");
        if (admin.getCourts().isEmpty()) {
            System.out.println("No Courts Found");
        } else {
            for (Court court : admin.getCourts()) {
                if (court.isAvailable()) {
                    System.out.println(court.getSportType() + ": Available");
                } else {
                    System.out.println(court.getSportType() + ": Booked");
                }
            }
        }
    }

    public static void showAllPlayers(Admin3 admin) {
        System.out.println("--- List of Players ---");
        if (admin.getPlayers().isEmpty()) {
            System.out.println("No Players Found");
        } else {
            for (Player3 p : admin.getPlayers()) {
                System.out.println("Name: " + p.getName() + " | ID: " + p.getPlayerID());
            }
        }
    }
}