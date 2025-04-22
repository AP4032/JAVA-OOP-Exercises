import java.util.Random;
import java.util.Scanner;

public class Customer {
    private String name;
    private BankAccount bankAccount;
    public Customer(String name){
        this.name=name;
    }
    public String getName() {
        return name;
    }
    public void createAccount(){
        Random random = new Random();
        int accountNumber= random.nextInt();
        System.out.println("Welcome to the Bank! ");
        System.out.println("Please enter your name: ");
        Scanner scanner = new Scanner(System.in);
        name= scanner.nextLine();
        System.out.println("Enter 1 for a savings account or 2 for a checking account: ");
        int choice= scanner.nextInt();
        scanner.nextLine();
        if (choice == 1){
            bankAccount= new SavingsAccount(accountNumber);
        } else if (choice == 2) {
            bankAccount= new CheckingAccount(accountNumber);
        }else{
            System.out.println("Invalid choice!");
        }
    }
    public void deposit(double amount){
        bankAccount.deposit(amount);
    }
    public void withdraw(double amount){
        bankAccount.withdraw(amount);
    }
    public void checkBalance(){
        bankAccount.checkBalance();
    }
}
