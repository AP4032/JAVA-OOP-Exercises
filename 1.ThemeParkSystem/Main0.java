import java.sql.SQLOutput;
import java.util.Scanner;

public class Main0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin0 admin= new Admin0();
        String D;
        Ride Train=new Ride("Train",5,5,5);
        Ride ShipSvr=new Ride("ShipSvr",20,5,5);
        Ride FrogDark=new Ride("FrogDark",4,2,5);
        admin.addRide(Train);
        admin.addRide(ShipSvr);
        admin.addRide(FrogDark);
        boolean Closed=false;
        while(!Closed){
            System.out.println("░▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒░");
            System.out.println("░▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒░  Big Masoud Amusement Park is open.░▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒░");
            System.out.println("░▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒░  1.add Ride                        ░▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒░");
            System.out.println("░▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒░  2.add Visitor                     ░▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒░");
            System.out.println("░▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒░  3.add VIP Visitor                 ░▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒░");
            System.out.println("░▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒░  4.Run Ride                        ░▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒░");
            System.out.println("░▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒░  5.se All Rides capacity           ░▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒░");
            System.out.println("░▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒░  6.Delete Ride                     ░▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒░");
            System.out.println("░▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒░  7.Exit                            ░▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒░");
            System.out.println("░▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒░");
            D=scanner.nextLine();
            switch (D.charAt(0)-'0'){
                case 1:
                    System.out.println("Enter name Ride");
                    String nameRide=scanner.nextLine();
                    System.out.println("Enter Capacity Ride");
                    String capacityRide=scanner.nextLine();
                    System.out.println("Enter VIPCapacity Ride");
                    String capacityVIPRide=scanner.nextLine();
                    System.out.println("Enter Duration Ride");
                    String Duration=scanner.nextLine();
                    Ride ride=new Ride(nameRide,capacityRide.charAt(0)-'0',capacityVIPRide.charAt(0)-'0',Duration.charAt(0)-'0');
                    admin.addRide(ride);
                    break;
                case 2:
                    System.out.println("Enter name Ride");
                    String TurenameRide=scanner.nextLine();
                    Ride NormalRide=TureRide(admin,TurenameRide);
                    if(NormalRide!=null){
                        System.out.println("Enter Name Visitor");
                        String NameVisitor=scanner.nextLine();
                        Visitor visitor=new Visitor(NameVisitor);
                        NormalRide.addVisitor(visitor);
                    }else System.out.println("No Find Ride");
                    break;
                case 3:
                    System.out.println("Enter name Ride ");
                    String VIP=scanner.nextLine();
                    Ride VIPRide = TureRide(admin,VIP);
                    if(VIPRide!=null){
                        System.out.println("Enter Name VIPVisitor");
                        String VIPVisitor=scanner.nextLine();
                        VIPVisitor vipVisitor=new VIPVisitor(VIPVisitor);
                        VIPRide.addVisitorVIP(vipVisitor);
                    }else System.out.println("Not Find Ride");
                    break;
                case 4:
                    System.out.println("Which Ride to turn on?");
                    String OnNameRide=scanner.nextLine();
                    Ride OnRide=TureRide(admin,OnNameRide);
                    if(OnRide!=null){
                        OnRide.startRide();
                    }else System.out.println("Not Find Ride");
                    break;
                case 5:
                    System.out.println("All Rides");
                    System.out.println("--------------");
                    for(Ride WH : admin.getRides()){
                        System.out.println("NameRide:"+WH.getname());
                        System.out.print("capacity:"+WH.getCapacity());
                        if(WH.getCapacity()==WH.getSizeCapacity()){
                            System.out.println("     Back of the queue:"+WH.getSizeCapacity() +"  Full !!!");
                        }else System.out.println("     Back of the queue:"+WH.getSizeCapacity());
                        System.out.print("CapacityVIP:"+WH.getCapacityVIP());
                        if(WH.getCapacityVIP()==WH.getSizeVIPCapacity()){
                            System.out.println("     Back of the queue:"+WH.getSizeVIPCapacity()+"  Full !!!");
                        }else System.out.println("     Back of the queue:"+WH.getSizeCapacity());
                        System.out.println("--------------");
                    }
                    break;
                case 6:
                    System.out.println("Enter Name Ride");
                    String NameRide=scanner.nextLine();
                    Ride ride1= TureRide(admin,NameRide);
                    if(ride1!=null){
                        admin.DeleteRide(ride1);
                    }else System.out.println("No Find Ride");
                    break;
                case 7:
                    System.out.println("Big Masoud playground was closed.");
                    Closed=true;

            }

        }
    }
    public static Ride TureRide(Admin0 admin,String tureRide){
        for(Ride R : admin.getRides()){
            if(tureRide.equalsIgnoreCase(R.getname())){
                return R;
            }
        }
        return null;
    }

}
