public class Bank {
    private Customer[] customers;
    private int customerCount;

    public Bank(int maxCustomers) {
        this.customers = new Customer[maxCustomers];
        this.customerCount = 0;
    }
    public void addCustomer(Customer customer) {
        for (int i = 0; i < customerCount; i++) {
            if (customer.equals(customers[i])) {
                System.out.println("Customer already exists.");
                return;
            }
        }
        if (customerCount < customers.length) {
            customers[customerCount] = customer;
            customerCount++;
            System.out.println("Customer " + customer.getName() + " added successfully.");
        } else {
            System.out.println("Bank has reached its maximum number of customers.");
        }
    }
    public Customer getCustomer(String name) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getName().equals(name)) {
                return customers[i];
            }
        }
        return null;
    }
}
