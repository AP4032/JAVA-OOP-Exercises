import java.util.Random;

public class Court {
    private int id;
    private String type; // e.g., "Basketball", "Tennis", etc.
    private boolean isAvailable;

    public Court(String type) {
        Random rand = new Random();
        this.id = rand.nextInt(5000) + 1000;
        this.type = type;
        this.isAvailable = true; // default to available when created
    }

    public int getID() {
        return id;
    }

    public String getType() {
        return type;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public String toString() {
        return "Court ID: " + id + ", Type: " + type + ", Available: " + isAvailable;
    }
}
