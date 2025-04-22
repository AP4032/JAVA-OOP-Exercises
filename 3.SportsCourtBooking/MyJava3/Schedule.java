package MyJava3;


public class Schedule {
    private final String startTime;
    private final String endTime;

    public Schedule(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String toString() {
        return startTime + " to " + endTime;
    }

    public boolean conflictsWith(Schedule other) {
        return !(endTime.compareTo(other.startTime) <= 0 || startTime.compareTo(other.endTime) >= 0);
    }
}