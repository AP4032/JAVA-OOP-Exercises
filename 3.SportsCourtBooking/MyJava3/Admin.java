package MyJava3;

import java.util.ArrayList;
import java.util.List;


public class Admin {
    private List<Court> courts;

    public Admin() {
        courts = new ArrayList<>();
    }

    public void addCourt(Court court) {
        courts.add(court);
        System.out.println("Court added: " + court.getName());
    }

    public List<Court> getCourts() {
        return courts;
    }

    public void listCourts() {
        for (Court court : courts) {
            System.out.println("- " + court.getName());
        }
    }
}