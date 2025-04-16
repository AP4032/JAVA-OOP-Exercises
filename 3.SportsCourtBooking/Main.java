import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner numScanner = new Scanner(System.in);
        Scanner strScanner = new Scanner(System.in);
        Admin admin = new Admin();

        System.out.println("*** Sports Court Booking ***");
        boolean run = true;
        while (run){
            System.out.println("---Main Menu---");
            System.out.println("1. Add Court.");
            System.out.println("2. Remove Courts.");
            System.out.println("3. Add Player.");
            System.out.println("4. Show All Available Courts.");
            System.out.println("5. Show All Player name.");
            System.out.println("6. Book the court.");
            System.out.println("7. Show All Booked Courts.");
            System.out.println("8. Release Court.");
            System.out.println("9. Exit.");

            System.out.print("Choose an option: ");
            int choice = numScanner.nextInt();

            switch (choice){
                case 1 :
                    System.out.println("Enter court name :");
                    String courtName = strScanner.nextLine();
                    Court court = new Court(courtName);
                    admin.addCourt(court);
                    break;
                case 2 :
                    System.out.println("Enter court name :");
                    String courtName1 = strScanner.nextLine();
                    Court court1 = findCourt(admin,courtName1);
                    if(court1 != null){
                        admin.removeCourt(court1);
                    }else{
                        System.out.println("Court not found!");
                    }
                    break;
                case 3 :
                    System.out.println("Enter player name :");
                    String playerName = strScanner.nextLine();
                    Player player = new Player(playerName);
                    admin.addPlayer(player);
                    break;
                case 4 :
                    System.out.println("Available Courts :");
                    for(Court c : admin.getCourts()){
                        if(c.isAvailable()){
                            System.out.println(c.getSportType());
                        }
                    }
                    break;
                case 5 :
                    System.out.println("Names of the players :");
                    for(Player p : admin.getPlayers()) {
                        System.out.println(p.getName());
                    }
                    break;
                case 6 :
                    System.out.println("Enter player name :");
                    String playerName1 = strScanner.nextLine();
                    Player player1 = findPlayer(admin,playerName1);
                    if(player1 != null) {
                        System.out.println("Enter court name :");
                        String courtName2 = strScanner.nextLine();
                        Court court2 = findCourt(admin,courtName2);
                        if(court2 != null){
                            player1.bookCourt(court2);
                        }else{
                            System.out.println("Court not found!");
                        }
                    }else{
                        System.out.println("Player not found!");
                    }
                    break;
                case 7 :
                    System.out.println("Booked courts :");
                    for(Court c : admin.getCourts()){
                        if(!(c.isAvailable())){
                            System.out.println(c.getSportType());
                        }
                    }
                    break;
                case 8 :
                    System.out.println("Enter court name :");
                    String courtName2 = strScanner.nextLine();
                    Court court2 = findACourt(admin,courtName2);
                    if(court2 != null){
                        if(court2.isAvailable()){
                            System.out.println("Court is already release!");
                        }else{
                            court2.releaseCourt();
                        }
                    }else{
                        System.out.println("Court not found!");
                    }
                    break;
                case 9 :
                    run = false;
                    System.out.println("Goodbye!");
                    break;
                default :
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
    public static Court findCourt(Admin admin,String name){
        for(Court c : admin.getCourts()){
            if (name.equals(c.getSportType()) && c.isAvailable()){
                return c;
            }
        }
        return null;
    }
    public static Court findACourt(Admin admin,String name) {
        for (Court c : admin.getCourts()) {
            if (name.equals(c.getSportType())) {
                return c;
            }
        }
        return null;
    }
    public static Player findPlayer(Admin admin,String name){
        for(Player p : admin.getPlayers()){
            if(name.equals(p.getName())){
                return p;
            }
        }
        return null;
    }
}
