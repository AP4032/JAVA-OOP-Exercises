package MyJava3;

import java.util.ArrayList;
import java.util.List;


public class Court {
    private final String name;
    private String type;
    private final double hourlyRate;
    private final List<Booking> bookings;

    public Court(String name, String type, double hourlyRate) {
        this.name = name;
        this.type = type;
        this.hourlyRate = hourlyRate;
        this.bookings = new ArrayList<>();
    }

    public boolean isAvailable(Schedule slot) {
        for (Booking booking : bookings) {
            if (booking.getSchedule().conflictsWith(slot)) {
                return false;
            }
        }
        return true;
    }

    public boolean addBooking(Booking booking) {
        if (isAvailable(booking.getSchedule())) {
            bookings.add(booking);
            return true;
        }
        return false;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public String getName() {
        return name;
    }

    public void printBookings() {
        System.out.println("Bookings for court: " + name);
        for (Booking b : bookings) {
            System.out.println("- " + b);
        }
    }
}