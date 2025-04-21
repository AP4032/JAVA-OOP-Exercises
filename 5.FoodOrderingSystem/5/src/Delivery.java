public class Delivery {
    private String deliveryId;
    private String address;
    private String status;
    private String estimatedTime;

    public Delivery(String deliveryId, String address) {
        this.deliveryId = deliveryId;
        this.address = address;
        this.status = "PREPARING";
    }

    public void updateStatus(String status, String estimatedTime) {
        this.status = status;
        this.estimatedTime = estimatedTime;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public String getAddress() {
        return address;
    }

    public String getStatus() {
        return status;
    }

    public String getEstimatedTime() {
        return estimatedTime;
    }
}