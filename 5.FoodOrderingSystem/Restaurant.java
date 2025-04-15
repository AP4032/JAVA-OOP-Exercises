import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Restaurant {
    private List<Order> orders;
    private HashMap<String, MenuItem> menuItems;

    public Restaurant() {
        this.orders = new ArrayList<>();
        this.menuItems = new HashMap<>();
    }

    public void addItem(MenuItem item) {
       if (this.menuItems.containsKey(item.getName())){
           System.out.println("Item already exists");
        }else {
           this.menuItems.put(item.getName(), item);
           System.out.println("Item added");
       }
    }

    public List<Order> getOrders() {
        return orders;
    }

    public HashMap<String, MenuItem> getMenuItems() {
        return menuItems;
    }

    public void printMenu() {
        if (this.menuItems.isEmpty()) {
            System.out.println("There are no items in the menu");
        }else {
            menuItems.forEach((key, value) -> {
                System.out.println("-- " + key + " " + value.getPrice() + " --");
            });
        }
    }

    public void printOrders(){
        if (orders.isEmpty()){
            System.out.println("No orders found");
        }else {
            int counter = 1;
            for(Order order : orders){
                System.out.println(counter++ + ")");
                for(String item : order.getOrderList().keySet()){
                    System.out.println("-- " + item + " --");
                }
                System.out.println("total: " + order.getTotal());
            }
        }
    }

    public void receiveOrder(Order order) {
        this.orders.add(order);
    }
}
