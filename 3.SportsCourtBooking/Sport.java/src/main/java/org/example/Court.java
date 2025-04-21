package org.example;

import java.time.LocalDateTime;

public class Court {
    private String sportType;
    private boolean isAvailable;;
    private double price;
    private boolean isPaid;
    private LocalDateTime bookingTime;

    public Court(String sportType , double price) {
        this.sportType = sportType;
        this.isAvailable = true;
        this.price = price;
        this.isPaid = false;
        this.bookingTime = null;
    }
    public boolean payment(double amount){
        if (amount >= price){
            this.isPaid = true;
            System.out.println("Payment of " + amount  + " successful for " + sportType + " court.");
            return true;
        }else {
            System.out.println("You need to pay at least " + price);
            return false;
        }
    }

    public boolean bookCourt(LocalDateTime dateTime) {
        if (isAvailable && isPaid) {
            this.bookingTime = dateTime;
            isAvailable = false;
            return true;
        }
        return false;
    }

    public void releaseCourt() {
        isAvailable = true;
        bookingTime = null;
        isPaid = false;
    }

    public String getSportType() {
        return sportType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public LocalDateTime getBookingTime(){
        return bookingTime;
    }
    public double getPrice(){
        return price;
    }
    public boolean isPaid(){
        return isPaid;
    }
    public void setPaid(boolean paid){
        isPaid = paid;
    }
}