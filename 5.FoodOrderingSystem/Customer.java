public class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public Order placeOrder(MenuItem... items) {
        Order order = new Order();
        for (MenuItem item : items) {
            order.addItem(item);
        }
        Print.printTitle(name + " placed an order. Total: $" + order.calculateTotal());
        return order;
    }

    public String getName() {
        return name;
    }
}