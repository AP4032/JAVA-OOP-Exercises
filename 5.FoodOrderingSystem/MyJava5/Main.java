package MyJava5;


public class Main {
    public static void main(String[] args) {
        Restaurant myRestaurant = new Restaurant();

        Menu omlet = new Menu("Omlet Gojeh", 60000);
        Menu kabab = new Menu("Chelo Kabab", 250000);
        Menu pizza = new Menu("Pizza Pepperoni", 399000);

        Customer sarina = new Customer("Sarina Shakeri");

        Menu[] items = {omlet, kabab, pizza};
        Order order1 = sarina.createOrder(items);

        myRestaurant.processNewOrder(order1);
        order1.printSummary();

        System.out.println("\n<< Updating Order >>");
        myRestaurant.setOrderStatus(order1, "Preparing");
        order1.printSummary();
    }
}
