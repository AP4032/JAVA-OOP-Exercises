package Sports_Court_Booking;

public class Court
{
    private String sportType;
    int capacity ;
    float time;
    int booked_turn = 0;

    public Court(String sportType , int capacity , float time)
    {
        this.sportType = sportType;
        this.capacity = capacity;
        this.time = time;
    }

    public String getSportType()
    {
        return sportType;
    }

}
