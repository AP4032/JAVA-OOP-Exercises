package org.example;

public class Restuarant {
    private Customer[] customers;
    private Order[] orders;
    private MenuItem[] menuItems;
    private int ordersCount;
    private int customersCount;

    public Restuarant() {
        this.customers = new Customer[30];
        this.orders = new Order[150];
        this.menuItems = new MenuItem[6];
        this.ordersCount = 0;
        this.customersCount = 0;

        menuItems[0] = new MenuItem("Burger", 6.99);
        menuItems[1] = new MenuItem("Pizza", 8.99);
        menuItems[2] = new MenuItem("Sandwich", 4.99);
        menuItems[3] = new MenuItem("Cake", 3.99);
        menuItems[4] = new MenuItem("Pasta", 9.99);
        menuItems[5] = new MenuItem("Beer", 2.99);
    }

    public MenuItem getMenuItemByName(String name) {
        for (MenuItem item : menuItems) {
            if (item != null && item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public void printMenu() {
        System.out.println("\n--- Menu ---");
        for (MenuItem item : menuItems) {
            if (item != null) {
                System.out.println(item.getName() + ": " + item.getPrice());
            }
        }
    }

    public void addCustomer(Customer customer) {
        if (customersCount < customers.length) {
            customers[customersCount] = customer;
            customersCount++;
            System.out.println("Customer added with table number: " + customer.getTableNumber());
        } else {
            System.out.println("Sorry, we can't add more customers.");
        }
    }

    public Customer findCustomer(int tableNumber) {
        for (int i = 0; i < customersCount; i++) {
            if (customers[i].getTableNumber() == tableNumber) {
                return customers[i];
            }
        }
        return null;
    }

    public void updatingStatus(Order order, String newStatus) {
        if (order != null) {
            order.setStatus(newStatus);
            System.out.println("Order status updated to: " + newStatus);
        } else {
            System.out.println("Order is null.");
        }
    }
}
