package SimpleBanking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        System.out.println("Welcome to the Simple Banking System!");

        boolean running = true;
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Create Account (Checking/Savings)");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Calculate Interest (Savings Account)");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Do you want a Savings account? (yes/no): ");
                    String accountType = scanner.nextLine();
                    boolean isSavings = accountType.equalsIgnoreCase("yes");
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    Customer customer = new Customer(name, accountNumber, isSavings);
                    bank.addCustomer(customer);
                    break;

                case 2:
                    System.out.print("Enter your name: ");
                    String depositName = scanner.nextLine();
                    Customer depositCustomer = bank.findCustomerByName(depositName);
                    if (depositCustomer != null) {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        depositCustomer.depositMoney(depositAmount);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter your name: ");
                    String withdrawName = scanner.nextLine();
                    Customer withdrawCustomer = bank.findCustomerByName(withdrawName);
                    if (withdrawCustomer != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        withdrawCustomer.withdrawMoney(withdrawAmount);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter your name: ");
                    String balanceName = scanner.nextLine();
                    Customer balanceCustomer = bank.findCustomerByName(balanceName);
                    if (balanceCustomer != null) {
                        balanceCustomer.checkBalance();
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter your name: ");
                    String interestName = scanner.nextLine();
                    Customer interestCustomer = bank.findCustomerByName(interestName);
                    if (interestCustomer != null) {
                        interestCustomer.calculateInterest();
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 6:
                    running = false;
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
