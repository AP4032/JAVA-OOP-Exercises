import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Order {
    private HashMap<String, MenuItem> orderList;
    private String status;
    private double total;

    public Order() {
        this.orderList = new HashMap<>();
        this.status = "Pending";
        this.total = 0;
    }

    public HashMap<String, MenuItem> getOrderList() {
        return orderList;
    }

    public String getStatus() {
        return status;
    }

    public double getTotal() {
        return (int) total;
    }

    public void addToOrderList(MenuItem menuItem) {
        if (orderList.containsKey(menuItem.getName())) {
            System.out.println("you already ordered this item");
        }else {
            orderList.put(menuItem.getName(), menuItem);
            System.out.println(menuItem.getName() + " added to the order list");
            total += menuItem.getPrice();
        }
    }
}
