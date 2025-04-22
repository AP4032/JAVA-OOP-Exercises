import java.util.List;
import java.util.ArrayList;
public class ShoppingCart {
    private List<Product> items;

    public ShoppingCart(){
        this.items = new ArrayList<>();
    }

    public void addItem(Product product){
        this.items.add(product);
        System.out.println(product.getName() + " successfully added to cart.");
    }

    public void removeItem(Product product){
        this.items.remove(product);
        System.out.println(product.getName() + " successfully removed from cart.");
    }

    public double calculateTotal(){
        double total = 0;
        for(Product item : items){
            total += item.getPrice();
        }
        return total;
    }

    public void checkout(){
        System.out.println("Total amount: $" + calculateTotal());
        System.out.println("Order placed successfully!");
        items.clear();
    }

    public List<Product> getItems() {
        return items;
    }
}
