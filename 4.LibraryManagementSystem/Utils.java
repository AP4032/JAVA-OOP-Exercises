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
    public static User getUserID(Admin admin){
        System.out.println("Enter your user ID:");
        int input=Utils.getNum();
        for (User user : admin.getUsers()) {
            if (user.getUserID() == input) {
                return user;
            }
        }
        System.out.println("Your id not found. Try again.");
        return getUserID(admin);
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
