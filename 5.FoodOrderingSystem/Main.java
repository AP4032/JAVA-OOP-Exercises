import java.util.ArrayList;

public class Main {

    private static ArrayList<String> itemNames = new ArrayList<>();
    private static ArrayList<Double> itemPrices = new ArrayList<>();

    public static void main(String[] args) {

        Print.printTitle("Welcome to Restaurant");
        systemExplain();
        Customer customer = new Customer(getCustomerName());
        itemNames.add("Burger");
        itemPrices.add(5.99);
        itemNames.add("Pizza");
        itemPrices.add(4.99);
        itemNames.add("Fries");
        itemPrices.add(2.99);
        itemNames.add("Hot Dog");
        itemPrices.add(3.56);

        boolean wantsExit = false;
        while (!wantsExit) {
            Print.printTitle("Welcome " + customer.getName());
            Print.printGreenText("1- Order Food\n");
            Print.printGreenText("2- Add Food to Menu\n");
            Print.printGreenText("3- Remove Food From Menu\n");
            Print.printGreenText("4- Exit\n");
            int choice = Input.getIntInput("What's your choice? ");

            switch (choice) {
                case 1:
                    orderFood(customer);
                    break;
                case 2:
                    addFoodToMenu();
                    break;
                case 3:
                    removeFoodFromMenu();
                    break;
                case 4:
                    Print.printTitle("Exiting program, Sayonara");
                    wantsExit = true;
                    break;
                default:
                    Print.printTitle("Invalid input, try again");
                    break;
            }
        }


    }

    private static void orderFood(Customer customer) {

        boolean isValid = false;
        while (!isValid) {
            Print.printTitle("Order Food");
            for (int i = 0; i< itemNames.size(); i++) {
                Print.printGreenText("" + (i+1) + "- " + itemNames.get(i) + " (");
                Print.printGreenText("" + itemPrices.get(i) + "$)\n");
            }
            Print.printGreenText("" + (itemNames.size()+1) + "- Return Back\n");
            int choice = Input.getIntInput("What's your choice? ");
            if (choice == itemNames.size()+1) return;
            else if (choice > itemNames.size()+1) Print.printTitle("Invalid input, try again");
            else {
                MenuItem menuItem = new MenuItem(itemNames.get(choice-1), itemPrices.get(choice-1));
                Order order = customer.placeOrder(menuItem);
                Restaurant restaurant = new Restaurant();
                restaurant.receiveOrder(order);
                restaurant.updateOrderStatus(order, "Complete");
                isValid = true;
            }
        }

    }

    private static void addFoodToMenu() {
        Print.printTitle("Add Food To Menu");
        Print.printGreenText("Enter the food name: ");
        String foodName = Input.scanner.nextLine();
        Print.printGreenText("Enter the price of food: ");
        double foodPrice = Input.scanner.nextDouble();
        itemNames.add(foodName);
        itemPrices.add(foodPrice);
        Print.printTitle("Food: " + foodName + " successfully added");
    }

    private static void removeFoodFromMenu() {
        Print.printTitle("Remove Food From Menu");
        Print.printGreenText("Enter the food name: ");
        String foodName = Input.scanner.nextLine();
        for (int i = 0; i< itemNames.size(); i++) {
            if (itemNames.get(i).equals(foodName))
                itemNames.remove(i);
        }
        Print.printTitle("Food: " + foodName + " successfully removed");
    }

    private static void systemExplain() {
        String text = """
                ⚫ You can order any food from itemName
                ⚫ The time required to prepare the food is a maximum of twenty minutes
                """;

        Print.printRedText(text);
    }

    private static String getCustomerName() {
        System.out.print("What's your name? ");
        return Input.scanner.nextLine();
    }
}
