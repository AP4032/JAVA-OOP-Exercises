import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Scanner numScanner = new Scanner(System.in);
        Scanner strScanner = new Scanner(System.in);
        Bank bank = new Bank();

        boolean running = true;
        while (running) {
            System.out.println("=== Simple Banking System ===");
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Show All Accounts");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = numScanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Customer Name: ");
                    String name = strScanner.nextLine();
                    Customer customer = new Customer(name);
                    bank.addCustomer(customer);
                    System.out.println("Account created with account number " + customer.getAccountNumber());
                    break;

                case 2:
                    System.out.print("Enter Account number: ");
                    long accountNumberDe = numScanner.nextLong();
                    Customer customerDe = findCustomerByAccountNumber(bank, accountNumberDe);
                    if (customerDe == null) {
                        System.out.println("Account not found with account number " + accountNumberDe);
                    }
                    else {
                        System.out.print("Enter your desire amount for deposit: ");
                        double depositAmount = strScanner.nextDouble();
                        customerDe.depositMoney(depositAmount);
                    }
                    break;

                case 3:
                    System.out.print("Enter Account number: ");
                    long accountNumberWi = numScanner.nextLong();
                    Customer customerWi = findCustomerByAccountNumber(bank, accountNumberWi);
                    if (customerWi == null) {
                        System.out.println("Account not found with account number " + accountNumberWi);
                    }
                    else {
                        System.out.print("Enter your desire amount for withdraw: ");
                        double withdrawAmount = strScanner.nextDouble();
                        customerWi.withdrawMoney(withdrawAmount);
                    }
                    break;

                case 4:
                    System.out.print("Enter Account number: ");
                    long accountNumberCh = numScanner.nextLong();
                    Customer customerCh = findCustomerByAccountNumber(bank, accountNumberCh);
                    if (customerCh == null) {
                        System.out.println("Account not found with account number " + accountNumberCh);
                    }
                    else {
                        customerCh.checkBalance();
                    }
                    break;

                case 5:
                    showAllAccounts(bank);
                    break;
            }
        }
    }

    public static Customer findCustomerByAccountNumber(Bank bank, long accountNumber) {
        for (Customer c : bank.getCustomers()){
            if (c.getAccountNumber() == accountNumber){
                return c;}
        }
        return null;
    }

    public static void showAllAccounts(Bank bank) {
        if (bank.getCustomers().isEmpty()) {
            System.out.println("No customer found.");
        }
        else {
            System.out.println("--- All Accounts ---");
            for (Customer c : bank.getCustomers()){
                System.out.println("Name: " + c.getName() + " | Account Number: " + c.getAccountNumber() +
                        " | Balance: " + c.getBalance());
            }
        }
    }
}
