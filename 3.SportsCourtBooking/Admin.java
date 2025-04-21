import java.util.ArrayList;
import java.util.HashMap;

public class Admin {
    public ArrayList <String> bookcourts;
    public HashMap<String,Court> courtMap;

    public Admin() {
        this.bookcourts = new ArrayList<String>(bookcourts.asList(" ", "", ""));
        this.courtMap = new HashMap<>();

    }

    public void addbook(String name){
        bookcourts.add(name);
    }

    public void removebook(String name){
        bookcourts.remove(name);
    }

    public void show(){
        System.out.println("available courts: ");
        for (String court : bookcourts) {
            System.out.println(court);
        }
    }

    public boolean checkcourtmap(String name){
        if(courtMap.containsKey(name)){
            return true;
        }
        return false;
    }

 //   public Court givecourt (String courtName){


   // }
}
