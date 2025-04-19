import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your initial balance: ");
        double initialBalance = scanner.nextDouble();

        Customer customer = new Customer(name, initialBalance);
        Bank bank = new Bank(customer);
        bank.start();

        scanner.close();
    }
}
