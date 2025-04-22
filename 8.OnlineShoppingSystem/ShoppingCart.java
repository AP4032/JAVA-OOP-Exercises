import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> cartItems;
    public ShoppingCart(){
        this.cartItems=new ArrayList<>();
    }
    public List<Product> getCartItems() {
        return cartItems;
    }
    public void addProducts(Product product){
        cartItems.add(product);
        System.out.println(product.getName() + " added to the cart");
    }
    public void calculateTotal(){
        double total=0;
        for( Product item : cartItems){
            total += item.getPrice();
        }
        System.out.println("Total price: " + total);
    }
    public void checkout(ShoppingCart sc){
        System.out.println("Your order is confirmed!");
    }
}
