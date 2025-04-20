import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin("admin");


        while (true) {

            System.out.println("\n=========================");
            System.out.println("Theme Park Management System");
            System.out.println("=========================");
            System.out.println("1. Add a new ride");
            System.out.println("2. Remove a ride");
            System.out.println("3. List all rides");
            System.out.println("4. Add a visitor to a ride");
            System.out.println("5. Add a VIP visitor to a ride");
            System.out.println("6. Run a ride");
            System.out.println("7. End a ride");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");


            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ride name: ");
                    String rideName = scanner.nextLine();
                    System.out.print("Enter ride capacity: ");
                    int capacity = scanner.nextInt();
                    System.out.print("Enter ride duration (minutes): ");
                    int duration = scanner.nextInt();
                    scanner.nextLine();

                    Ride newRide = new Ride(rideName, capacity, duration);
                    admin.addRide(newRide);
                    break;

                case 2:
                    System.out.print("Enter ride name to remove: ");
                    String rideToRemove = scanner.nextLine();
                    Ride ride = admin.getRideByName(rideToRemove);
                    if (ride != null) {
                        admin.removeRide(ride);
                    } else {
                        System.out.println("Ride not found.");
                    }
                    break;

                case 3:
                    admin.listRides();
                    break;

                case 4:
                    System.out.print("Enter visitor name: ");
                    String visitorName = scanner.nextLine();
                    Visitor visitor = new Visitor(visitorName);
                    System.out.print("Enter ride name to add visitor to: ");
                    String rideNameForVisitor = scanner.nextLine();
                    Ride rideForVisitor = admin.getRideByName(rideNameForVisitor);
                    if (rideForVisitor != null) {
                        rideForVisitor.addVisitor(visitor);
                    } else {
                        System.out.println("Ride not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter VIP visitor name: ");
                    String vipName = scanner.nextLine();
                    System.out.print("Enter VIP level (GOLD, SILVER, BRONZE): ");
                    String vipLevelStr = scanner.nextLine().toUpperCase();
                    VIPVisitor.Level vipLevel = VIPVisitor.Level.valueOf(vipLevelStr);
                    VIPVisitor vipVisitor = new VIPVisitor(vipName, vipLevel);
                    System.out.print("Enter ride name to add VIP visitor to: ");
                    String rideNameForVIP = scanner.nextLine();
                    Ride rideForVIP = admin.getRideByName(rideNameForVIP);
                    if (rideForVIP != null) {
                        rideForVIP.addVisitor(vipVisitor);
                    } else {
                        System.out.println("Ride not found.");
                    }
                    break;

                case 6:
                    System.out.print("Enter ride name to start: ");
                    String rideNameToStart = scanner.nextLine();
                    Ride rideToStart = admin.getRideByName(rideNameToStart);
                    if (rideToStart != null) {
                        rideToStart.startRide();
                    } else {
                        System.out.println("Ride not found.");
                    }
                    break;

                case 7:
                    System.out.print("Enter ride name to end: ");
                    String rideNameToEnd = scanner.nextLine();
                    Ride rideToEnd = admin.getRideByName(rideNameToEnd);
                    if (rideToEnd != null) {
                        rideToEnd.endRide();
                    } else {
                        System.out.println("Ride not found.");
                    }
                    break;

                case 8:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }
}
