import java.time.Period;

public class Player {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    public boolean bookCourse(Course course) {
        if (course.bookCourse() && Wallet.getWallet() >= 20) {
            Print.printTitle(name + " successfully booked a " + course.getSportType() + " court");
            Wallet.setWallet(Wallet.getWallet() - 20);
        }
        else if (!course.bookCourse() || Wallet.getWallet() < 20) Print.printTitle("Court is already booked or You don't have enough money in your wallet");
        return false;
    }

    public String getName() {
        return name;
    }
}
