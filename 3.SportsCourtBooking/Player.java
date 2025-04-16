package Sports_Court_Booking_System;

public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void bookCourt(Court court)
    {
        if (court.booked_turn < court.capacity)
        {
            court.booked_turn ++;
            System.out.println(name + " successfully booked a " + court.getSportType() + " court.");
            if (court.booked_turn == 1)
            {
                System.out.println(name + " can enter the " + court.getSportType() + " now.");
            }
            else
            {
                System.out.println( name + " can enter the " + court.getSportType() +" in " + court.booked_turn * court.time + " hours." );
            }

        }
        else
        {
            System.out.println("there is no empty time for "+name + " to use " + court.getSportType()  + " court");
        }

    }
}
