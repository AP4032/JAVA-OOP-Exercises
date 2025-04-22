package MyJava5;


public class Menu {
    private final String title;
    private final double unitPrice;

    public Menu(String title, double unitPrice) {
        this.title = title;
        this.unitPrice = unitPrice;
    }

    public String getTitle() {
        return title;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public String toString() {
        return title + " - " + unitPrice + " Toman";
    }
}
