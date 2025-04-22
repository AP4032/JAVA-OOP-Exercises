import java.util.List;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner strScanner = new Scanner(System.in);
        Scanner numScanner = new Scanner(System.in);
        Store store = new Store();

        int password = 1234;
        boolean run = true;
        System.out.println("*** Online Shopping System ***");
        System.out.println("*Welcome to our site*");
        while (run){
            System.out.println("--Main menu--");
            System.out.println("1. Create an account.");
            System.out.println("2. View products.");
            System.out.println("3. Add product to cart.");
            System.out.println("4. View order summary.");
            System.out.println("5. Remove product from cart.");
            System.out.println("6. Place order and checkout.");
            System.out.println("7. Add Product.(Available only for admins.)");
            System.out.println("8. Exit.");
            System.out.print("Choose an option: ");
            int choice = numScanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter your name:");
                    String customerName = strScanner.nextLine();
                    store.addCustomer(customerName);
                    System.out.println(store.getCustomer().getName() + ", your account was successfully created.");
                    break;
                case 2:
                    System.out.println("Products:");
                    if(!(store.getProducts().isEmpty())){
                        for(Product p : store.getProducts()){
                            System.out.println(p.getName() + " : " + p.getPrice());
                        }
                    }else{
                        System.out.println("No products available.");
                    }
                    break;
                case 3:
                    System.out.println("Enter product name:");
                    String pName = strScanner.nextLine();
                    Product addProduct = findProduct(store.getProducts(),pName);
                    if(addProduct != null){
                        store.getCustomer().addToCard(addProduct);
                        store.productRemove(addProduct);
                    }else{
                        System.out.println("The product is not available.");
                    }
                    break;
                case 4:
                    System.out.println("Order summary:");
                    if(store.getCustomer().getCart().getItems().isEmpty()){
                        System.out.println("The shopping cart is still empty.");
                    }else{
                        for(Product p : store.getCustomer().getCart().getItems()){
                            System.out.println(p.getName());
                        }
                    }
                    break;
                case 5:
                    System.out.println("Enter product name:");
                    String pName1 = strScanner.nextLine();
                    Product removeProduct = findProduct(store.getCustomer().getCart().getItems(), pName1);
                    if(removeProduct != null){
                        store.addProduct(removeProduct);
                        store.getCustomer().removeFromCart(removeProduct);
                    }else{
                        System.out.println("The product is not available.");
                    }
                    break;
                case 6:
                    store.getCustomer().placeOrder();
                    break;
                case 7:
                    System.out.println("Enter password:");
                    int passWord = numScanner.nextInt();
                    if( passWord == password ){
                        System.out.println("Enter product name:");
                        String pName2 = strScanner.nextLine();
                        System.out.println("Enter product price:");
                        double price = numScanner.nextDouble();
                        Product product = new Product(pName2,price);
                        store.addProduct(product);
                        System.out.println("The product with name: " + pName2 +" and price: " + price +"$ was successfully added to the store.");
                    }else{
                        System.out.println("Only admin can access this section.");
                    }
                    break;
                case 8:
                    run = false;
                    System.out.println("Good bye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
    public static Product findProduct(List<Product> products, String name){
        for(Product p : products){
            if(name.equals(p.getName())){
                return p;
            }
        }
        return null;
    }
}
