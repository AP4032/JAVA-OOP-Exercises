import java.util.ArrayList;
import java.util.Random;

public class Customer {
    private final String userName;
    private final int id;
    private ArrayList<Product> products;

    public Customer(String name){
        Random rand = new Random();
        this.userName = name;
        this.products = new ArrayList<>();
        this.id = rand.nextInt(50000) + 10000;
    }

    //----------------------------------------------------------------------------
    // GETTERS
    //----------------------------------------------------------------------------
    public int getId(){
        return id;
    }
    public String getUserName(){
        return userName;
    }
    public ArrayList<Product> getProductsList(){
        return products;
    }

}
