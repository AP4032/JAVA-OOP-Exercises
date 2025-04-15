import java.util.HashMap;

public class Admin {
    public static HashMap<String, Court> courts = new HashMap<>();

    public HashMap<String, Court> getCourts() {
        return courts;
    }

    public void addCourt(String name) {
        if (courts.containsKey(name)) {
            System.out.println("Court already exists!");
        }else {
            courts.put(name, new Court(name));
            System.out.println("Court was successfully added!");
        }
    }

    public void removeCourt(String courtName) {
        if (courts.containsKey(courtName)) {
            courts.remove(courtName);
            System.out.println(courtName + " was successfully removed from the court list");
        } else System.out.println(courtName + " does not exist in the court list!");
    }

    public void listCourts() {
        int counter = 1;
        for (String name : courts.keySet()) {
            System.out.println(counter++ + ". " + name);
        }
    }

}
