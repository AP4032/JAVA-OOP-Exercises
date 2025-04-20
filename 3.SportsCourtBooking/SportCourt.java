public class SportCourt {
    private String sportType;
    private boolean isAvailable;
    private int cost;

    public SportCourt(String sportType,int cost) {
        this.sportType = sportType;
        this.isAvailable = true;
        this.cost = cost;
    }

    public boolean bookCourt() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }
    public String getSportType() {
        return sportType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}