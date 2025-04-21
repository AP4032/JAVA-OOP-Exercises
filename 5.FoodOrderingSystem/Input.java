import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    public static Scanner scanner = new Scanner(System.in);

    public static int getIntInput(String massage) {
        int choice = -1;

        boolean isValid = false;
        while (!isValid) {
            Print.printGreenText(massage);
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                isValid = true;
            }
            catch (InputMismatchException ex) {
                Print.printTitle("Invalid input, try again");
                scanner.nextLine();
            }
            ;
        }

        return choice;
    }
}
