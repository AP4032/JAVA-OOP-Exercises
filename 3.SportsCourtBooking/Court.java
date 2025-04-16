public class Court {
    private String sportType;
    private boolean isAvailable;

    public Court(String courtType){
        this.sportType = courtType;
        this.isAvailable = true;
    }

    public String getSportType() {
        return sportType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void releaseCourt() {
        isAvailable = true;
        System.out.println(sportType + " court released!");
    }


    public boolean bookCourt(){
        if(isAvailable){
            isAvailable = false;
            return true;
        }
        return false;
    }
}
