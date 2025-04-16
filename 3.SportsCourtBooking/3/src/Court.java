public class Court {
    private String sportType;
    private boolean isAvailable = false;

    public Court(String sportType){
        this.sportType = sportType;
        this.isAvailable = true;
    }

    public void releaseCourt() {
        isAvailable = true;
    }


    public boolean bookCourt() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }
    public boolean isAvailable() {
        return isAvailable;
    }


    public String getSportType() {
        return sportType;
    }



}
