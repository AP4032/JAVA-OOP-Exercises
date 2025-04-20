public class RollerCoasterRide extends Ride {
    public RollerCoasterRide(String name, int capacity, int duration) {
        super(name, capacity, duration);
    }

    @Override
    public void startRide() {
        System.out.println("Starting roller coaster ride: " + name);
        for (int i = 0; i < capacity && !queue.isEmpty(); i++) {
            Visitor v = queue.poll();
            System.out.println(v.getname() + " is thrilled on " + name);
        }
    }
}