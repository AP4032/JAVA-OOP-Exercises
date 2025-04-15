import java.util.HashMap;
import java.util.Map;

public class Customer {
    private final String Password;
    private final String User;
    String Red = "\033[31m";
    String Green = "\033[32m";
    String Reset = "\033[0m";
    Map<Integer, BankAccount> map;

    public Customer(String User, String Password) {
        this.User = User;
        this.Password = Password;
        map = new HashMap<>();
        System.out.println(Green + "Your account was created with username: " + User + " and password :" + Password + Reset);
    }

    public void AddAccount(BankAccount account, int IDcard) {
        map.put(IDcard, account);
    }

    public String getPassword() {
        return Password;
    }

    public String getUser() {
        return User;
    }

    public void GetAllBankAccounts() {
        int num = 1;
        for (BankAccount account : map.values()) {
            System.out.println(num + "." + account.getIDcard());
            num++;
        }
    }
//    public Boolean CheckIDCard(String IDcard) {
//
//    }

}
