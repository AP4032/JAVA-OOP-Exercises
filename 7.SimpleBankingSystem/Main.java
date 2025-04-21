import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        System.out.println("=== Simple Banking System ===");

        boolean running = true;
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add Customer");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Show All Customers");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter account number: ");
                    String accNumber = scanner.nextLine();
                    bank.addCustomer(name, accNumber);
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    String accDeposit = scanner.nextLine();
                    Customer custDeposit = bank.findCustomer(accDeposit);
                    if (custDeposit != null) {
                        System.out.print("Enter amount to deposit: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();
                        custDeposit.deposit(amount);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    String accWithdraw = scanner.nextLine();
                    Customer custWithdraw = bank.findCustomer(accWithdraw);
                    if (custWithdraw != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();
                        custWithdraw.withdraw(amount);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    String accCheck = scanner.nextLine();
                    Customer custCheck = bank.findCustomer(accCheck);
                    if (custCheck != null) {
                        custCheck.checkBalance();
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 5:
                    showAllCustomers(bank);
                    break;

                case 6:
                    running = false;
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }

    public static void showAllCustomers(Bank bank) {
        System.out.println("--- List of Customers ---");
        if (bank.getAllCustomers().isEmpty()) {
            System.out.println("No customers available.");
        } else {
            for (Customer c : bank.getAllCustomers()) {
                System.out.println("Name: " + c.getName() + " | Account No: " + c.getAccountNumber());
            }
        }
    }
}