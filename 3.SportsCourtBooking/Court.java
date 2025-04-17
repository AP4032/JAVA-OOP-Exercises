public class Court {
    private String sportType;
    private boolean isAvailable;

    public Court(String sportType) {
        this.sportType = sportType;
        this.isAvailable = true;
    }

    public boolean bookCourt() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }

    public void releaseCourt() {
        isAvailable = true;
        System.out.println("The court has been successfully released.");
    }

    public String getSportType() {
        return sportType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}