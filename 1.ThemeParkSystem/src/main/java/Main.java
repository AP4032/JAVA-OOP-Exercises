//Aria Razavi

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Admin admin = new Admin();


		System.out.println("👨‍💼 Admin: Adding rides");

		for (int i = 0; i < 3; i++) {
			System.out.println("Ride " + (i + 1) + ":");
			System.out.print("Enter name: ");
			String name = scanner.nextLine();
			System.out.print("Enter duration (minutes): ");
			int duration = scanner.nextInt();
			System.out.print("Enter capacity: ");
			int capacity = scanner.nextInt();
			scanner.nextLine(); 
			
			Ride ride = new Ride(name, duration, capacity);
			admin.addRide(ride);
		}


		ArrayList<Ride> rides = admin.getRides();

		System.out.print("\n👥 How many visitors are there? ");
		int visitorCount = scanner.nextInt();
		scanner.nextLine();


		for (int i = 0; i < visitorCount; i++) {
			System.out.println("\n👤 Visitor " + (i + 1) + ":");

			System.out.print("Enter name: ");
			String name = scanner.nextLine();
			System.out.print("Enter height (cm): ");
			int height = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Are you VIP? (yes/no): ");
			String isVIP = scanner.nextLine();


			System.out.println("🎢 Available Rides:");
			for (int j = 0; j < rides.size(); j++) {
				System.out.println((j + 1) + ". " + rides.get(j).getName());
			}

			System.out.print("Choose a ride (1-" + rides.size() + "): ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			Ride selectedRide = rides.get(choice - 1);


			if (isVIP.equalsIgnoreCase("yes")) {
				VIPVisitor vip = new VIPVisitor(name, height);
				vip.joinQueue(selectedRide);
			} else {
				Visitor visitor = new Visitor(name, height);
				visitor.joinQueue(selectedRide);
			}
		}

		
		System.out.println("\n🎬 Starting rides...");
		for (Ride ride : rides) {
			ride.startRide();
		}

		scanner.close();
	}
}