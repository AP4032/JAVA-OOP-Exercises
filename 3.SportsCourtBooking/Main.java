import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        Scanner sc = new Scanner(System.in);
        Court basketball = new Court("BASKETBALL");
        admin.courtMap.put("BASKETBALL", basketball);
        Court tennis = new Court("TENNIS");
        admin.courtMap.put("TENNIS", tennis);
        Court football = new Court("FOOTBALL");
        admin.courtMap.put("FOOTBALL", football);
        System.out.println("<<< WELLCOME TO BOOKING COURTS SITE >>> ");
        while(true){
            System.out.println();
            System.out.println("1. booking courts...");
            System.out.println("2. unbooking courts...");
            System.out.println("3. available courts...");
            System.out.println("4. exit!  ");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();
            switch (choice){
                case "1":
                    System.out.print("Please enter your name: ");
                    String name = sc.nextLine();
                    Player p = new Player(name);
                    System.out.print("Please enter the court name: ");
                    String courtName = sc.nextLine();
                    if(admin.checkcourtmap(courtName)){
                        p.bookcourt(admin.courtMap.get(courtName));
                        admin.removebook(admin.courtMap.get(courtName).name());
                        break;
                    }
                    else
                        System.out.println("Invalid court name!");
                    break;
                    case "2":
                        System.out.print("Please enter the court name: ");
                        String surname = sc.nextLine();
                        if(admin.checkcourtmap(surname)){
                            admin.addbook(admin.courtMap.get(surname).name());
                            System.out.println(admin.courtMap.get(surname).name()+" has been unbooked!");
                            break;
                        }
                        else
                            System.out.println("Invalid court name!");
                        break;
                        case "3":
                            admin.show();
                            break;
                            case "4":
                                System.out.println("HAVE A GOOD DAY!!!");
                                System.exit(0);
                                break;
            }
        }
    }
}
