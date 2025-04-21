import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> items;

    public Menu() {
        this.items = new ArrayList<>();
        initializeMenu();
    }

    private void initializeMenu() {
        items.add(new MenuItem("Cheeseburger", 8.99, "Beef patty with cheese and veggies"));
        items.add(new MenuItem("Pepperoni Pizza", 12.99, "Classic pizza with pepperoni"));
        items.add(new MenuItem("Caesar Salad", 6.99, "Fresh romaine with Caesar dressing"));
        items.add(new MenuItem("Spaghetti Carbonara", 11.99, "Pasta with creamy sauce"));
    }

    public void displayMenu() {
        System.out.println("\n=== RESTAURANT MENU ===");
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%d. %s\n", i+1, items.get(i));
            System.out.println("   " + items.get(i).getDescription());
        }
        System.out.println("=======================");
    }

    public MenuItem getItem(int index) {
        if (index > 0 && index <= items.size()) {
            return items.get(index - 1);
        }
        return null;
    }

    public int getMenuSize() {
        return items.size();
    }
}