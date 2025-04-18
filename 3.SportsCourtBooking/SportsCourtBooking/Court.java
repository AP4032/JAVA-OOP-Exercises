public class Court {

    private String sportType;
    private boolean isAvailable;
    private int reservationPrice = 15;
    private int bookedDuration=0;

    public Court(String sportType) {
        this.sportType = sportType;
        this.isAvailable = true;
    }

    public boolean bookCourt(int duration ) {
        if (isAvailable) {
            isAvailable = false;
            bookedDuration=duration;
            int price = bookedDuration*reservationPrice;
            System.out.println(sportType + "booked for" +duration);
            System.out.println("price = " + price);
            return true;

        }
        return false;
    }
    public void extendBooking(int extraHours) {
        bookedDuration += extraHours;
        double extraCost = extraHours * reservationPrice;
        System.out.println(" Booking extended by " + extraHours + " hours.");
        System.out.println(" Additional cost: " + extraCost);
    }
    public void releaseCourt() {
        isAvailable = true;
        bookedDuration = 0;
    }

    public String getSportType() {
        return sportType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
    public int getReservationPrice() {
        return reservationPrice;
    }
}

