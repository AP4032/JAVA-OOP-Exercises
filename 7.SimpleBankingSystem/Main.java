import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String Red = "\033[31m";
        String Green = "\033[32m";
        String Reset = "\033[0m";
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        Bank bank = new Bank();
        while (true) {
            System.out.println("Welcome to the banking system.");
            System.out.println("Select the options below:");
            System.out.println("Please select the options below to use:");
            System.out.println("1.New Account");
            System.out.println("2.Register Person");
            System.out.println("3.Login to Account");
            System.out.println("4.Exit");
            String Choice = input.nextLine();
            switch (Choice) {
                case "1":
                    System.out.println("You must login.");
                    System.out.println("Please enter your Username:");
                    String Userr = input.nextLine();
                    System.out.println("Please enter your password:");
                    String Password = input.nextLine();
                    if (!Userr.equals("") && !Password.equals("") && bank.CheckCustomer(Userr, Password)) {
                        Customer customer = bank.map.get(Userr);
                        int IDcard = rand.nextInt(4000) + 1000;
                        BankAccount account = new BankAccount(IDcard);
                        customer.AddAccount(account, IDcard);
//                        bank.map.put(Userr, customer);
//                        bank.Customers.add(customer);
                        System.out.println(Green + "Your account has been successfully registered with ID card " + IDcard + " ." + Reset);
                    } else {
                        System.out.println(Red + "Your username or password is incorrect." + Reset);
                    }
                    break;
                case "2":
                    System.out.println("please enter your name:");
                    String User = input.nextLine();
                    System.out.println("please enter your password:");
                    String password = input.nextLine();
                    Customer customer = new Customer(User, password);
                    bank.Customers.add(customer);
                    bank.map.put(User, customer);
                    break;
                case "3":
                    System.out.println("You must login.");
                    System.out.println("Please enter your Username:");
                    String User1 = input.nextLine();
                    System.out.println("Please enter your password:");
                    String Passwordd = input.nextLine();
                    if (!User1.equals("") && !Passwordd.equals("") && bank.CheckCustomer(User1, Passwordd)) {
                        Customer Customer = bank.map.get(User1);
                        System.out.println(Green + "Your login was successful" + Reset);
                        int IdCard;
                        while (true) {
                            System.out.println(Green + "To use the user panel Mr/Ms" + Customer.getUser() + Reset);
                            System.out.println("Enter your card number:");
                            Customer.GetAllBankAccounts();
                            IdCard = input.nextInt();
                            input.nextLine();
                            if (Customer.map.containsKey(IdCard)) {
                                break;
                            } else {
                                System.out.println(Red + "The card ID entered is incorrect" + Reset);
                            }
                        }

                        BankAccount account = Customer.map.get(IdCard);
                        boolean Staymenu = true;
                        while (Staymenu) {
                            System.out.println("To use card services with ID number :" + IdCard);
                            System.out.println("Select one of the following options :");
                            System.out.println("1.Withdraw");
                            System.out.println("2.Deposit");
                            System.out.println("3.get balance");
                            System.out.println("4.EXIT");
                            String choice = input.nextLine();
                            switch (choice) {
                                case "1":
                                    System.out.println("Please enter the withdrawal amount:");
                                    int withdraw = input.nextInt();
                                    input.nextLine();
                                    account.Withdrawal(withdraw);
                                    break;
                                case "2":
                                    System.out.println("Please enter the Deposit amount:");
                                    int deposit = input.nextInt();
                                    input.nextLine();
                                    account.Deposit(deposit);
                                    break;
                                case "3":
                                    System.out.println(Green + "Balance:" + account.getBalance() + " $" + Reset);
                                    break;
                                case "4":
                                    Staymenu = false;

                                default:
                                    System.out.println(Red + "The entered option is incorrect" + Reset);
                                    System.out.println(Red + "Please try again" + Reset);
                                    break;
                            }
                        }
                    } else {
                        System.out.println(Red + "Your username or password is incorrect." + Reset);
                    }
                    break;
                case "4":
                    System.exit(0);
                    break;
                default:
                    System.out.println(Red + "Please enter a valid option." + Reset);

            }
        }
    }
}