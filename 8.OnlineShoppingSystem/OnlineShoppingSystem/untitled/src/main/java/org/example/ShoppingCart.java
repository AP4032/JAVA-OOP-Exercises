package org.example;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product product, int quantity) {
        if (product.IsOutOfStock() || product.getQuantity() < quantity) {
            System.out.println("Not enough products in stock: " + product.getName());
            return;
        }
        if (product.ReduceQuantity(quantity)) {
            for (int i = 0; i < quantity; i++) {
                items.add(product);
            }
            System.out.println(quantity + " x " + product.getName() + " added to cart.");
        }
    }


    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println(" your cart is empty.");
            return;
        }
        System.out.println("Items in your cart:");
        for (Product product : items)
            System.out.println("- " + product.getName() + " | $" + product.getPrice());
    }

    public double calculateTotal() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }
    public void checkout(){
        if(items.isEmpty()){
            System.out.println(" Cannot checkout: cart is empty");
            return;
        }
        System.out.println("Total amount to pay: $" + calculateTotal());
        System.out.println(" Order placed successfully!");
        items.clear();
    }
}

