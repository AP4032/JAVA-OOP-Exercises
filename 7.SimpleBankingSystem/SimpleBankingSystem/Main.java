import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
        System.out.println("====Welcome to our bank===");

        System.out.println("1.Create an account");
        System.out.println("2.deposit money");
        System.out.println("3.withdrawal of money And account balance");
        System.out.println("4.Exit");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice:");
        int number = scanner.nextInt();

            switch (number) {
                case 1:
                    System.out.println("==The right choice==");
                    Bank bank = new Bank();
                    break;
                case 2:
                    Scanner scanner2 = new Scanner(System.in);

                    System.out.print("Enter the amount:");

                    int money = scanner2.nextInt();

                    Scanner scanner3 = new Scanner(System.in);

                    System.out.print("Enter your name:");

                    String name = scanner3.next();

                    Scanner scanner4 = new Scanner(System.in);
                    System.out.print("Enter your accountNumber:");
                    int accountNumber = scanner4.nextInt();

                    Customer mone = new Customer(name,accountNumber);
                    mone.depositMoney(money);
                     mone.checkBalance();

                    break;
                case 3:

                    Scanner scanner5 = new Scanner(System.in);

                    System.out.print("Enter the amount:");

                    int money2 = scanner5.nextInt();
                    Scanner scanner6 = new Scanner(System.in);
                    System.out.print("Enter your name:");
                    String name2 = scanner6.next();

                    Scanner scanner7 = new Scanner(System.in);

                    System.out.print("Enter your accountNumber:");

                    int accountNumber2 = scanner7.nextInt();

                    Customer mone2 = new Customer(name2,accountNumber2);

                    mone2.depositMoney(money2);

                    Scanner scanner8 = new Scanner(System.in);
                    System.out.print("Amount of money withdrawn:");
                    int money3 = scanner8.nextInt();
                    mone2.withdrawMoney(money3);
                    mone2.checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting the game...");
                    return;


            }
        }


    }
}
