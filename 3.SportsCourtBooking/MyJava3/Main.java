package MyJava3;


public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        Court tennisCourt = new Court("Tennis Court A", "Tennis", 30.0);
        Court footballCourt = new Court("Football Field 1", "Football", 50.0);

        admin.addCourt(tennisCourt);
        admin.addCourt(footballCourt);

        Player player1 = new Player("Sarina Shakeri");
        Player player2 = new Player("Sarina Shakeri 2");

        Schedule slot1 = new Schedule("10:00", "11:00");
        Schedule slot2 = new Schedule("10:30", "11:30");
        Schedule slot3 = new Schedule("11:30", "12:30");

        player1.reserveCourt(tennisCourt, slot1); // success
        player2.reserveCourt(tennisCourt, slot2); // conflict
        player2.reserveCourt(tennisCourt, slot3); // success

        System.out.println();
        tennisCourt.printBookings();
    }
}