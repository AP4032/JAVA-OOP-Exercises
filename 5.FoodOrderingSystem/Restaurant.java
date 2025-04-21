import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String address;
    private List<MenuItem> menu;

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
        this.menu = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    public void removeMenuItem(MenuItem item) {
        menu.remove(item);
    }

    public void displayMenu() {
        System.out.println("Menu for " + name + ":");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i));
        }
    }
}
