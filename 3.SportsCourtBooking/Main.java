import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String Red = "\033[31m";
        String Green = "\033[32m";
        String Reset = "\033[0m";
        Scanner input = new Scanner(System.in);
        Admin admin = new Admin();
        Court Tennis = new Court("Tennis");
        Court Volleyball = new Court("Volleyball");
        Court Football = new Court("Football");
        Court Hockey = new Court("Hockey");
        Court Futsal = new Court("Futsal");
        Court Basketball = new Court("Basketball");
        admin.AddCourt(Tennis);
        admin.AddCourt(Volleyball);
        admin.AddCourt(Football);
        admin.AddCourt(Hockey);
        admin.AddCourt(Futsal);
        admin.AddCourt(Basketball);
        System.out.println("\033[31m███    ███\033[34m ██   ██    ");
        System.out.println("\033[31m████  ████\033[34m ██   ██    ");
        System.out.println("\033[31m██ ████ ██\033[34m ███████    ");
        System.out.println("\033[31m██  ██  ██\033[34m ██   ██    ");
        System.out.println("\033[31m██      ██\033[34m ██   ██    \033[0m");
        while (true) {
            System.out.println("Please select one of the following options to work with the system:");
            System.out.println("1. Field reservation");
            System.out.println("2. Field availability");
            System.out.println("3. Field cancellation");
            System.out.println("4.Registration");
            System.out.println("5. Exit");
            String choice = input.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("please enter your name:");
                    String Name = input.nextLine();
                    if (admin.FindName(Name)) {
                        System.out.println(Green + "You have successfully logged in." + Reset);
                        Player booker = admin.SetPlayer(Name);
                        admin.GetListCourt();
                        int Choice = input.nextInt();
                        if (admin.reserveCourt(Choice)) {
                            booker.reserveCourt(admin, Choice);
                        } else {
                            System.out.println(Red + "Sorry, reserve  failed." + Reset);
                        }
                    } else {
                        System.out.println(Red + "Sorry, your name is not in the registration list, please register" + Reset);
                    }
                    break;
                case "2":
                    admin.GetAvaliable();
                    break;
                case "3":
                    System.out.println("please enter your name:");
                    String NameCancel = input.nextLine();
                    if (admin.FindName(NameCancel)) {
                        System.out.println(Green + "You have successfully logged in." + Reset);
                        Player Canceller = admin.SetPlayer(NameCancel);
                        Canceller.GetListCourt();
                        int Choice = input.nextInt();
                        if (admin.CancellCourt(Choice)) {
                            Canceller.CancellCourt(admin, Choice);
                        }
                    } else {
                        System.out.println(Red + "Sorry, your name is not in the registration list, please register" + Reset);
                    }
                    break;
                case "4":
                    System.out.println("please enter  your name: ");
                    String name = input.nextLine();
                    Player player = new Player(name);
                    admin.AddPlayer(player);
                    System.out.println(Green + name + " You have successfully registered" + Reset);
                    break;
                case "5":
                    System.out.println(Green + "thanks for choosing" + Reset);
                    System.exit(0);
                    break;
                default:
                    System.out.println(Red + "Invalid choice. try again." + Reset);
                    break;
            }
        }


    }
}