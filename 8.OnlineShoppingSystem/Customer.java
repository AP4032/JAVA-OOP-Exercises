public class Customer {
    private String name;
    private ShoppingCart cart;

    public Customer(String name){
        this.name = name;
        this.cart = new ShoppingCart();
    }

    public void addToCard(Product product){
        this.cart.addItem(product);
    }

    public void removeFromCart(Product product){
        this.cart.removeItem(product);
    }

    public void placeOrder() {
        cart.checkout();
    }

    public String getName() {
        return name;
    }

    public ShoppingCart getCart() {
        return cart;
    }
}
