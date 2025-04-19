public class Main {
    public static void main(String[] args) {
        MenuItem[] menu = {
                new MenuItem("Burger", 5.99),
                new MenuItem("Pizza", 8.99),
                new MenuItem("Pasta", 7.49),
                new MenuItem("Salad", 4.99)
        };

        Restaurant restaurant = new Restaurant();

        // Customer places order
        Customer customer = new Customer("Sevin");
        Order order = customer.placeOrder(menu);
        restaurant.receiveOrder(order);

        // Staff updates order status
        restaurant.updateOrderStatus();
    }
}

