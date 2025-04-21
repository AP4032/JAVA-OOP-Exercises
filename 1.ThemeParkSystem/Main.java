import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();

        
        while (true) {
            System.out.println("\n=== Theme Park System ===");
            System.out.println("1. Add Ride");
            System.out.println("2. Add Visitor to Ride");
            System.out.println("3. Start All Rides");
            System.out.println("4. Remove Ride");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

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
                    Ride ride = new Ride(rideName, capacity, duration);
                    admin.addRide(ride);
                    break;

                case 2:
                    if (admin.getRides().isEmpty()) {
                        System.out.println("No rides available.");
                        break;
                    }
                    System.out.println("Available Rides:");
                    for (int i = 0; i < admin.getRides().size(); i++) {
                        System.out.println((i + 1) + ". " + admin.getRides().get(i).getName());
                    }
                    System.out.print("Choose ride number: ");
                    int rideIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (rideIndex < 0 || rideIndex >= admin.getRides().size()) {
                        System.out.println("Invalid ride selection.");
                        break;
                    }

                    System.out.print("Enter visitor name: ");
                    String visitorName = scanner.nextLine();
                    System.out.print("Is VIP? (yes/no): ");
                    String vipInput = scanner.nextLine().trim().toLowerCase();
                    Visitor visitor = vipInput.equals("yes")
                            ? new VIPVisitor(visitorName)
                            : new Visitor(visitorName);
                    admin.getRides().get(rideIndex).addVisitor(visitor);
                    break;

                case 3:
                    for (Ride r : admin.getRides()) {
                        r.startRide();
                    }
                    break;

                case 4:
                    System.out.print("Enter ride name to remove: ");
                    String nameToRemove = scanner.nextLine();
                    admin.removeRide(nameToRemove);
                    break;

                case 5:
                    System.out.println("Exiting system...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    public static void showAllRides(Admin admin) {
        System.out.println("--- List of Rides ---");
        if (admin.getRides().isEmpty()) {
            System.out.println("No rides available.");
        } else {
            for (int i = 0; i < admin.getRides().size(); i++) {
                Ride r = admin.getRides().get(i);
                System.out.println((i+1)+". "+r.getName()+" | Capacity: "+r.getCapacity()+" | Duration: "+r.getDuration()+" mins");
            }
        }
    }
}
