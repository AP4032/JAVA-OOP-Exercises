import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Ride> rides = new ArrayList<>();
        ArrayList<Visitor> queue = new ArrayList<>();
        Admin admin = new Admin();

        rides.add(new Ride("Roller Coaster", 3, 5));
        rides.add(new Ride("Ferris Wheel", 2, 4));

        boolean running = true;

        while (running) {
            System.out.println("\n--- Theme Park Menu ---");
            System.out.println("1. Add Visitor");
            System.out.println("2. Start Ride");
            System.out.println("3. Add Ride (Admin)");
            System.out.println("4. Remove Ride (Admin)");
            System.out.println("5. Show Queue");
            System.out.println("6. Show Rides");
            System.out.println("7. Exit");
            System.out.print("Choose: ");

            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter name: ");
                    String name = input.nextLine();
                    System.out.print("VIP? (yes/no): ");
                    String vip = input.nextLine();

                    Visitor visitor;
                    if (vip.equalsIgnoreCase("yes")) {
                        visitor = new VIPVisitor(name);
                        queue.add(0, visitor);
                    } else {
                        visitor = new Visitor(name);
                        queue.add(visitor);
                    }

                    System.out.println("Visitor added: " + visitor.getName());
                    break;

                case "2":
                    if (rides.isEmpty()) {
                        System.out.println("No rides available.");
                        break;
                    }

                    for (int i = 0; i < rides.size(); i++) {
                        System.out.println((i + 1) + ". " + rides.get(i).getName());
                    }

                    System.out.print("Choose ride number: ");
                    int rideIndex = Integer.parseInt(input.nextLine()) - 1;

                    if (rideIndex < 0 || rideIndex >= rides.size()) {
                        System.out.println("Invalid ride number.");
                        break;
                    }

                    Ride ride = rides.get(rideIndex);
                    ride.fillFromQueue(queue);
                    ride.start();
                    break;

                case "3":
                    System.out.print("Ride name: ");
                    String rName = input.nextLine();
                    System.out.print("Capacity: ");
                    int cap = Integer.parseInt(input.nextLine());
                    System.out.print("Duration: ");
                    int dur = Integer.parseInt(input.nextLine());

                    admin.addRide(rides, new Ride(rName, cap, dur));
                    break;

                case "4":
                    System.out.print("Ride name to remove: ");
                    String remName = input.nextLine();
                    admin.removeRide(rides, remName);
                    break;

                case "5":
                    System.out.println("Queue:");
                    for (Visitor v : queue) {
                        String type = v.isVIP() ? "[VIP]" : "[Regular]";
                        System.out.println(type + " " + v.getName());
                    }
                    break;

                case "6":
                    admin.showAllRides(rides);
                    break;

                case "7":
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}