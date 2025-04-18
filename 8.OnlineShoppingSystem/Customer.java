public class Customer {
    private int id;
    private String name;
    private String email;
    private String address;
    private ShoppingCart cart;

    public Customer(int id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.cart = new ShoppingCart();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public ShoppingCart getCart() { return cart; }

    public boolean addToCart(Product product, int quantity) {
        return cart.addItem(product, quantity);
    }

    public boolean removeFromCart(Product product, int quantity) {
        return cart.removeItem(product, quantity);
    }

    public void viewCart() {
        cart.displayCart();
    }

    public boolean placeOrder() {
        return cart.checkout();
    }
}