public class Main {
    public static void main(String[] args) {
        menuItem[] menu = {
                new menuItem("Burger", 5.99),
                new menuItem("Pizza", 8.99),
                new menuItem("Pasta", 7.49),
                new menuItem("Salad", 4.99)
        };

        restaurant restaurant = new restaurant();

        // Customer places order
        customer customer = new customer("Sevin");
        order order = customer.placeOrder(menu);
        restaurant.receiveOrder(order);

        // Staff updates order status
        restaurant.updateOrderStatus();
    }
}
