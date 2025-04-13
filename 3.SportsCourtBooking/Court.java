public class Court {
    private final String SportType;
    private Boolean availability;

    public Court(String SportType) {
        this.SportType = SportType;
        this.availability = true;
    }

    public String getSportType() {
        return SportType;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public boolean bookCourt() {
        if (availability) {
            availability = false;
            return true;
        }
        return false;
    }
    public boolean CancellCourt() {
        if (!availability) {
            availability = true;
            return true;
        }
        return false;
    }

}
