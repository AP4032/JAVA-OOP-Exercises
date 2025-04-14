public class Court {
    private final String name;
    private boolean isAvailable;

    public Court(String name) {
        this.name = name;
        this.isAvailable = true;
    }

    public String getName() {
        return name;
    }

    public boolean canBookCourt() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        } else return false;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
