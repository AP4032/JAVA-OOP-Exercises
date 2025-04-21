public class Bank {
    public Customer[] customers;
    private int customerCount;

    public Bank(int capacity) {
        customers = new Customer[capacity];
        customerCount = 0;
    }

    public void addCustomer(Customer customer) {
        if (customerCount < customers.length) {
            customers[customerCount] = customer;
            customerCount++;
            System.out.println("New customer added: " + customer);
        } else {
            System.out.println("Bank is at full capacity. Cannot add more customers.");
        }
    }
}