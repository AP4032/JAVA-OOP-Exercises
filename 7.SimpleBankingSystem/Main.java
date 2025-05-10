
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Bank bank = new Bank();
    public static void main(String[] args) {
        System.out.println("********** Welcome to Simple Banking System **********");
        mainMenu();
        System.out.println("Bye Bye .....");
    }
    private static void mainMenu(){
        System.out.println("-------* Main Menu *-------");
        System.out.println("1. Create account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Get Balance");
        System.out.println("5. Display your information");
        System.out.println("6. Show All Customers");
        System.out.println("7. Exit");
        System.out.println("Enter your choice:");
        do {
            int choice=Utils.getNum();
            switch (choice) {
                case 1:
                    createAccount();
                    mainMenu();
                    return;
                case 2:
                    depositMoney();
                    mainMenu();
                    return;
                case 3:
                    withdrawMoney();
                    mainMenu();
                    return;
                case 4:
                    getBalance();
                    mainMenu();
                    return;
                case 5:
                    displayInfo();
                    mainMenu();
                    return;
                case 6:
                    showAllCustomers();
                    mainMenu();
                    return;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice!, try again");
            }
        }while (true);
    }
    private static void createAccount() {
        System.out.println("********** Creat Account **********");
        System.out.println("Enter your name:");
        String name = Utils.getString();
        if (!(bank.getCustomers().isEmpty())){
            for (Customer c : bank.getCustomers()) {
                if(c.getName().equals(name) ){
                    System.out.println("This name already exists!");
                    return;
                }
            }
        }
        Random rand = new Random();
        System.out.println("Enter your password: ");
        int password =Utils.getNum();
        String accountNumber = rand.nextInt(100000000) + "";
        Customer user= new Customer(name, accountNumber,password);
        System.out.println("Your password:"+user.getAccount().getPassword());
        System.out.println("Your account number: "+user.getAccount().getAccountNumber());
        System.out.println("please saved it and don't forget it");
        bank.addCustomer(user);
    }
    private static void displayInfo(){
        System.out.println("********** Display your info **********");
        Customer customer = Utils.getCustomer(bank);
        System.out.println("-----------------------------------------");
        System.out.println("Your name: "+customer.getName());
        System.out.println("Your password:"+customer.getAccount().getPassword());
        System.out.println("Your account number: "+customer.getAccount().getAccountNumber());
        System.out.println("Your balance: $"+customer.getAccount().getBalance());
        System.out.println("******************************************");
    }
    private static void depositMoney(){
        System.out.println("********** Deposit Money **********");
        Customer customer= Utils.getCustomer(bank);
        System.out.println("How much do you want to deposit?");
        double deposit=Utils.getDoubleNum();
        customer.depositMoney(deposit);
    }
    private static void withdrawMoney(){
        System.out.println("********** Withdraw Money **********");
        Customer customer= Utils.getCustomer(bank);
        System.out.println("How much do you want to withdraw?");
        double withdraw=Utils.getDoubleNum();
        customer.withdrawMoney(withdraw);

    }
    private static void getBalance(){
        System.out.println("********** Get Balance **********");
        Customer customer= Utils.getCustomer(bank);
        System.out.println("Your balance: $"+customer.getAccount().getBalance());
    }
    private static void showAllCustomers(){
        System.out.println("********** Show All Customers **********");
        int i=1;
        for (Customer c : bank.getCustomers()) {
            System.out.println(i+". Name: "+c.getName()+"  ------ Account Number: "+c.getAccount().getAccountNumber()+" ------ Balance: "+c.getAccount().getBalance());
            i++;
        }
    }
}