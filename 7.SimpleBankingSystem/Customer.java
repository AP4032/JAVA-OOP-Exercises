import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Customer Class
class Customer {
    private int customerId;
    private String name;
    private String address;

    // Static variable to keep track of the next customer ID
    private static int nextCustomerId = 1000; // Start from 1000 for example

    public Customer(int customerId, String name, String address) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void displayCustomerInfo() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
    }

    // Static method to generate a unique customer ID
    public static int generateNextCustomerId() {
        return nextCustomerId++;
    }
}
