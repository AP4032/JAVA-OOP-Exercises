import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int idOrder = 100;
    private int IDOrder;
    private List<MenuItem> items;
    private String status;


    public Order() {
        this.items = new ArrayList<>();
        this.status = "Pending";
        this.IDOrder=idOrder++;
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void updateStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    public List<MenuItem> getitems(){
        return items;
    }
    public int getIDorder(){
        return IDOrder;
    }
}