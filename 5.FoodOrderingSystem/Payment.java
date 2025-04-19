public class Payment {
    private double amount;
    private String paymentWay;
    private boolean paid;

    public Payment(double amount, String paymentWay) {
        this.amount = amount;
        this.paymentWay = paymentWay;
        this.paid = false;
    }

    public boolean processPayment() {
        if (amount > 0) {
            System.out.println("Processing " + paymentWay + " payment of " + amount);
            this.paid = true;
            return true;
        }
        System.out.println("Invalid payment amount.");
        return false;
    }
}
