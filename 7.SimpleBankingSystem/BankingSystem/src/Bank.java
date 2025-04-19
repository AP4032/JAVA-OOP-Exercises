import java.util.Scanner;
public class Bank {



    private Customer customer;
    private Scanner scanner = new Scanner(System.in);

    public Bank(Customer customer) {
        this.customer = customer;
    }

    public void start() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\n************");
            System.out.println("BANKING PROGRAM");
            System.out.println("************");
            System.out.println("1. Show Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.println("Enter your choice (1-4): ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.printf("Balance: $%.2f\n", customer.getAccount().getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    customer.getAccount().deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    customer.getAccount().withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
        scanner.close();
    }
}
