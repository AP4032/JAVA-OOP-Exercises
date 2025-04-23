package org.example;

public class Payment {
    private double amount;
    private String paymentWay;

    public Payment(double amount, String paymentWay) {
        this.amount = amount;
        this.paymentWay = paymentWay;
    }

    public boolean processingPayment() {
        if (amount > 0) {
            System.out.println("Payment of " + amount + " using " + paymentWay + " has been successful.");
            return true;
        } else {
            System.out.println("Payment failed. Invalid amount.");
            return false;
        }
    }

}
