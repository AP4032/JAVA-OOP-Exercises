public class Admin {
    private Court[] courts;
    private int courtCount;

    public Admin(int maxCourts) {
        this.courts = new Court[maxCourts];
        this.courtCount = 0;
    }

    public void addCourt(Court court) {
        if (courtCount < courts.length) {
            courts[courtCount] = court;
            courtCount++;
            System.out.println("Added " + court.getSportType() + " court.");
        } else {
            System.out.println("Can not add more courts.");
        }
    }

    public Court[] getCourts() {
        return courts;
    }
}