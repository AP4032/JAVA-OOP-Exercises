import java.util.ArrayList;
import java.util.List;

public class Player {
    String Red = "\033[31m";
    String Green = "\033[32m";
    String Reset = "\033[0m";
    List<Court> courts;
    private final String name;

    public Player(String name) {
        this.name = name;
        this.courts = new ArrayList<Court>();
    }

    public String getName() {
        return name;
    }

    public void reserveCourt(Admin admin, int number) {

        Court court = admin.map.get(number);
        courts.add(court);
        System.out.println(Green+name + " has been reserved" + court.getSportType()+Reset);
    }
    public void GetListCourt() {
        int number = 1;
        for (Court Court : courts) {
            System.out.println(number + "." + Court.getSportType());
            number++;
        }
    }

    public void CancellCourt(Admin admin, int number) {

        Court court = admin.map.get(number);
        courts.remove(court);
        System.out.println(Green + name + " has been Cancelled" + court.getSportType() + Reset);


    }
}
