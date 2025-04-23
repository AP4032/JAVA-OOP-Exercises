package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank(5);
        OnlineBanking onlineBanking = new OnlineBanking(bank);

        System.out.println("Welcome to the Online Banking System!");

        boolean running = true;
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Apply Interest");
            System.out.println("6. Check Account Balance");
            System.out.println("7. View Transaction History");
            System.out.println("8. Exit");

            System.out.print("choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    Customer customer = new Customer(customerName);
                    bank.addCustomer(customer);
                    System.out.println("Customer " + customerName + " added.");
                    break;

                case 2:
                    System.out.print("Enter customer name: ");
                    customerName = scanner.nextLine();
                    Customer existingCustomer = bank.getCustomer(customerName);
                    if (existingCustomer != null) {
                        System.out.print("Enter account type (checking/savings): ");
                        String accountType = scanner.nextLine();
                        System.out.print("Enter initial deposit: ");
                        double initialDeposit = scanner.nextDouble();
                        scanner.nextLine(); // Consume the newline

                        if (accountType.equalsIgnoreCase("checking")) {
                            BankAccount checkingAccount = new BankAccount("CHK" + System.currentTimeMillis(), initialDeposit);
                            existingCustomer.addAccount(checkingAccount);
                            System.out.println("Created Checking account with number: " + checkingAccount.getAccountNumber());
                        } else if (accountType.equalsIgnoreCase("savings")) {
                            System.out.print("Enter interest rate: ");
                            double interestRate = scanner.nextDouble();
                            scanner.nextLine();
                            SavingsAccount savingsAccount = new SavingsAccount("SAV" + System.currentTimeMillis(), initialDeposit, interestRate);
                            existingCustomer.addAccount(savingsAccount);
                            System.out.println("Created Savings account with number: " + savingsAccount.getAccountNumber());
                        } else {
                            System.out.println("Invalid account type. Try again.");
                        }
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter customer name: ");
                    customerName = scanner.nextLine();
                    Customer depositCustomer = bank.getCustomer(customerName);
                    if (depositCustomer != null) {
                        System.out.print("Enter account number: ");
                        String accountNumber = scanner.nextLine();
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        scanner.nextLine();

                        BankAccount depositAccount = findAccount(depositCustomer, accountNumber);
                        if (depositAccount != null) {
                            depositAccount.deposit(depositAmount);
                            System.out.println("Deposited " + depositAmount + " to account " + accountNumber);
                        } else {
                            System.out.println("Account not found.");
                        }
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter customer name: ");
                    customerName = scanner.nextLine();
                    Customer withdrawCustomer = bank.getCustomer(customerName);
                    if (withdrawCustomer != null) {
                        System.out.print("Enter account number: ");
                        String withdrawAccountNumber = scanner.nextLine();
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        scanner.nextLine();

                        BankAccount withdrawAccount = findAccount(withdrawCustomer, withdrawAccountNumber);
                        if (withdrawAccount != null) {
                            withdrawAccount.withdraw(withdrawAmount);
                            System.out.println("Withdrew " + withdrawAmount + " from account " + withdrawAccountNumber);
                        } else {
                            System.out.println("Account not found.");
                        }
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter customer name: ");
                    customerName = scanner.nextLine();
                    Customer customerForInterest = bank.getCustomer(customerName);
                    if (customerForInterest != null) {
                        System.out.print("Enter savings account number: ");
                        String savingsAccountNumber = scanner.nextLine();

                        BankAccount savingsAccount = findAccount(customerForInterest, savingsAccountNumber);
                        if (savingsAccount instanceof SavingsAccount) {
                            ((SavingsAccount) savingsAccount).applyingInterest();
                            System.out.println("Interest applied to savings account " + savingsAccountNumber);
                        } else {
                            System.out.println("Not a savings account.");
                        }
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 6:
                    System.out.print("Enter customer name: ");
                    customerName = scanner.nextLine();
                    System.out.print("Enter account number: ");
                    String accountNum = scanner.nextLine();
                    onlineBanking.checkingBalance(customerName, accountNum);
                    break;

                case 7:
                    System.out.print("Enter customer name: ");
                    customerName = scanner.nextLine();
                    System.out.print("Enter account number: ");
                    String accountHistoryNum = scanner.nextLine();
                    Customer customerForHistory = bank.getCustomer(customerName);
                    if (customerForHistory != null) {
                        BankAccount accountHistory = findAccount(customerForHistory, accountHistoryNum);
                        if (accountHistory != null) {
                            System.out.println("Transaction History for account " + accountHistoryNum + ":");
                            for (String transaction : accountHistory.getTransactionHistory()) {
                                System.out.println(transaction);
                            }
                        } else {
                            System.out.println("Account not found.");
                        }
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 8:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    public static BankAccount findAccount(Customer customer, String accountNumber) {
        for (BankAccount account : customer.getAccounts()) {
            if (account != null && account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}
