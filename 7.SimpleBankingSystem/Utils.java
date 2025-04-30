import java.util.Locale;
import java.util.Scanner;

public class Utils {
    public static int getNum(){
        Scanner inputInt = new Scanner(System.in);
        try {
            int input = inputInt.nextInt();
            return input;
        } catch (Exception e) {
            System.out.println("Invalid input. Try again.");
            return getNum();
        }
    }
    public static double getDoubleNum(){
        Scanner inputInt = new Scanner(System.in);
        inputInt.useLocale(Locale.US);
        try {
            double input = inputInt.nextDouble();
            return input;
        } catch (Exception e) {
            System.out.println("Invalid input. Try again.");
            return getDoubleNum();
        }
//        String input = getString();
//        for ( char c : input.toCharArray()) {
//            if (!(Character.isDigit(c))) {
//                System.out.println("Invalid input. Try again.");
//                return getDoubleNum();
//            }
//        }
//        return Double.parseDouble(input);
    }
    public static Customer getCustomer(Bank bank) {
        System.out.println("Enter your account number:");
        String accountNumber = getString();
        boolean found = false;
        Customer c = null;
        for(Customer customer : bank.getCustomers()){
            if(customer.getAccount().getAccountNumber().equals(accountNumber)){
                c = customer;
                found = true;
            }
        }
        if(!found){
            System.out.println("This account number is not exists. Try again.");
            return getCustomer(bank);
        }
        do {
            System.out.println("Enter your password:");
            int password = getNum();
            if (password != c.getAccount().getPassword()) {
                System.out.println("Invalid password. Try again.");
            }
            else
                break;
        }while (true);
        return c;
    }
    public static String getString(){
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        if (string.isBlank()){
            System.out.println("Invalid input. Try again:");
            getString();
        }
        return string;
    }
}
