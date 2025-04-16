package Sports_Court_Booking;

import java.util.ArrayList;

public class Admin
{
    ArrayList <Court> Courts = new ArrayList<>();
    ArrayList <Player> Players = new ArrayList<>();
    public void addCourt(Court name)
    {
        Courts.add(name);
    }

    public void addPlayer(Player name)
    {
        Players.add(name);
    }
}
