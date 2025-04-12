package main;

import java.util.Scanner;

public class Main {
    public static final String RESET = "\u001B[0m";
    public static final String LIGHT_GRAY = "\u001B[37m";  // Soft neutral gray
    public static final String SOFT_BLUE = "\u001B[94m";    // Soft blue for info
    public static final String MUTED_GREEN = "\u001B[32m"; // Muted green for success

    public static void main(String[] args) throws InterruptedException {
        Scanner strsScanner = new Scanner(System.in);
        Scanner numScanner = new Scanner(System.in);
        Ride RollerCoaster = new Ride("Roller Coaster", 5, 10);
        Ride FerrisWheel = new Ride("Ferris Wheel", 7, 7);
        Ride Pendulum = new Ride("Pendulum", 4, 5);
        Ride Booster = new Ride("Booster", 3, 5);
        Ride Carousel = new Ride("Carousel", 6, 15);
        System.out.println(MUTED_GREEN + "Welcome to the Ol' Betsy's Theme Park!" + RESET);
        for (int i = 0; i < 25; i++) System.out.print("=*");
        while (true) {
            System.out.println(SOFT_BLUE + "\nSelect what you want to do: \n1) add visitor\n2) check the queue\n3) start the ride\n4) exit" + RESET);
            int choice = numScanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(SOFT_BLUE + "select the instrument you want to ride:\n1.Roller Coaster\n2.Ferris Wheel\n3.Pendulum\n4.Booster\n5.Carousel" + RESET);
                    int instrument = numScanner.nextInt();
                    System.out.println(SOFT_BLUE + "Enter your membership type:\n1. regular\n2. VIP" + RESET);
                    int membershipType = numScanner.nextInt();
                    System.out.println(SOFT_BLUE + "Enter your name :" + RESET);
                    String name = strsScanner.nextLine();
                    switch (instrument) {
                        case 1:
                            RollerCoaster.addVisitor(name, membershipType);
                            break;
                        case 2:
                            FerrisWheel.addVisitor(name, membershipType);
                            break;
                        case 3:
                            Pendulum.addVisitor(name, membershipType);
                            break;
                        case 4:
                            Booster.addVisitor(name, membershipType);
                            break;
                        case 5:
                            Carousel.addVisitor(name, membershipType);
                            break;
                    }
                    break;
                case 2:
                    System.out.println(SOFT_BLUE + "Select the instrument of which you want to check the queue:\n1.Roller Coaster\n2.Ferris Wheel\n3.Pendulum\n4.Booster\n5.Carousel" + RESET);
                    choice = numScanner.nextInt();
                    switch (choice) {
                        case 1:
                            RollerCoaster.printQueue();
                            break;
                        case 2:
                            FerrisWheel.printQueue();
                            break;
                        case 3:
                            Pendulum.printQueue();
                            break;
                        case 4:
                            Booster.printQueue();
                            break;
                        case 5:
                            Carousel.printQueue();
                            break;
                    }
                    break;
                case 3:
                    System.out.println(SOFT_BLUE + "Select the instrument with which you want to start riding:\n1.Roller Coaster\n2.Ferris Wheel\n3.Pendulum\n4.Booster\n5.Carousel" + RESET);
                    choice = numScanner.nextInt();
                    switch (choice) {
                        case 1:
                            RollerCoaster.startRide();
                            break;
                        case 2:
                            FerrisWheel.startRide();
                            break;
                        case 3:
                            Pendulum.startRide();
                            break;
                        case 4:
                            Booster.startRide();
                            break;
                        case 5:
                            Carousel.startRide();
                            break;
                    }
                    break;
                case 4:
                    System.out.println(MUTED_GREEN + "Thanks for coming\nSee you soon!" + RESET);
                    System.exit(0);
                    break;
            }
        }
    }
}
