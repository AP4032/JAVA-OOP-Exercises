import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    static ArrayList<Customer> customers = new ArrayList<>();
    static ArrayList<BankAccount> accounts = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static Scanner input2 = new Scanner(System.in);
    static Random rand = new Random();
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for (Customer customer : customers) {
                    customer.applyInterest();
                }
            }
            }, 0, 1000);
        mainmenu();
    }
    public static void mainmenu(){
        System.out.println("Welcome to the Bank");
        System.out.println("Choose an option:");
        System.out.println("1. Create BankAccount");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Check Balance");
        int option = input2.nextInt();
        switch(option){
            case 1:
                createBankAccount();
                break;
                case 2:depositMoney();
                break;
                case 3:withdrawMoney();
                break;
                case 4:checkBalance();
                break;
        }
    }
    public static void createBankAccount() {
        System.out.println("What is your name?");
        String name = input.nextLine();
        int accountNumber = rand.nextInt(999999) ;
        customers.add(new Customer(name,accountNumber));
        accounts.add(new BankAccount(accountNumber));
        System.out.println("Your bank account has been created!");
        System.out.println("Your account number is: " + accountNumber);
        mainmenu();

    }
    public static void depositMoney() {
        System.out.println("What is your Account Number?");
        int accountNumber = input2.nextInt();
        for(Customer customer : customers){
            if(customer.getAccountNumber()==accountNumber){
                System.out.println( "Hello " + customer.getName());
                System.out.println("How much do you want to deposit?");
                double amount = input2.nextDouble();
                customer.depositMoney(amount);
            }
        }
        mainmenu();
    }
    public static void withdrawMoney() {
        System.out.println("What is your Account Number?");
        int accountNumber = input2.nextInt();
        for(Customer customer : customers){
            if(customer.getAccountNumber()==accountNumber){
                System.out.println( "Hello " + customer.getName());
                System.out.println("How much do you want to withdraw?");
                double amount = input2.nextDouble();
                customer.withdrawMoney(amount);
            }
        }
       mainmenu();
    }
    public static void checkBalance() {
        System.out.println("What is your Account Number?");
        int accountNumber = input2.nextInt();
        for(Customer customer : customers){
            if(customer.getAccountNumber()==accountNumber){
                System.out.println( "Hello " + customer.getName());
                customer.checkBalance();
            }
        }
        mainmenu();
    }
}
