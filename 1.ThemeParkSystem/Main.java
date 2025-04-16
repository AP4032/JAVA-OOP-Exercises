import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner numScanner = new Scanner(System.in);
        Scanner strScanner = new Scanner(System.in);
        Admin admin = new Admin();

        System.out.println("~~~ Park Management System ~~~");
        boolean run = true;

        while (run){
            System.out.println("~~ Main Menu ~~");
            System.out.println("1. Add Ride.");
            System.out.println("2. Add Visitor.");
            System.out.println("3. Add VIPVisitor.");
            System.out.println("4. Start Ride.");
            System.out.println("5. Show All Rides.");
            System.out.println("6. Exit.");

            System.out.print("Choose an option: ");
            int choice = numScanner.nextInt();

            switch (choice) {
                case 1 :
                    System.out.println("Enter Ride Name:");
                    String rideName = strScanner.nextLine();
                    System.out.println("Enter Ride Capacity:");
                    int rideCapacity = numScanner.nextInt();
                    System.out.println("Enter Ride Duration:");
                    int rideDuration = numScanner.nextInt();
                    Ride ride = new Ride(rideName,rideCapacity,rideDuration);
                    admin.addRide(ride);
                    break;
                case 2 :
                    System.out.println("Enter Visitor Name:");
                    String visitorName = strScanner.nextLine();
                    Visitor visitor = new Visitor(visitorName);
                    System.out.println("Enter Ride name:");
                    String rName = strScanner.nextLine();
                    Ride ride1 = findRide(admin,rName);
                    if( ride1 != null ){
                        ride1.addVisitor(visitor);
                    }else{
                        System.out.println("Ride not found!");
                    }
                    break;
                case 3 :
                    System.out.println("Enter VIPVisitor Name:");
                    String VIPVisitorName = strScanner.nextLine();
                    VIPVisitor VIPvisitor = new VIPVisitor(VIPVisitorName);
                    System.out.println("Enter Ride name:");
                    String rName1 = strScanner.nextLine();
                    Ride ride2 = findRide(admin,rName1);
                    if( ride2 != null ){
                        ride2.addVisitor(VIPvisitor);
                        //VIPvisitor.getPriorityAccess(ride2);
                    }else{
                        System.out.println("Ride not found!");
                    }
                    break;
                case 4 :
                    System.out.println("Enter Ride name:");
                    String rName2 = strScanner.nextLine();
                    Ride ride3 = findRide(admin,rName2);
                    if( ride3 != null ){
                        ride3.startRide();
                    }else{
                        System.out.println("Ride not found!");
                    }
                    break;
                case 5 :
                    showAllRides(admin);
                    break;
                case 6 :
                    run = false;
                    System.out.println("Bye,Have a good time!");
                    break;
                default :
                    System.out.println("Invalid option!Try again.");
            }
        }
        numScanner.close();
        strScanner.close();
    }
    public static Ride findRide(Admin admin,String name){
        for(Ride r : admin.getRides()){
            if(name.equals(r.getName())){
                return r;
            }
        }
        return null;
    }

    public static void showAllRides(Admin admin){
        System.out.println("~ List of rides ~");
        int counter = 1;
        if(admin.getRides().isEmpty()){
            System.out.println("No rides available.");
        }else{
            for(Ride r : admin.getRides()) {
                System.out.println(counter + ". Ride Name:" + r.getName());
                counter++;
            }
        }

    }
}
