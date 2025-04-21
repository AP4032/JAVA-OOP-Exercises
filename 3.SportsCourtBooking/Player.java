public class Player {
    public String name;

    public Player(String name) {
        this.name =name;
    }
    Admin admin = new Admin();

    public void bookcourt(Court court){
        if(!(court.status())) {
            System.out.println(name + " you booked "+court.name()+ " court");
            court.setbook();
        }
        else
            System.out.println( court.name()+" court has booked!");

    }
}
