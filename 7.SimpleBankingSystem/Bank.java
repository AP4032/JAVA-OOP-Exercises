import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Bank {
    private List<Customer>customers;
    private List<String> history;

    public Bank(){
        this.customers = new ArrayList<>();
        this.history = new ArrayList<>();
    }
    public Customer registerCustomer(){
        System.out.println("Welcome to the Bank! ");
        System.out.println("Please enter your name: ");
        Scanner scanner = new Scanner(System.in);
        Customer c1 = new Customer(scanner.nextLine());
        addCustomer(c1);
        return c1;
    }
    public BankAccount createAccount() {
        Random random = new Random();
        int accountNumber = random.nextInt();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 for a savings account or 2 for a checking account: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            BankAccount bankAccount = new SavingsAccount(accountNumber);
            System.out.println("Savings Account created!");
            return bankAccount;
        } else if (choice == 2) {
            BankAccount bankAccount = new CheckingAccount(accountNumber);
            System.out.println("Checking Account created!");
            return bankAccount;
        } else {
            System.out.println("Invalid choice!");
        }
        return null;
    }
    public void start(){
        Customer customer= registerCustomer();
        BankAccount bankAccount = createAccount();
        run(bankAccount);
    }
    public void run(BankAccount bankAccount) {
        int choice;
        do {
            System.out.println("Choose what you want to do now: ");
            System.out.println("1.Deposit 2.Withdraw 3.CheckBalance 4.Exit 5.Transaction History");
            Scanner s = new Scanner(System.in);
            choice = s.nextInt();
            s.nextLine();
            if (choice == 1) {
                System.out.println("Enter the amount: ");
                double amount = s.nextDouble();
                s.nextLine();
                bankAccount.deposit(amount);
                history.add("deposit");
            } else if (choice == 2) {
                System.out.println("Enter the amount: ");
                double amount = s.nextDouble();
                s.nextLine();
                bankAccount.withdraw(amount);
                history.add("Withdraw");
            } else if (choice == 3) {
                bankAccount.checkBalance();
            } else if (choice == 4) {
                System.out.println("Goodbye!");
            } else if (choice == 5) {
                history();
            } else {
                System.out.println("Invalid choice!");
            }
        }while (choice != 4) ;
    }
    public void addCustomer(Customer customer){
        customers.add(customer);
        System.out.println("Customer " + customer.getName() + " added!");
    }
    public void history(){
        for (String s : history) {
            System.out.println(s);
        }
    }
}
