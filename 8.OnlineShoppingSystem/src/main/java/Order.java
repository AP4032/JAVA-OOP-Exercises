import java.util.ArrayList;

public class Order {
    private ArrayList<Product> products;
    private double total;
    private static int orderCounter = 1; // برای شماره سفارش
    private int orderId;

    public Order(ArrayList<Product> products, double total) {
        this.products = new ArrayList<>(products); // کپی لیست محصولات
        this.total = total;
        this.orderId = orderCounter++;
    }

    public int getOrderId() {
        return orderId;
    }

    public void displayOrder() {
        System.out.println("\nOrder #" + orderId + ":");
        if (products.isEmpty()) {
            System.out.println("No products in this order!");
        } else {
            for (Product product : products) {
                System.out.println("  " + product);
            }
            System.out.println("  Total: $" + total);
        }
    }
}