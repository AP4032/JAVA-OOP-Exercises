import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creating a bank
        System.out.println("Enter bank you want to invest in: ");
        System.out.println("choose bank : saderat---mellat---melli---keshavarzi---tejarat---maskan---refah ");
        Scanner sc = new Scanner(System.in);
        Bank myBank = new Bank(sc.nextLine());
        Scanner sc1 = new Scanner(System.in);
        // Creating initial customers
        List<Customer> initialCustomers = createInitialCustomers();

        // Creating bank accounts for initial customers
        for (Customer customer : initialCustomers) {
            BankAccount account = new BankAccount(generateAccountNumber(), 0.0, customer); // Random account number
            myBank.addAccount(account);
            System.out.println("Account created for customer " + customer.getName() + " with account number " + account.getAccountNumber() + ".");
        }

        // Main program loop for user interaction
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nWelcome to " + myBank.getBankName() + "!");
            System.out.println("1. Display account list");
            System.out.println("2. Deposit to account");
            System.out.println("3. Withdraw from account");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    myBank.displayAllAccounts();
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    int depositAccountNumber = scanner.nextInt();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    BankAccount depositAccount = myBank.findAccount(depositAccountNumber);
                    if (depositAccount != null) {
                        depositAccount.deposit(depositAmount);
                    } else {
                        System.out.println("Account with number " + depositAccountNumber + " not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    int withdrawAccountNumber = scanner.nextInt();
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    BankAccount withdrawAccount = myBank.findAccount(withdrawAccountNumber);
                    if (withdrawAccount != null) {
                        withdrawAccount.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Account with number " + withdrawAccountNumber + " not found.");
                    }
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Creating initial customers (you can read this from a file or database)
    private static List<Customer> createInitialCustomers() {
        List<Customer> customers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of customers you want to add: ");
        int numberOfCustomers = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < numberOfCustomers; i++) {
            System.out.println("\nEnter details for customer " + (i + 1) + ":");

            // Get customer name
            System.out.print("Enter customer name: ");
            String name = scanner.nextLine();

            // Get customer address
            System.out.print("Enter customer address: ");
            String address = scanner.nextLine();

            // Create a new customer object
            Customer customer = new Customer(Customer.generateNextCustomerId(), name, address);
            customers.add(customer);
        }

        return customers;
    }

    // Generating a random account number (for simplicity)
    private static int generateAccountNumber() {
        return (int) (Math.random() * 90000) + 10000; // 5-digit account number
    }
}
