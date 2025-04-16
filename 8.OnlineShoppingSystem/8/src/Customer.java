public class Customer {
    private String name;
    private ShoppingCart cart;
    private static int idCounter = 100;
    int customerId;



    public Customer(String name) {
        this.name = name;
        this.customerId = idCounter++;
        this.cart = new ShoppingCart();
    }

    public void addToCart(Product product) {
        cart.addItem(product);
    }

    public void placeOrder() {
        cart.checkout();
    }
}