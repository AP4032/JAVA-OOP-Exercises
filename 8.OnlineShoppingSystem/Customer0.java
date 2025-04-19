import java.util.List;

public class Customer0 {
    private String name;
    private ShoppingCart cart;
    private String status;

    public Customer0(String name) {
        this.name = name;
        this.cart = new ShoppingCart();
        this.status= "Packing";
    }
    public String getName(){
        return name;
    }

    public void addToCart(Product product) {
        cart.addItem(product);
    }

    public void placeOrder() {
        cart.checkout();
    }
    public void ShowItems(){
        cart.ShowItems();
    }
    public double getCalculateTotal(){
     return cart.calculateTotal();
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status=status;
        System.out.println("Change to"+status+"completed.");
    }

}