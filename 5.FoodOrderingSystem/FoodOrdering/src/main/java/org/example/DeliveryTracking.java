package org.example;

public class DeliveryTracking {
    private String deliveryStatus;
    private String trackingNumber;

    public DeliveryTracking(String trackingNumber) {
        this.trackingNumber = trackingNumber;
        this.deliveryStatus = "Pending";
    }

    public void updateStatus(String status) {
        this.deliveryStatus = status;
        System.out.println("Delivery status updated to: " + status);
    }

    public String getStatus() {
        return deliveryStatus;
    }
}
