import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create the bank and customers
        Bank bank = new Bank();

        // Initialize scanner for user input
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display the main menu
            System.out.println("\n--- Banking System Menu ---");
            System.out.println("1. Register new customer");
            System.out.println("2. View balance");
            System.out.println("3. Deposit money");
            System.out.println("4. Withdraw money");
            System.out.println("5. Transfer money");
            System.out.println("6. View transaction history");
            System.out.println("7. Apply interest (for savings accounts)");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    // Register new customer
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter your desired account number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter account type (savings/regular): ");
                    String accountType = scanner.nextLine();

                    boolean isSavingsAccount = accountType.equalsIgnoreCase("savings");

                    Customer newCustomer = new Customer(name, accountNumber, isSavingsAccount);
                    bank.addCustomer(newCustomer);
                    System.out.println("New customer registered: " + newCustomer.getName());
                    break;

                case 2:
                    // View balance
                    System.out.print("Enter your name: ");
                    String customerNameForBalance = scanner.nextLine();
                    Customer customerForBalance = bank.getCustomer(customerNameForBalance);
                    if (customerForBalance != null) {
                        customerForBalance.checkBalance();
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 3:
                    // Deposit money
                    System.out.print("Enter your name: ");
                    String customerNameForDeposit = scanner.nextLine();
                    Customer customerForDeposit = bank.getCustomer(customerNameForDeposit);
                    if (customerForDeposit != null) {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        customerForDeposit.depositMoney(depositAmount);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 4:
                    // Withdraw money
                    System.out.print("Enter your name: ");
                    String customerNameForWithdrawal = scanner.nextLine();
                    Customer customerForWithdrawal = bank.getCustomer(customerNameForWithdrawal);
                    if (customerForWithdrawal != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        customerForWithdrawal.withdrawMoney(withdrawAmount);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 5:
                    // Transfer money
                    System.out.print("Enter your name: ");
                    String customerNameForTransfer = scanner.nextLine();
                    Customer customerForTransfer = bank.getCustomer(customerNameForTransfer);
                    if (customerForTransfer != null) {
                        System.out.print("Enter recipient's name: ");
                        String recipientName = scanner.nextLine();
                        Customer recipientCustomer = bank.getCustomer(recipientName);
                        if (recipientCustomer != null) {
                            System.out.print("Enter amount to transfer: ");
                            double transferAmount = scanner.nextDouble();
                            customerForTransfer.transferMoney(recipientCustomer, transferAmount);
                        } else {
                            System.out.println("Recipient not found.");
                        }
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 6:
                    // View transaction history
                    System.out.print("Enter your name: ");
                    String customerNameForHistory = scanner.nextLine();
                    Customer customerForHistory = bank.getCustomer(customerNameForHistory);
                    if (customerForHistory != null) {
                        customerForHistory.showTransactionHistory();
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 7:
                    // Apply interest (for savings accounts only)
                    System.out.print("Enter your name: ");
                    String customerNameForInterest = scanner.nextLine();
                    Customer customerForInterest = bank.getCustomer(customerNameForInterest);
                    if (customerForInterest != null) {
                        customerForInterest.applyInterest();
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 8:
                    // Exit the program
                    System.out.println("Thank you for using the banking system. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
