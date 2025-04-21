package ThemePark1 ;


public class WaterRide extends Ride {

    public WaterRide(String name, int capacity, int duration) {
        super(name, capacity, duration);
    }

    @Override
    public void startRide() {
        System.out.println("Splash! Starting water ride: " + name);
        for (int i = 0; i < capacity && !queue.isEmpty(); i++) {
            Visitor v = queue.poll();
            System.out.println(v.getname() + " is getting soaked on " + name);
        }
    }
}

