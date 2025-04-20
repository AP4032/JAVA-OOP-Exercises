public class VIPVisitor extends Visitor {

    public enum Level {
        GOLD, SILVER, BRONZE
    }

    private Level level;

    public VIPVisitor(String name, Level level) {
        super(name);
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    public void getPriorityAccess(Ride ride) {
        System.out.println(getName() + " (" + level + ") gets priority access to " + ride.getName());
    }

    @Override
    public String toString() {
        return "VIP Visitor (" + level + "): " + getName();
    }
}
