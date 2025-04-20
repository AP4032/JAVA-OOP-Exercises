import javax.xml.transform.Source;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Scanner inputInt= new Scanner(System.in);
    private static Admin admin= new Admin();
    public static void main(String[] args) {
        System.out.println("********** Welcome to Sports Court Booking System **********");
        mainMenu();
        System.out.println("Bye Bye .....");
    }
    private static void mainMenu(){
        System.out.println("-------* Main Menu *-------");
        System.out.println("1. Create account");
        System.out.println("2. Booking a Court");
        System.out.println("3. Recharge your wallet");
        System.out.println("4. Display your information");
        System.out.println("5. Add Sport court");
        System.out.println("6. Changing the cost of sport court");
        System.out.println("7. show all courts");
        System.out.println("8. Exit");
        System.out.println("Enter your choice:");
        do {
            int choice=Utils.getNum();
            switch (choice) {
                case 1:
                    createAccount();
                    mainMenu();
                    return;
                case 2:
                    bookingCourt();
                    mainMenu();
                    return;
                case 3:
                    rechargeWallet();
                    mainMenu();
                    return;
                case 4:
                    displayInfo();
                    mainMenu();
                    return;
                case 5:
                    addSportCourt();
                    mainMenu();
                    return;
                case 6:
                    changeCost();
                    mainMenu();
                    return;
                case 7:
                    displayAllCourts();
                    mainMenu();
                    return;
                case 8:
                    return;
                default:
                    System.out.println("Invalid choice!, try again");
            }
        }while (true);
    }
    private static void createAccount() {
        System.out.println("********** Creat Account **********");
        System.out.println("Enter your name:");
        Player p=new Player(Utils.getString());
        System.out.println("Your user ID :"+p.getUserID()+" please saved it and don't forget it.");
        System.out.println("Do you want to recharge your wallet? (Y/N)");
        char choice = 0;
        do {
            try {
                choice = scanner.next().toUpperCase().charAt(0);
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
            }
        } while (choice != 'Y' && choice != 'N');
        if (choice == 'Y') {
            System.out.println("How much do you want to top up your wallet? (enter an Integer)");
            int input=Utils.getNum();
            p.setMoney(p.getMoney()+input);
            System.out.println("Successfully recharged your wallet.");
            System.out.println("Now, You have "+p.getMoney()+"$ in your wallet.");
        }
        admin.addPlayer(p);
    }
    private static void bookingCourt() {
        System.out.println("********** Booking Court Booking System **********");
        Player player=Utils.getUserID(admin);
        SportCourt sportCourt = null;
        System.out.println("Name of sport court that exists in the database:");
        int i=1;
        for(SportCourt court : admin.getCourts()){
            System.out.println(i+". "+court.getSportType()+" court ----- cost: "+court.getCost()+"$");
            i++;
        }
        boolean found=false;
        do {
            System.out.println("Enter name of Sport court that you would like to reserve it: ");
            String nameCourt = Utils.getString();
            for (SportCourt court : admin.getCourts()) {
                if (court.getSportType().equals(nameCourt)) {
                    sportCourt=court;
                    found=true;
                    break;
                }
            }
            if(found){
                break;
            }
            System.out.println("This sport court does not exist.");
        }while (true);
        player.bookCourt(sportCourt);
    }
    private static void rechargeWallet() {
        System.out.println("********** Recharge Wallet **********");
        Player player = Utils.getUserID(admin);
        System.out.println("How much do you want to top up your wallet? (enter an Integer)");
        int money=Utils.getNum();
        player.setMoney(player.getMoney()+money);
        System.out.println("Successfully recharged your wallet.");
        System.out.println("Now, You have "+player.getMoney()+"$ in your wallet.");


    }
    private static void displayAllCourts() {
        System.out.println("********** Display all courts **********");
        int i=1;
        if (admin.getCourts().isEmpty()) {
            System.out.println("There are no courts.");
        }
        else {
            for (SportCourt court : admin.getCourts()) {
                System.out.print(i+". "+court.getSportType());
                System.out.print("  ---- cost: "+court.getCost()+"$");
                if(court.isAvailable()){
                    System.out.println("  ---- is available .");
                }
                else{
                    System.out.println("---- is not available .");
                }
                i++;
            }
        }
        System.out.println("*******************************************");
    }
    private static void displayInfo(){
        System.out.println("********** Display your info **********");
        Player player = Utils.getUserID(admin);
        System.out.println("-----------------------------------------");
        System.out.println("Your name: "+player.getName());
        System.out.println("Your money: "+player.getMoney()+"$");
        System.out.println("Your user ID: "+player.getUserID());
        if(player.getReservedCourt()!=null){
            System.out.println("Your reserved court: "+player.getReservedCourt().getSportType());
        }
        else {
            System.out.println("Your reserved court: You haven't made a reservation at the sport court yet.");
        }
        System.out.println("-------------------------------------------");
    }
    private static void addSportCourt() {
        System.out.println("********** Add sport court **********");
        System.out.println("Enter name of sport court:");
        String name=Utils.getString();
        System.out.println("Enter the cost of sport court:");
        int cost=Utils.getNum();
        SportCourt sportCourt = new SportCourt(name, cost);
        admin.addCourt(sportCourt);
        System.out.println("Successfully added sport court.");
    }
    private static void changeCost(){
        System.out.println("********** Change cost **********");
        if (admin.getCourts().isEmpty()) {
            System.out.println("There are no courts.");
            return;
        }
        System.out.println("Name of sport court that exists in the database:");
        int i=1;
        for(SportCourt court : admin.getCourts()){
            System.out.println(i+". "+court.getSportType()+" court ----- cost: "+court.getCost()+"$");
            i++;
        }
        System.out.println("Enter name of sport court that you want to change its cost:");
        String name=Utils.getString();
        boolean found = false;
        for (SportCourt court : admin.getCourts()) {
            if (court.getSportType().equals(name)) {
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println( name + " not found,try again.");
            changeCost();
        }
        System.out.println("Enter the cost of sport court:");
        int cost=Utils.getNum();
        admin.changeCost(name, cost);

    }
}