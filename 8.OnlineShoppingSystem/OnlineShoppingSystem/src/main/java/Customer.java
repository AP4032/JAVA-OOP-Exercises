public class Customer {
    private String username;
    private String phoneNumber;
    private double walletBalance;
    private ShoppingCart shoppingCart;

    public Customer(String username, String phoneNumber, double walletBalance) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.walletBalance = walletBalance;
        this.shoppingCart = new ShoppingCart();
    }

    public void addToCart(Product product, int quantity) {
        shoppingCart.addItem(product, quantity);
    }

    public void viewCart() {
        shoppingCart.viewCart();
    }

    public void placeOrder() {
        double total = shoppingCart.calculateTotal();
        if (walletBalance >= total) {
            walletBalance -= total;
            shoppingCart.checkout();
            System.out.println("Order placed. Remaining wallet balance: $" + walletBalance);
        } else {
            System.out.println("Not enough balance in wallet. Needed: $" + total);
        }
    }

    public void addFunds(double amount) {
        if (amount > 0) {
            walletBalance += amount;
            System.out.println("$" + amount + " added to wallet. New balance: $" + walletBalance);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }
}
