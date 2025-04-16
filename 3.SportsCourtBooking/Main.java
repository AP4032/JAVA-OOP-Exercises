package Sports_Court_Booking_System;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Admin admin = new Admin();
        Scanner input = new Scanner(System.in);
        System.out.println("main menu: ");
        outter :while (true)
        {
            System.out.println("1. add court");
            System.out.println("2. add player");
            System.out.println("3. add player");
            System.out.print("shomareh amale morede nazar ra vared konid: ");
            int choice = input.nextInt();
            Scanner inp = new Scanner(System.in);
            switch (choice) {
                case 1:
                    System.out.print("Enter court name: ");
                    String Court_name = inp.nextLine();
                    System.out.print("Enter court capacity: ");
                    int Court_capacity = inp.nextInt();
                    System.out.print("Enter court time: ");
                    float Court_time = inp.nextFloat();
                    Court court = new Court(Court_name , Court_capacity , Court_time);
                    admin.addCourt(court);
                    break;
                case 2:
                    System.out.print("Enter player name: ");
                    String player_name = inp.nextLine();
                    Player player = new Player(player_name);
                    for (int i = 0; i < admin.Courts.size() ; i++)
                    {
                        System.out.print(i + ". "+admin.Courts.get(i).getSportType() +"  ");
                    }
                    System.out.println();
                    admin.addPlayer(player);
                    System.out.println("enter the court number: ");
                    int court_num = inp.nextInt();
                    player.bookCourt(admin.Courts.get(court_num));
                default:
                    break outter;
            }

        }

    }
}


