public class Product {
    private String name;
    private double price;
    private int stockQuantity;

    public Product(String name, double price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    // Update the stock quantity after an item is purchased
    public void updateStock(int quantity) {
        if (stockQuantity >= quantity) {
            stockQuantity -= quantity;
        } else {
            System.out.println("Not enough stock available!");
        }
    }

    // Display product details
    public void displayProductDetails() {
        System.out.println("Product: " + name + " | Price: $" + price + " | Available: " + stockQuantity);
    }
}
