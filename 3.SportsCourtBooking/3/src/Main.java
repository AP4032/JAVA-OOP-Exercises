import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        boolean end = false;
        Scanner scanner = new Scanner(System.in);


        while (!end) {
            System.out.println("-- Sports Court Booking System \uD83C\uDFC0 --");
            System.out.println("Main Menu");
            System.out.println("1. Add Court");
            System.out.println("2. Show Courts");
            System.out.println("3. book a Court");
            System.out.println("4. cancel Court");
            System.out.println("5. Exit");

            System.out.println("Enter your choice");

            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    System.out.println("enter court name");
                    String courtName = scanner.next();
                    Court court = new Court(courtName);

                    admin.addCourt(court);

                    break;


                case 2:
                    admin.printCourts();
                    break;


                case 3:
                    System.out.println("enter your name");
                    String name = scanner.next();
                    Player player = new Player(name);

                    System.out.println("enter court name");
                    String courtNameT = scanner.next();

                    boolean bye = false;

                    for (Court c : admin.getCourts()) {
                        if( c.getSportType().equals(courtNameT) && (c.isAvailable())) {
                            player.bookCourt(c);
                            bye = true;
                            break;

                        }
                    }
                    if (bye) {
                        break;
                    }
                    System.out.println(" court not found! ");
                    break;

                case 4:

                    System.out.println("enter court name");
                    String cancel = scanner.next();

                    boolean Bye = false;
                    for (Court c : admin.getCourts()) {
                        if (c.getSportType().equals(cancel)) {
                            c.releaseCourt();
                            System.out.println("ok!");
                            Bye = true;
                            break;
                        }
                    }
                    if (Bye) {
                        break;
                    }
                    System.out.println("this court not found!");
                    break;

                case 5:
                    end = true;



            }
        }
    }
}