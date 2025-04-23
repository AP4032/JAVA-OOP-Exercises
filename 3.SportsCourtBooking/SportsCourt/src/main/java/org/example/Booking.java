package org.example;

public class Booking {
    private Court court;
    private Player player;
    private String date;
    private String time;

    public Booking(Court court, Player player, String date, String time) {
        this.court = court;
        this.player = player;
        this.date = date;
        this.time = time;
    }

    public Player getPlayer() {
        return player;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
