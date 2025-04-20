import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\n📋 Choose an option:");
            System.out.println("1. Create new customer");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Check balance");
            System.out.println("5. List all customers");
            System.out.println("0. Exit");
            System.out.print(" Option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter account number: ");
                    String accNum = scanner.nextLine();
                    Customer customer = new Customer(name, accNum);
                    bank.addCustomer(customer);
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    String accNum2 = scanner.nextLine();
                    Customer cust2 = bank.findCustomer(accNum2);
                    if (cust2 != null) {
                        System.out.print("Enter amount to deposit: ");
                        double dep = scanner.nextDouble();
                        cust2.depositMoney(dep);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    String accNum3 = scanner.nextLine();
                    Customer cust3 = bank.findCustomer(accNum3);
                    if (cust3 != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double wit = scanner.nextDouble();
                        cust3.withdrawMoney(wit);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    String accNum4 = scanner.nextLine();
                    Customer cust4 = bank.findCustomer(accNum4);
                    if (cust4 != null) {
                        cust4.checkBalance();
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 5:
                    bank.listCustomers();
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
