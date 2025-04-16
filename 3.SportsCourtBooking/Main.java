package Sports_Court_Booking;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Admin admin = new Admin();
        System.out.println("main menu:");
        outer : while (true)
        {
            Scanner inp = new Scanner(System.in);
            System.out.println("*****************************");
            System.out.println("1. add court");
            System.out.println("2. add player");
            System.out.println("3. exit ");
            System.out.println("*****************************");
            System.out.print("shomareh amale morede nazar ra vared konid: ");
            int choice = input.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.print("Enter Court name: ");
                    String Court_name = inp.nextLine();
                    System.out.print("Enter Court capacity: ");
                    int Court_capacity = inp.nextInt();
                    System.out.print("Enter Court time: ");
                    float Court_time = inp.nextFloat();
                    Court court = new Court(Court_name , Court_capacity , Court_time);
                    admin.addCourt(court);
                    break;
                case 2:
                    System.out.print("Enter player name: ");
                    String Player_name = inp.nextLine();
                    Player player = new Player(Player_name);
                    for (int i = 0; i < admin.Courts.size(); i++)
                    {
                        System.out.println(i+". " + admin.Courts.get(i).getSportType() + "   ");
                    }
                    System.out.println();
                    admin.addPlayer(player);
                    System.out.println("Enter the court nuamber");
                    int court_num = inp.nextInt();
                    player.bookCourt(admin.Courts.get(court_num));
                    break;
                case 3:
                    break outer;
                default:
                    break outer;
            }
        }


    }
}
