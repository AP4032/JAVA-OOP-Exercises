import java.util.List;
import java.util.Random;

public class Admin {
    private int ID;

    public Admin (){
       Random rand = new Random();
       this.ID = rand.nextInt(5001) + 1000;
    }

    public void availableCourts(List<Court> courtsList){
        System.out.println("Available Courts :");
        for (Court c : courtsList){
            System.out.println(c + ",");
        }
    }
    public void addCourt (List<Court> courtList, Court court){
        courtList.add(court);
    }
    public void removeCourt (List<Court> courtList, int courtId){
        courtList.removeIf(court -> court.getID() == courtId);
    }

}
