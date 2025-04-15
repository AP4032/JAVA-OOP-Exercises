import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    Map<String, Customer> map;//username & password
    List<Customer> Customers;

    public Bank() {
        map = new HashMap<>();
        Customers = new ArrayList<>();
    }

    public Boolean CheckCustomer(String username, String password) {
        return map.containsKey(username) && map.get(username).getPassword().equals(password);

    }

    public void addCustomer(String username, String password) {
        map.put(username, new Customer(username, password));
    }

}
