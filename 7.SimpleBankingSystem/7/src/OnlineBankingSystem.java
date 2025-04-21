import java.util.Scanner;

public class OnlineBankingSystem {
    private Bank bank;
    private Scanner scanner;

    public OnlineBankingSystem(Bank bank) {
        this.bank = bank;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("\nWelcome to " + bank.getBankName() + " Online Banking");

        while (true) {
            System.out.println("\n1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                loginMenu();
            } else if (choice == 2) {
                System.out.println("Thank you for using our banking system. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void loginMenu() {
        System.out.print("\nEnter Customer ID: ");
        String customerId = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        Customer customer = bank.getCustomer(customerId);
        if (customer != null && customer.authenticate(password)) {
            customerMenu(customer);
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }

    private void customerMenu(Customer customer) {
        while (true) {
            System.out.println("\nWelcome, " + customer.getName());
            System.out.println("1. View All Accounts");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Apply Interest (Savings Account)");
            System.out.println("6. Logout");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    customer.displayAllAccounts();
                    break;
                case 2:
                    performDeposit(customer);
                    break;
                case 3:
                    performWithdrawal(customer);
                    break;
                case 4:
                    checkBalance(customer);
                    break;
                case 5:
                    applyInterest(customer);
                    break;
                case 6:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void performDeposit(Customer customer) {
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine();
        BankAccount account = customer.getAccount(accNum);

        if (account != null) {
            System.out.print("Enter Amount to Deposit: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            account.deposit(amount);
            bank.addTransaction(new Transaction(accNum, "DEPOSIT", amount, "Cash deposit"));
        } else {
            System.out.println("Account not found.");
        }
    }

    private void performWithdrawal(Customer customer) {
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine();
        BankAccount account = customer.getAccount(accNum);

        if (account != null) {
            System.out.print("Enter Amount to Withdraw: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            account.withdraw(amount);
            bank.addTransaction(new Transaction(accNum, "WITHDRAWAL", amount, "Cash withdrawal"));
        } else {
            System.out.println("Account not found.");
        }
    }

    private void checkBalance(Customer customer) {
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine();
        BankAccount account = customer.getAccount(accNum);

        if (account != null) {
            System.out.println("\nAccount Balance: $" + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    private void applyInterest(Customer customer) {
        System.out.print("Enter Savings Account Number: ");
        String accNum = scanner.nextLine();
        BankAccount account = customer.getAccount(accNum);

        if (account instanceof SavingsAccount) {
            SavingsAccount savingsAccount = (SavingsAccount) account;
            savingsAccount.applyInterest();
            bank.addTransaction(new Transaction(accNum, "INTEREST",
                    account.getBalance() * savingsAccount.getInterestRate() / 100,
                    "Interest applied"));
        } else {
            System.out.println("This is not a savings account or account not found.");
        }
    }
}