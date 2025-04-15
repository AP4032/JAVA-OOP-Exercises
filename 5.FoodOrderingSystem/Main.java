import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner strScanner = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);
        System.out.println("Welcome to the Ol'Chef's restaurant!");
        Restaurant restaurant = new Restaurant();
        System.out.println("Please enter your name: ");
        String name = strScanner.nextLine();
        Customer customer = new Customer(name);
        while (true) {
            System.out.println(customer.getName() + " , select an option:\n1.add item to the menu\n2.check the menu\n3.make an order\n4.check your orders\n5.exit\n");
            int option = intScanner.nextInt();
            String itemName;
            switch (option) {
                case 1:
                    System.out.println("enter the item's name: ");
                    itemName = strScanner.nextLine();
                    System.out.println("enter the item's price: ");
                    double itemPrice = intScanner.nextDouble();
                    MenuItem menuItem = new MenuItem(itemName, itemPrice);
                    restaurant.addItem(menuItem);
                    break;
                case 2:
                    restaurant.printMenu();
                    break;
                case 3:
                    Order order = new Order();
                    System.out.println("enter the item's name/done to proceed: ");
                    itemName = strScanner.nextLine();
                    while (!itemName.equals("done")) {
                        MenuItem itemToAdd = restaurant.getMenuItems().get(itemName);
                        order.addToOrderList(itemToAdd);
                        System.out.println("enter the item's name/done to proceed: ");
                        itemName = strScanner.nextLine();
                    }
                    restaurant.receiveOrder(order);
                    break;
                case 4:
                    restaurant.printOrders();
                    break;
                case 5:
                    System.out.println("thank you for using our service");
                    System.exit(0);
            }
        }
    }
}
