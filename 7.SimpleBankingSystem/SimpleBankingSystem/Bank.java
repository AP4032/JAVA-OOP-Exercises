import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
    private List<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name:");
        String name = scanner.next();

        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Enter your accountNumber:");
        int accountNumber = scanner2.nextInt();
        customers.add(new Customer("Alice", 123456));
        customers.add(new Customer("Bob", 789101));
        customers.add(new Customer(name, accountNumber));
        for (int i = 0; i < customers.size(); i++) {
            Customer bank = customers.get(i);

            System.out.println("user " + bank.getName() +"|" + bank.getAccount());

        }
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("New customer added: " + customer);
    }

}
