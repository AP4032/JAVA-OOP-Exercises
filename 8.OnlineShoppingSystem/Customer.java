public class Customer {
    private double accountBalance;
    private String name;
    private ShoppingCart cart;

    public Customer() {
        this.cart = new ShoppingCart();
    }

    public void addToCart(Product product) {
        cart.addItem(product);
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
    public String getname() {
        return name;
    }
    public double getAccountBalance() {
        return accountBalance;
    }
    public void placeOrder() {
        cart.checkout();
    }
}