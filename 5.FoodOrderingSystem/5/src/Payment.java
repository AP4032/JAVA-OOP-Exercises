public class Payment {
    private String paymentId;
    private double amount;
    private String method;
    private boolean isPaid;

    public Payment(String paymentId, double amount, String method) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.method = method;
        this.isPaid = false;
    }

    public void processPayment() {
        this.isPaid = true;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public String getMethod() {
        return method;
    }

    public boolean isPaid() {
        return isPaid;
    }
}