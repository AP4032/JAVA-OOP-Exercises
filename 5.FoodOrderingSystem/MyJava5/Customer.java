package MyJava5;


public class Customer {
    private final String customerName;

    public Customer(String customerName) {
        this.customerName = customerName;
    }

    public Order createOrder(Menu[] selectedItems) {
        Order newOrder = new Order();
        for (Menu item : selectedItems) {
            newOrder.addMenuItem(item);
        }
        System.out.println(customerName + " placed an order.");
        return newOrder;
    }
}
