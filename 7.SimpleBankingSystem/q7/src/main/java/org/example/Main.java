package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scannerI = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create new customer");
            System.out.println("2. See all customers");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            while (!scannerI.hasNextInt()) {
                System.out.println("Invalid option. Try again.");
                scannerI.next();
            }
            int choice = scannerI.nextInt();
            scannerI.nextLine();

            switch (choice) {
                case 1:
                    thingsTodo(bank);
                    break;
                case 2:
                    bank.showAllCustomers();
                    break;
                case 3:
                    System.out.println("Ok, goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    public static void thingsTodo(Bank bank) {
        Scanner scannerI = new Scanner(System.in);
        Scanner scannerS = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = scannerS.nextLine();
        System.out.print("Enter account number: ");
        int accNumber = scannerI.nextInt();
        System.out.print("Is this a saving account? (y/n): ");
        char isSavingInput = scannerS.next().charAt(0);
        boolean isSaving = (isSavingInput == 'y');
        Customer currentCustomer = new Customer(name, accNumber, isSaving);
        bank.addCustomer(currentCustomer);
        System.out.println("Customer created and selected.");

        while (true) {
            System.out.println("1. Deposit money");
            System.out.println("2. Withdraw money");
            System.out.println("3. Check balance");
            System.out.println("4. Show transaction history");
            System.out.println("5. Apply interest (for saving account)");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            while (!scannerI.hasNextInt()) {
                System.out.println("Invalid option. Try again.");
                scannerI.next();
            }
            int choice = scannerI.nextInt();
            scannerI.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scannerI.nextDouble();
                    currentCustomer.depositMoney(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scannerI.nextDouble();
                    currentCustomer.withdrawMoney(withdrawAmount);
                    break;
                case 3:
                    currentCustomer.checkBalance();
                    break;
                case 4:
                    currentCustomer.showTransactionHistory();
                    break;
                case 5:
                    currentCustomer.applyInterestIfSaving();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}