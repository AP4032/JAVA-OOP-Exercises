import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank(10);
        boolean running = true;

        System.out.println("=== Simple Banking System ===");

        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add Customer");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. View Transaction History");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    Customer customer = new Customer(customerName, accountNumber);
                    bank.addCustomer(customer);
                    System.out.println("Customer added: " + customerName);
                    break;

                case 2:
                    System.out.print("Enter customer name: ");
                    String depositName = scanner.nextLine();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();

                    Customer depositCustomer = findCustomerByName(bank, depositName);
                    if (depositCustomer != null) {
                        depositCustomer.depositMoney(depositAmount);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter customer name: ");
                    String withdrawName = scanner.nextLine();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine();

                    Customer withdrawCustomer = findCustomerByName(bank, withdrawName);
                    if (withdrawCustomer != null) {
                        withdrawCustomer.withdrawMoney(withdrawAmount);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter customer name: ");
                    String balanceName = scanner.nextLine();

                    Customer balanceCustomer = findCustomerByName(bank, balanceName);
                    if (balanceCustomer != null) {
                        balanceCustomer.checkBalance();
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter customer name: ");
                    String historyName = scanner.nextLine();
                    Customer historyCustomer = findCustomerByName(bank, historyName);
                    if (historyCustomer != null) {
                        historyCustomer.getAccount().printTransactionHistory();
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 6:
                    running = false;
                    System.out.println("Exiting... You exited.");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }

    public static Customer findCustomerByName(Bank bank, String name) {
        for (int i = 0; i < bank.customers.length; i++) {
            if (bank.customers[i] != null && bank.customers[i].getName().equals(name)) {
                return bank.customers[i];
            }
        }
        return null;
    }
}