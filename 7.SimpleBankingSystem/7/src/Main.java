import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank("Persian International Bank");
        OnlineBankingSystem onlineBanking = new OnlineBankingSystem(bank);

        System.out.println("=== Persian Banking System ===");

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Bank Administration");
            System.out.println("2. Customer Access");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    adminMenu(bank, scanner);
                    break;
                case 2:
                    onlineBanking.start();
                    break;
                case 3:
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void adminMenu(Bank bank, Scanner scanner) {
        while (true) {
            System.out.println("\nBank Administration Menu:");
            System.out.println("1. Add New Customer");
            System.out.println("2. View Bank Information");
            System.out.println("3. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addNewCustomer(bank, scanner);
                    break;
                case 2:
                    bank.displayBankInfo();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addNewCustomer(Bank bank, Scanner scanner) {
        System.out.println("\nAdd New Customer");
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();

        System.out.print("Set password: ");
        String password = scanner.nextLine();

        Customer newCustomer = new Customer(name, customerId, password);
        bank.addCustomer(newCustomer);

        System.out.println("\nCreate first account for this customer:");
        System.out.println("1. Regular Account");
        System.out.println("2. Savings Account");
        System.out.print("Enter account type: ");
        int accountType = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        BankAccount account;
        if (accountType == 2) {
            System.out.print("Enter interest rate (%): ");
            double interestRate = scanner.nextDouble();
            scanner.nextLine();
            account = new SavingsAccount(accountNumber, interestRate);
        } else {
            account = new BankAccount(accountNumber);
        }

        newCustomer.addAccount(account);
        System.out.println("Customer and account created successfully!");
    }
}