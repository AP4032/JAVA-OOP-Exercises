import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);
        Admin admin = new Admin();
        System.out.println("Enter your name:");
        String name = stringScanner.nextLine();
        Player player = new Player(name);
        while (true) {
            System.out.println(player.getName() + ", select an option:\n1.add court\n2.remove court\n3.list courts\n4.book court\n5.exit\n");
            int option = intScanner.nextInt();
            String courtName;
            switch (option) {
                case 1:
                    System.out.println("Enter court name:");
                    courtName = stringScanner.nextLine();
                    admin.addCourt(courtName);
                    break;
                case 2:
                    System.out.println("Enter court name:");
                    courtName = stringScanner.nextLine();
                    admin.removeCourt(courtName);
                    break;
                case 3:
                    admin.listCourts();
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Enter court name:");
                    courtName = stringScanner.nextLine();
                    player.bookCourt(courtName);
                    break;
                case 5:
                    System.exit(0);

            }
        }
    }
}
