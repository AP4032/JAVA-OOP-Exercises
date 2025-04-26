public class Customer {
    private String name;
    private String address;

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Place an order for customer
    public Order placeOrder(MenuItem... items) {
        Order order = new Order(this);  // Pass this customer to the order
        for (MenuItem item : items) {
            order.addItem(item);
        }
        System.out.println(name + " placed an order. Total: $" + order.calculateTotal());
        return order;
    }

    // Get customer name
    public String getName() {
        return name;
    }

    // Get customer address
    public String getAddress() {
        return address;
    }
}