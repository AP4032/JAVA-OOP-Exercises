package ThemeParkSystem;
import java.util.ArrayList;

import static java.lang.Thread.sleep;


public class Ride {
    private String name;
    private int capacity;
    private int duration;

    ArrayList <Visitor> names_with_out_order = new ArrayList<>();
    ArrayList <Visitor> names_with_order = new ArrayList<>();


    public Ride(String name, int capacity, int duration) {
        this.name = name;
        this.capacity = capacity;
        this.duration = duration;
    }

    public void priority()
    {
        for (int i = 0; i < names_with_out_order.size() ; i++)
        {
            if( names_with_out_order.get(i).getKind().equals("vip") )
            {
                names_with_order.add(names_with_out_order.get(i));
            }
        }
        for (int i = 0; i < names_with_out_order.size() ; i++)
        {
            if( names_with_out_order.get(i).getKind().equals("common") )
            {
                names_with_order.add(names_with_out_order.get(i));
            }
        }
    }

    public void addVisitor(Visitor visitor)
    {
        names_with_out_order.add(visitor);
        System.out.println(visitor.getName() + " joined the line for " + name);
    }

    public void startRide()
    {
        for (int i = 0; i < names_with_order.size(); i++)
        {
            if (i!=0 && i % capacity ==0)
            {
                try {
                    sleep(duration * 1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(names_with_order.get(i).getName() + " is playing " + name);

        }
    }
    public String getName()
    {
        return name;
    }
}
