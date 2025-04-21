public abstract class Payment {
    protected double amount;
    protected String transactionId;

    public Payment(double amount) {
        this.amount = amount;
        this.transactionId = "TXN" + System.currentTimeMillis();
    }

    public abstract boolean processPayment();
    public abstract void displayPaymentDetails();

    // Getters
    public String getTransactionId() { return transactionId; }
    public double getAmount() { return amount; }
}

class CreditCardPayment extends Payment {
    private String cardNumber;
    private String expiryDate;
    private String cvv;

    public CreditCardPayment(double amount, String cardNumber, String expiryDate, String cvv) {
        super(amount);
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public boolean processPayment() {
        // Simulate payment processing
        System.out.println("Processing credit card payment...");
        return true;
    }

    @Override
    public void displayPaymentDetails() {
        System.out.println("\nPayment Method: Credit Card");
        System.out.println("Card Number: ****-****-****-" + cardNumber.substring(12));
        System.out.println("Amount: $" + amount);
    }
}

class PayPalPayment extends Payment {
    private String email;

    public PayPalPayment(double amount, String email) {
        super(amount);
        this.email = email;
    }

    @Override
    public boolean processPayment() {
        // Simulate payment processing
        System.out.println("Processing PayPal payment...");
        return true;
    }

    @Override
    public void displayPaymentDetails() {
        System.out.println("\nPayment Method: PayPal");
        System.out.println("Email: " + email);
        System.out.println("Amount: $" + amount);
    }
}