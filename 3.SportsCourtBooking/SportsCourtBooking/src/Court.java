public class Court {
    private String sportType;
    private boolean isAvailable;
    private Booking[] bookings;
    private int bookingCount;

    public Court(String sportType) {
        this.sportType = sportType;
        this.isAvailable = true;
        this.bookings = new Booking[10];
        this.bookingCount = 0;
    }

    public boolean bookCourt(String dateTime, Player player) {
        if (isAvailable && bookingCount < bookings.length) {
            Booking booking = new Booking(dateTime, this, player);
            bookings[bookingCount] = booking;
            bookingCount++;
            isAvailable = false;
            return true;
        }
        return false;
    }

    public void releaseCourt() {
        isAvailable = true;
        bookings = new Booking[10];
        bookingCount = 0;
    }

    public String getSportType() {
        return sportType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Booking[] getBookings() {
        return bookings;
    }
}