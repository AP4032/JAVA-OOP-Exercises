package org.example;

import java.util.ArrayList;
import java.util.List;

public class Court {
    private String courtName;
    private List<Booking> bookings;

    public Court(String courtName) {
        this.courtName = courtName;
        this.bookings = new ArrayList<>();
    }

    public String getCourtName() {
        return courtName;
    }

    public boolean bookCourt(Player player, String date, String time) {
        Booking booking = new Booking(this, player, date, time);
        bookings.add(booking);
        return true;
    }

    public List<Booking> getBookings() {
        return bookings;
    }
}
