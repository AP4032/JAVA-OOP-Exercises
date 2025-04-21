import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        Bank bank = new Bank();


        while (running) {

            System.out.println("=== Simple Banking System ===");
            System.out.println("1. add customer");
            System.out.println("2. deposit money");
            System.out.println("3. withdraw money");
            System.out.println("4. check balance");
            System.out.println("5. list of customers");
            System.out.println("6. exit");
            System.out.println("Enter your choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1 :

                    System.out.println("Enter customer name: ");
                    String name = scanner.nextLine();
                    boolean duplicate = true;
                    boolean check = false;
                    String accountNumber = null ;
                    while (duplicate) {
                        check = false ;
                        boolean checknum=  true;
                        while (checknum) {
                            System.out.println("enter your account number: ");
                            accountNumber = scanner.nextLine();
                            if (accountNumber.length() != 6) {
                                System.out.println("the account number must be 6 digits");
                                System.out.println("please try again");
                                System.out.println();
                            }
                            else{
                                checknum = false ;
                            }
                        }
                        for (Customer customer : bank.getCustomers()) {
                            if (customer.getAccount().getAccountNumber().equals(accountNumber)) {
                                System.out.println("this account number is already in use");
                                System.out.println("please try again!!!");
                                check = true;
                            }
                        }
                        if (!check) {
                            duplicate = false;
                        }
                    }
                    Customer newcustumer = new Customer(name , accountNumber);
                    bank.addCustomer(newcustumer);
                    break;

                case 2 :
                    System.out.println("Enter customer name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter customer account number : ");
                    accountNumber = scanner.nextLine();
                    Customer depositer = null ;
                    for (Customer customer : bank.getCustomers()) {
                        if (customer.getName().equals(name) && customer.getAccount().getAccountNumber().equals(accountNumber)) {
                            depositer = customer;
                        }
                    }
                    if (depositer == null) {
                        System.out.println("customer does not exist");
                    }
                    else {
                        System.out.println("enter the desired amount : ");
                        int amount = input.nextInt();
                        depositer.depositMoney(amount);
                    }
                    break;

                case 3 :
                    System.out.println("Enter customer name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter customer account number : ");
                    accountNumber = scanner.nextLine();
                    Customer withdrawer = null ;
                    for (Customer customer : bank.getCustomers()) {
                        if (customer.getName().equals(name) && customer.getAccount().getAccountNumber().equals(accountNumber)) {
                            withdrawer = customer;
                        }
                    }
                    if (withdrawer == null) {
                        System.out.println("customer does not exist");
                    }
                    else {
                        System.out.println("enter the desired amount : ");
                        int amount = input.nextInt();
                        withdrawer.withdrawMoney(amount);
                    }
                    break;
                case 4 :
                    System.out.println("Enter customer name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter customer account number : ");
                    accountNumber = scanner.nextLine();
                    Customer checker = null ;
                    for (Customer customer : bank.getCustomers()) {
                        if (customer.getName().equals(name) && customer.getAccount().getAccountNumber().equals(accountNumber)) {
                            checker = customer;
                        }
                    }
                    if (checker == null) {
                        System.out.println("customer does not exist");
                    }
                    else {
                        checker.checkBalance();
                    }
                    break;
                case 5 :
                    for(Customer customer : bank.getCustomers()) {
                        System.out.println("name : "+customer.getName()+"    " + "account number : "+ customer.getAccount().getAccountNumber() +"    "+ "balance: "+ customer.getAccount().getBalance());
                        System.out.println("-----------------------------------------------------------------------");
                    }
                    break;

                case 6 :
                    running = false;
                    System.out.println("Thank you for using our Banking System");
                    System.out.println("good bye !");
                    break;

                default :  System.out.println("wrong choice");
            }
        }

/*
        Customer customer1 = new Customer("Alice", "123456");
        Customer customer2 = new Customer("Bob", "789101");

        bank.addCustomer(customer1);
        bank.addCustomer(customer2);

        customer1.depositMoney(500);
        customer1.withdrawMoney(200);
        customer1.checkBalance();*/
    }
}