
import java.util.Scanner;

public class Main3 {
    public static void main(String[] ads){
    Scanner scanner=new Scanner(System.in);
    Bank bank=new Bank();
    boolean Closed =true;
    String Number;
 loginCreate:while(Closed){
        System.out.println("------------------------------");
        System.out.println("> Welcome to Big Masoud Bank <");
        System.out.println("------------------------------");
        System.out.println("1>Login on account");
        System.out.println("2>Create an account");
        System.out.println("3>Change password");
        System.out.println("4>Exit");
        System.out.println("------------------------------");
        Number=scanner.nextLine();
        switch(Number.charAt(0)-'0'){
            case 2:
            System.out.println("What is your name? Sir");
            String Name=scanner.nextLine();
            System.out.println("Enter A Password For your account.Sir");
            int Password;
            while(true){

                if(scanner.hasNextInt()){
                    Password=scanner.nextInt();
                    scanner.nextLine();
                    if(Password<9999&&Password>1000){
                        break;
                    }else System.out.println("Enter a four-digit number.");

                }else System.out.println("Enter a four-digit number.");
            }
            Customer1 customer=new Customer1(Name,Password);
                System.out.println("Do you have cash?y/n");
                String YesOrNo=scanner.nextLine();
                if(YesOrNo.charAt(0)=='Y'||YesOrNo.charAt(0)=='y'){
                    System.out.println("How much?");
                    double Money;
                    while(true){

                        if(scanner.hasNextDouble()){
                            Money=scanner.nextDouble();
                            scanner.nextLine();
                                break;
                        }else System.out.println("Enter a number.");
                    }
                    customer.setInventory(Money);
                }
                bank.SetCustomer(customer);
                break;
            case 1:
                System.out.println("Enter Your AccountNumber");
                int getAccountNumber;
                while(true){
                    if(scanner.hasNextInt()){
                        getAccountNumber=scanner.nextInt();
                        scanner.nextLine();
                        break;
                    }else {
                        System.out.println("Enter a number.");
                        scanner.nextLine();
                    }
                }
                Customer1 Customer =FindAccountNumber(bank,getAccountNumber);
                if (Customer!=null){
                    int password;
                    System.out.println("your You forgot password?y/n");
                    String forgot= scanner.nextLine();
                    if(forgot.charAt(0)=='Y'||forgot.charAt(0)=='y'){
                        break;
                    }
                    System.out.println("Enter password");
                    while(true){

                        if(scanner.hasNextInt()){
                            password=scanner.nextInt();
                            scanner.nextLine();
                            if(password<9999&&password>1000&&password==Customer.getPassword()){
                                break;
                            }else System.out.println("Enter a four-digit number||The password is incorrect.");

                        }else {
                            System.out.println("Enter a four-digit number.");
                            scanner.nextLine();
                        }
                    }
                    while (true) {
                        System.out.println("------------------------------");
                        System.out.println("1<>Card to card");
                        System.out.println("2<>Add money to the account");
                        System.out.println("3<>Harvest");
                        System.out.println("4<>Change password");
                        System.out.println("5<>View My Inventory");
                        System.out.println("6<>Next 30 Day (For Deposit)");
                        System.out.println("7<>Exit");
                        System.out.println("------------------------------");
                        String Nam = scanner.nextLine();
                        switch (Nam.charAt(0) - '0') {
                            case 1:
                                System.out.println("Enter his||her account number.");
                                while (true) {
                                    if (scanner.hasNextInt()) {
                                        getAccountNumber = scanner.nextInt();
                                        scanner.nextLine();
                                        break;
                                    } else {
                                        System.out.println("Enter a number.");
                                        scanner.nextLine();
                                    }
                                }
                                Customer1 CustomerHisHer = FindAccountNumber(bank, getAccountNumber);
                                if (CustomerHisHer != null) {
                                    System.out.println("How much for Transfer?");
                                    double Yourmoney;
                                    while (true) {
                                        if (scanner.hasNextDouble()) {
                                            Yourmoney = scanner.nextDouble();
                                            scanner.nextLine();
                                            break;
                                        } else {
                                            System.out.println("Enter a number.");
                                            scanner.nextLine();
                                        }
                                    }
                                    Customer.Harvest(Yourmoney);
                                    CustomerHisHer.DepositMoney(Yourmoney);
                                    System.out.println("Transfer From:" + Customer.getName());
                                    System.out.println("Transfer To:" + CustomerHisHer.getName());
                                    System.out.println("In the amount of: $" + Yourmoney);
                                    System.out.println("Remainder $:" + Customer.getInventory());
                                } else System.out.println("NO Find Account");
                                break;

                            case 2:
                                System.out.println("How much?");
                                double money;
                                while (true) {

                                    if (scanner.hasNextDouble()) {
                                        money = scanner.nextDouble();
                                        scanner.nextLine();
                                        break;
                                    } else {
                                        System.out.println("Enter a number.");
                                        scanner.nextLine();
                                    }
                                }
                                Customer.DepositMoney(money);
                                break;
                            case 3:
                                System.out.println("How much?");
                                double money1;
                                while (true) {

                                    if (scanner.hasNextDouble()) {
                                        money1 = scanner.nextDouble();
                                        scanner.nextLine();
                                        break;
                                    } else {
                                        System.out.println("Enter a number.");
                                        scanner.nextLine();
                                    }
                                }
                                Customer.Harvest(money1);
                                break;
                            case 4:
                                System.out.println("Enter New Password");
                                int NewPassword;
                                while (true) {
                                    if (scanner.hasNextInt()) {
                                        NewPassword = scanner.nextInt();
                                        scanner.nextLine();
                                        break;
                                    } else {
                                        System.out.println("Enter a number.");
                                        scanner.nextLine();
                                    }
                                }
                                Customer.setPassword(NewPassword);
                                break;
                            case 5:
                                System.out.println("Yor Inventory: $" + Customer.getInventory());
                                break;
                            case 6:
                                Customer.Deposit();
                                break;
                            case 7:
                                System.out.println("Thank you for choosing Big Masoud Bank,Good bye.");
                                break loginCreate;
                        }
                    }

                }else System.out.println("NO Find Account");
                break;
            case 3:
                System.out.println("Enter Your AccountNumber");
                int accountNumber;
                while(true) {
                    if (scanner.hasNextInt()) {
                        accountNumber = scanner.nextInt();
                        scanner.nextLine();
                        break;
                    } else{
                        System.out.println("Enter a number.");
                        scanner.nextLine();
                    }
                }
                Customer1 customer2 =  FindAccountNumber(bank,accountNumber);
                if(customer2!=null){
                    System.out.println("Enter New Password");
                    int NewPassword;
                    while(true) {
                        if (scanner.hasNextInt()) {
                            NewPassword = scanner.nextInt();
                            scanner.nextLine();
                            break;
                        } else {
                            System.out.println("Enter a number.");
                            scanner.nextLine();
                        }
                    }
                    customer2.setPassword(NewPassword);
                }else System.out.println("NO Find Account");
                break;
            case 4:
                System.out.println("Thank you for choosing Big Masoud Bank,Good bye.");
                Closed=false;
                break;


        }

        }

    }
    public static Customer1 FindAccountNumber(Bank bank,int AccountNumber){
        for(Customer1 C: bank.getCustomerList()){
            if(C.getAccountNumber()==AccountNumber){
                return C;
            }
        }
        return null;
    }
}
