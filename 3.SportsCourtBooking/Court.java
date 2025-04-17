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
        isAvailable = true;
        return false;
    }



    public void releaseCourt() {
        isAvailable = true;
    }

    public String getSportType() {
        return sportType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}