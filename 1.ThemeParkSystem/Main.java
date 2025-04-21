package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
        Admin admin = new Admin();
        System.out.println("Welcome to Park");
        while (true) {
            System.out.println("Please enter your choice\n" +
                    "1- Add ride\n" +
                    "2- Remove ride\n" +
                    "3- Add visitors\n" +
                    "4- View visitors\n" +
                    "5- Add visitor to ride\n" +
                    "6- Ride information\n" +
                    "7- Exit");
            int choice = validInput(in,1,7);

            switch (choice) {
                case 1:
                    admin.addRide();
                    break;

                case 2:
                    if (admin.getRidesCount() <= 0) {
                        System.out.println("There are no rides available");
                    } else {
                        System.out.println("Which ride do you want to remove?");
                        admin.showRides();
                        int rideIndex = in.nextInt() - 1;
                        admin.removeByIndex(rideIndex);
                    }
                    break;

                case 3:
                    Visitor.AddVisitor();
                    break;

                case 4:
                    Visitor.showVisitors();
                    break;

                case 5:
                    if (admin.getRidesCount() <= 0) {
                        System.out.println("There are no rides available");
                    } else {
                        System.out.println("Select a ride to add visitor:");
                        admin.showRides();
                        int ride = in.nextInt() - 1;
                        in.nextLine();
                        List<Ride> rides = admin.getRides();
                        if (ride >= 0 && ride < rides.size()) {
                            Ride selected = rides.get(ride);
                            System.out.println("You selected ride: " + selected.getName());
                            System.out.println("Select visitor type:\n1- Regular\n2- VIP");
                            int visitorType = in.nextInt();
                            in.nextLine();

                            if (visitorType == 1 && !Visitor.getVisitors().isEmpty()) {
                                Visitor.showRegularVisitors();
                                System.out.print("Enter visitor index: ");
                                int index = in.nextInt() - 1;
                                if (index >= 0 && index < Visitor.getVisitors().size()) {
                                    Visitor visitor = Visitor.getVisitors().get(index);
                                    visitor.addVisitorToRide(selected);
                                } else {
                                    System.out.println("Invalid index.");
                                }

                            } else if (visitorType == 2 && !Visitor.getVipVisitors().isEmpty()) {
                                Visitor.showVipVisitors();
                                System.out.print("Enter VIP visitor index: ");
                                int index = in.nextInt() - 1;
                                if (index >= 0 && index < Visitor.getVipVisitors().size()) {
                                    VipVisitor vipVisitor = Visitor.getVipVisitors().get(index);
                                    vipVisitor.addVisitorToRide(selected);
                                } else {
                                    System.out.println("Invalid index.");
                                }

                            } else {
                                System.out.println("No visitors available in selected type.");
                            }

                        } else {
                            System.out.println("Invalid ride choice entered");
                        }
                    }
                    break;

                case 6:
                    admin.printDetails();
                    break;

                case 7:
                    System.out.println("Exiting program .....");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    public static int validInput(Scanner input, int min, int max) {
        int choice;
        while (true) {
            while (!input.hasNextInt()) {
                System.out.println("Invalid choice, please try again:");
                input.nextLine();

            }

            choice = input.nextInt();

            if (choice >= min && choice <= max) {
                return choice;
            } else if(max==min){
                System.out.println("Invalid input try again");
            } else {
                System.out.println("Enter a number between " + min + " and " + max);
            }

        }
    }
}
