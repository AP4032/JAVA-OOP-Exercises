
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        System.out.println("*****Menu*****");
        System.out.println("1.Book a court");
        System.out.println("2.Add a court");

        System.out.println("3.Exit");
        System.out.print("Enter your choice:");


        int number = scanner.nextInt();
        scanner.nextLine();
        switch (number) {
            case 1:
                System.out.println(" Available Courts:");
                List<Court> courts = admin.getCourts();

                if (courts.isEmpty()) {
                    System.out.println("courts  is not available");
                    break;
                }

                for (int i = 0; i < courts.size(); i++) {
                    System.out.println((i + 1) + ". " + courts.get(i).getSportType() +
                            " (Available: " + (courts.get(i).isAvailable() ? "Yes" : "No") + ")" +
                            " | Price per hour: $" + courts.get(i).getReservationPrice());
                }

                System.out.print("Enter the number of the court you want to book: ");
                int courtNumber = scanner.nextInt();
                scanner.nextLine();

                if (courtNumber < 1 || courtNumber > courts.size()) {
                    System.out.println(" Invalid selection!");
                    break;
                }

                Court selectedCourt = courts.get(courtNumber - 1);

                if (!selectedCourt.isAvailable()) {
                    System.out.println(" This court is already booked!");
                    break;
                }

                System.out.print("Enter player name: ");
                String playerName = scanner.nextLine();

                System.out.print("Enter duration (hours): ");
                int duration = scanner.nextInt();

                Player player = new Player(playerName);
                player.bookCourt(selectedCourt, duration);

                break;


            case 2:
                System.out.print("Enter new court type: ");
                String newCourtType = scanner.nextLine();
                admin.getCourts().add(new Court(newCourtType));
                System.out.println(" Added new " + newCourtType + " court.");
                break;

            case 3:
                System.out.println("Exiting....");
                return;
            default:
                System.out.println("Not found! Try again.");


        }
    }
}
