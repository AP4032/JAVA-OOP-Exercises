import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        System.out.println("=== Simple Banking System \uD83D\uDCB0 ===");

        boolean running = true;
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add User");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Your Name: ");
                    String name = scanner.nextLine();

                    System.out.println("Enter Your Account Number");
                    String accountNumber = scanner.nextLine();

                    Customer customer = new Customer(name, accountNumber);
                    bank.addCustomer(customer);

                    break;
                case 2:
                    boolean done = false;
                    System.out.println("Enter Your Account Number: ");
                    String accountNumber2 = scanner.nextLine();
                    for (Customer customer2 : bank.getCustomers()) {
                        if (customer2.getAccount().getAccountNumber().equals(accountNumber2)) {
                            System.out.println("Please enter the amount you want to deposit.");
                            double amount = scanner.nextDouble();
                            customer2.depositMoney(amount);
                            done = true;
                        }
                    }
                    if (done) {break;}
                    System.out.println("User not found!");
                    break;

                case 3:
                    boolean done2 = false;
                    System.out.println("Enter Your Account Number: ");
                    String accountNumber3 = scanner.nextLine();
                    for (Customer customer3 : bank.getCustomers()) {
                        if (customer3.getAccount().getAccountNumber().equals(accountNumber3)) {
                            System.out.println("Please enter the amount you want to withdrawMoney.");
                            double amount = scanner.nextDouble();
                            customer3.withdrawMoney(amount);
                            done2 = true;
                        }
                    }
                    if (done2) {break;}
                    System.out.println("User not found!");
                    break;

                case 4:
                    boolean done3 = false;
                    System.out.println("Enter Your Account Number: ");
                    String accountNumber4 = scanner.nextLine();
                    for (Customer customer4 : bank.getCustomers()) {
                        if (customer4.getAccount().getAccountNumber().equals(accountNumber4)) {
                            customer4.checkBalance();
                            done3 = true;
                        }
                    }
                    if (done3) {break;}
                    System.out.println("User not found!");
                    break;

                case 5:
                    running = false;
            }
        }
    }
}