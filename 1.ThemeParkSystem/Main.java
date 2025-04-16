package ThemeParkSystem;


import Sports_Court_Booking.Court;
import Sports_Court_Booking.Player;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        {
            Admin admin = new Admin();
            Scanner input = new Scanner(System.in);
            System.out.println("main menu: ");
             outer : while (true)
            {
                System.out.println("*****************************");
                System.out.println("1. add Ride");
                System.out.println("2. add Visitor");
                System.out.println("3. start rides");
                System.out.println("4. exit");
                System.out.println("*****************************");
                System.out.print("shomareh amale morede nazar ra vared konid: ");
                int choice = input.nextInt();
                Scanner inp = new Scanner(System.in);
                switch (choice) {
                    case 1:
                        System.out.print("Enter Ride name: ");
                        String Ride_name = inp.nextLine();
                        System.out.print("Enter Ride capacity: ");
                        int Ride_capacity = inp.nextInt();
                        System.out.print("Enter Ride time: ");
                        int Ride_time = inp.nextInt();
                        Ride ride = new Ride(Ride_name , Ride_capacity , Ride_time);
                        admin.addRide(ride);
                        break;
                    case 2:
                        System.out.print("Enter player name: ");
                        String visitor_name = inp.nextLine();
                        System.out.print("Enter player type: ");
                        String visitor_type = inp.nextLine();
                        Visitor visitor = new Visitor(visitor_name , visitor_type);
                        for (int i = 0; i < admin.rides.size() ; i++)
                        {
                            System.out.print(i + ". "+admin.rides.get(i).getName() +"  ");
                        }
                        System.out.println();
                        System.out.println("enter the Ride number: ");
                        int ride_num = inp.nextInt();
                        admin.rides.get(ride_num).addVisitor(visitor);
                        break;
                    case 3:
                        for (int i = 0; i < admin.rides.size() ; i++)
                        {
                            System.out.print(i + ". "+admin.rides.get(i).getName() +"  ");
                        }
                        System.out.println();
                        System.out.print("which ride is going to start?");
                        int ride_number = inp.nextInt();
                        admin.rides.get(ride_number).priority();
                        admin.rides.get(ride_number).startRide();
                    case 4:
                        break outer;
                    default:
                        break outer;
                }



            }


        }





//        Ride rollerCoaster = new Ride("Roller Coaster", 5, 3);
//        Visitor john = new Visitor("John" , "vip");
//        Visitor arya = new Visitor("Aohn" , "common");
//
//        rollerCoaster.addVisitor(john);
//        rollerCoaster.addVisitor(arya);
//
//        rollerCoaster.Priority();
//        rollerCoaster.startRide();
    }
}
