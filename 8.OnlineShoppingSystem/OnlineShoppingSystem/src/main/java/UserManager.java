import java.util.HashMap;

public class UserManager {
    private HashMap<String, String> users;

    public UserManager() {
        users = new HashMap<>();
    }

    public boolean registerUser(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("Username is already taken");
            return false;
        }
        users.put(username, password);
        System.out.println("Username is registered successfully");
        return true;
    }

    public boolean loginUser(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println(" Login successful!");
            return true;
        } else {
            System.out.println(" Incorrect username or password.");
            return false;
        }
    }
}
