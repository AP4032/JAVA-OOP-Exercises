package org.example;

public class Customer {
    private int tableNumber;
    private Order order;

    public Customer(int tableNumber) {
        this.tableNumber = tableNumber;
        this.order = null;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void placingOrder(MenuItem menu) {
        Order newOrder = new Order("Awaiting");
        newOrder.addItems(menu);
        this.order = newOrder;
    }

    public void addToExistingOrder(MenuItem menu) {
        if (order != null) {
            order.addItems(menu);
        }
    }
    public Order getOrder() {
        return order;
    }
}
