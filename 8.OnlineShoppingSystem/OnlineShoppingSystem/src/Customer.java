public class Customer {
    private String name;
    private ShoppingCart cart;

    public Customer(String name) {
        this.name = name;
        this.cart = new ShoppingCart();
    }

    public void addToCart(Product product) {
        cart.addItem(product);
    }

    public void placeOrder() {
        System.out.println("\n" + name + " is placing an order...");
        cart.checkout();
    }
}
