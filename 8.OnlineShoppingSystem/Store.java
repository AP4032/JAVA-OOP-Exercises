import java.util.ArrayList;
import java.util.List;

public class Store
{
    private List<Product> inventory;

    public Store()
    {
        this.inventory = new ArrayList<>();
    }
    public void addProduct(Product product)
    {
        inventory.add(product);
        System.out.println(product.getName() + " added to store.");
    }
    public void getProducts()
    {
        if (inventory.isEmpty())
        {
            System.out.println("No items in store.");
        }
        else
        {
            int counter = 1;
            for (Product product : inventory)
            {
                System.out.println(counter++ + ". " + product.getName() + " $" + product.getPrice());
            }
        }
    }
}