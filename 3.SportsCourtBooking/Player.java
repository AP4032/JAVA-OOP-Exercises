import java.util.Random;

public class Player {
    private String name;
    private int userID;
    private int money;
    private SportCourt reservedCourt;
    public Player(String name) {
        Random random=new Random();
        this.name = name;
        this.userID = random.nextInt(10000);
        this.money = 0;
        this.reservedCourt=null;
    }

    public void bookCourt(SportCourt court) {
        if (court.bookCourt()) {
            if (money >= court.getCost()) {
                money -= court.getCost();
                reservedCourt = court;
                System.out.println(name + " successfully booked a " + court.getSportType() + " court.");

            }
            else {
                System.out.println("failed to book a " + court.getSportType() + " court.");
                System.out.println("your money is not enough, please recharge your wallet");
            }
        }
        else
            System.out.println("Court is already booked!");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserID() {
        return userID;
    }
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public SportCourt getReservedCourt() {
        return reservedCourt;
    }

    public void setReservedCourt(SportCourt reservedCourt) {
        this.reservedCourt = reservedCourt;
    }
}