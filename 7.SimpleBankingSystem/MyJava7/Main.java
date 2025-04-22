package MyJava7;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Bank System!");

        while (true) {
            System.out.println("\n1. Register Customer");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show Account Info");
            System.out.println("5. List All Customers");
            System.out.println("6. Show Transaction History");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> {
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    bank.registerCustomer(name);
                }
                case 2 -> {
                    System.out.print("Enter account number: ");
                    String accNum = scanner.nextLine();
                    Customer customer = bank.getCustomerByAccount(accNum);
                    if (customer != null) {
                        System.out.print("Enter deposit amount: ");
                        double amt = scanner.nextDouble();
                        if (customer.getAccount().deposit(amt))
                            System.out.println("Deposit successful.");
                        else
                            System.out.println("Invalid deposit amount.");
                    } else {
                        System.out.println("Account not found.");
                    }
                }
                case 3 -> {
                    System.out.print("Enter account number: ");
                    String accNum = scanner.nextLine();
                    Customer customer = bank.getCustomerByAccount(accNum);
                    if (customer != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double amt = scanner.nextDouble();
                        if (customer.getAccount().withdraw(amt))
                            System.out.println("Withdrawal successful.");
                        else
                            System.out.println("Insufficient funds or invalid amount.");
                    } else {
                        System.out.println("Account not found.");
                    }
                }
                case 4 -> {
                    System.out.print("Enter account number: ");
                    String accNum = scanner.nextLine();
                    Customer customer = bank.getCustomerByAccount(accNum);
                    if (customer != null) {
                        customer.showSummary();
                    } else {
                        System.out.println("Account not found.");
                    }
                }
                case 5 -> bank.displayAllCustomers();
                case 6 -> {
                    System.out.print("Enter account number: ");
                    String accNum = scanner.nextLine();
                    Customer customer = bank.getCustomerByAccount(accNum);
                    if (customer != null) {
                        customer.getAccount().printTransactionHistory();
                    } else {
                        System.out.println("Account not found.");
                    }
                }
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
