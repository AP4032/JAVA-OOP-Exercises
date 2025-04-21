import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Bank bank = new Bank();
    Scanner scanner=new Scanner(System.in);
//    boolean run = true;
    Random random = new Random();


    while(true){
        System.out.println("<<<<BANK>>>>");
        System.out.println("1)create bank account");
        System.out.println("2)bardasht");
        System.out.println("3)variz");
        System.out.println("4)show balance");
        System.out.println("5)exit");
        System.out.println("Enter your choice: ");

        String choice=scanner.nextLine();
        switch(choice){
            case "1":
                System.out.print("enter your name: ");
                String name=scanner.nextLine();
                System.out.print("enter your password: ");
                int password=scanner.nextInt();
                scanner.nextLine();
                System.out.print("enter your balance: ");
                double balance=scanner.nextDouble();
                scanner.nextLine();
                Customer customer = new Customer(name,password,balance);
                bank.add(customer);
                System.out.println(name+"you are now have an accunt!");
                break;


                case "2":
                    System.out.print("enter your name: ");
                    String name1=scanner.nextLine();
                    System.out.print("enter your password: ");
                    int password1=scanner.nextInt();
                    scanner.nextLine();
                    if(bank.checkCustomer(name1,password1)) {
                        System.out.print("enter the amount you wan to get: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();
                        bank.customers.get(name1).bardasht(amount);
                    }
                    else
                        System.out.println("does not exist!");
                    break;

            case "3":  System.out.print("enter your name: ");
                String name2=scanner.nextLine();
                System.out.print("enter your password: ");
                int password2=scanner.nextInt();
                scanner.nextLine();
                if(bank.checkCustomer(name2,password2)){
                    System.out.print("enter the amount you wan to put in: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    bank.customers.get(name2).variz(amount);
                }
                else
                    System.out.println("does not exist!");
                break;
                case "4":System.out.print("enter your name: ");
                    String name3=scanner.nextLine();
                    System.out.println();
                    System.out.print("enter your password: ");
                    int password3=scanner.nextInt();
                    scanner.nextLine();
                    if(bank.checkCustomer(name3,password3)){
                        System.out.println("your ballance is: "+bank.customers.get(name3).showballance());
                    }
                    else
                        System.out.println("does not exist!");
                    break;

                case"5":
                    System.out.println("please get your card well done!");
                    System.exit(0);

                    break;
        }
    }





    }
}
