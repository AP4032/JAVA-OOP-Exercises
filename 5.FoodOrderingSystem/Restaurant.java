import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<Order> orders;
    private List<MenuItem> MenuFood;
    public Restaurant() {
        this.orders = new ArrayList<>();
        this.MenuFood =new ArrayList<>();
    }
    public void SaveFoodInmMenu(MenuItem menuItem){
        MenuFood.add(menuItem);
        System.out.print("New Food in menu");
    }
    public void receiveOrder(Order order) {
        orders.add(order);
        System.out.println("New order received. Status: " + order.getStatus());
    }

    public void updateOrderStatus(Order order, String status) {
        order.updateStatus(status);
        System.out.println("Order status updated to: " + status);
    }
    public List<MenuItem> getMenuFood() {
        return MenuFood;
    }
    public List<Order> getOrders(){
        return orders;
    }

}