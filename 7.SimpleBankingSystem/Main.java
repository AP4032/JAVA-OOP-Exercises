import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
//        Customer customer1 = new Customer("Alice", "123456");
//        Customer customer2 = new Customer("Bob", "789101");
//
//        bank.addCustomer(customer1);
//        bank.addCustomer(customer2);
//
//        customer1.depositMoney(500);
//        customer1.withdrawMoney(200);
//        customer1.checkBalance();

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Banking System ===");
        boolean running = true;
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Create Bank Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Account Balance");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.println("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    Customer customer = new Customer(customerName, accountNumber);
                    bank.addCustomer(customer);
                    break;
                case 2:
                    System.out.println("Enter account number: ");
                    String accountNumberForDeposit = scanner.nextLine();
                    Customer customerForDeposit = findCustomer(accountNumberForDeposit, bank);
                    if (customerForDeposit != null) {
                        System.out.println("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        customerForDeposit.getAccount().deposit(depositAmount);
                    } else {
                        System.out.println("Customer not found!");
                    }
                    break;

                case 3:
                    System.out.println("Enter account number: ");
                    String accountNumberForWithdraw = scanner.nextLine();
                    Customer customerForWithdraw = findCustomer(accountNumberForWithdraw, bank);
                    if (customerForWithdraw != null) {
                        double withdrawAmount;
                        do{
                            System.out.println("Enter withdraw amount: ");
                            withdrawAmount = scanner.nextDouble();
                            if (customerForWithdraw.getAccount().getBalance() - withdrawAmount < 0){
                                System.out.println("Insufficient balance!");
                            }
                        }
                        while (customerForWithdraw.getAccount().getBalance() - withdrawAmount < 0);

                        customerForWithdraw.getAccount().withdraw(withdrawAmount);
                    } else {
                        System.out.println("Customer not found!");
                    }
                    break;

                    case 4:
                        System.out.println("Enter account number: ");
                        String accountNumberToShowBalance = scanner.nextLine();
                        Customer customerToShowBalance = findCustomer(accountNumberToShowBalance, bank);
                        if (customerToShowBalance != null) {
                            customerToShowBalance.checkBalance();
                        }else{
                            System.out.println("Customer not found!");
                        }
                        break;
                        case 0:
                            running = false;
            }
        }

    }

    public static Customer findCustomer(String accountNumber, Bank bank) {
        for (Customer customer : bank.getCustomers()) {
            if (customer.getAccount().getAccountNumber().equals(accountNumber)) {
                return customer;
            }
        }
        return null;
    }
}