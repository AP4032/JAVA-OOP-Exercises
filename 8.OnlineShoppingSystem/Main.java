import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Product p1 = new Product("Sunscreen", 20.25);
        Product p2 = new Product("Eyeliner", 12);
        Product p3 = new Product("Lipstick",15);
        Product p4 = new Product("Foundation", 25.5);
        Product p5 = new Product("Eye Shadow", 27);
        Product p6 = new Product("Setting Powder", 13);
        Product p7 = new Product("Concealer", 17);
        store.addProduct(p1);
        store.addProduct(p2);
        store.addProduct(p3);
        store.addProduct(p4);
        store.addProduct(p5);
        store.addProduct(p6);
        store.addProduct(p7);
        Customer c1 = new Customer("mas","mas@GMail.com","mas1234");
        c1.registerCustomer();
        ShoppingCart shoppingCart = new ShoppingCart();
        store.browseProducts();
                    shoppingCart.addProducts(p1);
                    shoppingCart.addProducts(p3);
                    shoppingCart.calculateTotal();
                    shoppingCart.checkout(shoppingCart);

        }
}
