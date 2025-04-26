import java.util.HashMap;
import java.util.Map;

public class AuthenticationSystem {
    private Map<String, String> usersDatabase;

    public AuthenticationSystem() {
        usersDatabase = new HashMap<>();
    }

    // Register a new user
    public void registerUser(String username, String password) {
        usersDatabase.put(username, password);
        System.out.println("User " + username + " registered successfully.");
    }

    // Authenticate the user
    public boolean authenticate(String username, String password) {
        String storedPassword = usersDatabase.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }
}
