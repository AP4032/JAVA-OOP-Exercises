import java.util.ArrayList;
import java.util.List;

public class Bank
{
    public List<Customer> customers;

    public Bank()
    {
        this.customers = new ArrayList<>();
    }
    public void addCustomer(Customer customer)
    {
        customers.add(customer);
        System.out.println("New customer added...\nName: " + customer.getName()
                           + "\nAccountNumber: " + customer.getAccountNumber());
    }
}