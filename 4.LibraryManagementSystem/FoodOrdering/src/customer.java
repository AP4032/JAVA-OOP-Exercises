import java.util.Scanner;

public class customer {
    private String name;

    public customer(String name) {
        this.name = name;
    }

    public order placeOrder(menuItem[] menu) {
        Scanner scanner = new Scanner(System.in);
        order order = new order();
        System.out.println("\nMenu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i]);
        }

        System.out.println("Enter item numbers to order : ");
        String[] choices = scanner.nextLine().split(",");

        for (String choice : choices) {
            int index = Integer.parseInt(choice.trim()) - 1;
            if (index >= 0 && index < menu.length) {
                order.addItem(menu[index]);
            }
        }

        System.out.println(name + " placed an order.");
        order.displayOrder();
        return order;
    }
}