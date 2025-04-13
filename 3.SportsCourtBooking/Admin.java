import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Admin {
    String Red = "\033[31m";
    String Green = "\033[32m";
    String Reset = "\033[0m";
    int Number = 1;
    List<Court> ListCourt;
    List<Player> ListPlayer;
    Map<Integer, Court> map;

    public Admin() {
        ListCourt = new ArrayList<>();
        ListPlayer = new ArrayList<>();
        map = new HashMap<>();
    }

    public void AddCourt(Court Court) {
        ListCourt.add(Court);
        map.put(Number++, Court);
//        Number++;
    }

    public void AddPlayer(Player Player) {
        ListPlayer.add(Player);
    }

    public void GetAvaliable() {
        int number = 1;
        for (Court Court : ListCourt) {
            if (Court.getAvailability()) {
                System.out.println(number + "." + Court.getSportType());
            }
            number++;
        }
    }

    public void GetListCourt() {
        int number = 1;
        for (Court Court : ListCourt) {
            System.out.println(number + "." + Court.getSportType());
            number++;
        }
    }

    public boolean FindName(String name) {
        for (Player player : ListPlayer) {
            if (player.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Player SetPlayer(String PlayerName) {
        for (Player player : ListPlayer) {
            if (player.getName().equals(PlayerName)) {
                return player;
            }
        }
        return null;
    }

    public Boolean reserveCourt(int number) {
        if (number >= Number || number <= 0 ) {
            System.out.println(Red+"The number you sent is incorrect, please try again"+Reset);
            return false;
        } else {
            if (map.get(number).bookCourt()) {
//           System.out.println("The court has been booked successfully");
                return true;
            } else {
                System.out.println(Red+"The reservation has already been made"+Reset);
                return false;
            }
        }

    }
    public boolean CancellCourt(int number)
    {
        if (number >= Number || number <= 0 ) {
            System.out.println(Red+"The number you sent is incorrect, please try again"+Reset);
            return false;
        } else {
            if (map.get(number).CancellCourt()) {
//           System.out.println(Green+"The court has been Cancelled successfully"+Reset);
                return true;
            } else {
                System.out.println(Red+"This land has not been reserved yet."+Reset);
                return false;
            }
        }
    }



}
