import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
        int choice;

        System.out.println("Welcome to our Bank Management System!");
        System.out.println("Please register your account in our customer list.");
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Enter account number: ");
        String accountNumber = sc.nextLine();
        Customer customer = new Customer(name, accountNumber);
        bank.addCustomer(customer);
        do
        {
            System.out.println("What would you like to do?");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            choice = sc.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Enter your preferred amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    customer.depositMoney(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter your preferred amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    customer.withdrawMoney(withdrawAmount);
                    break;
                case 3:
                    customer.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for choosing our bank.\nExiting...");
                    break;
            }
        }while(choice != 4);
    }
}