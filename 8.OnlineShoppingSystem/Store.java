import java.util.ArrayList;

public class Store {
    private ArrayList<Product> availableProducts;
    private ArrayList<Customer> customers;
    public Store (){
        this.availableProducts = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.initProducts();
    }

    public void addNewItem(Product product){
        availableProducts.add(product);
        System.out.println("Product :" + product.getProductName()+ " was added to the Store :)");
    }
    public void chargeProduct (Product p, int count){
       p.setStockCount(count);
    }
    private void initProducts() {
        // Create and configure products
        Product apple = new Product("Apple", 0.99f);
        apple.setStockCount(100);
        Product laptop = new Product("Laptop", 899.99f);
        laptop.setStockCount(20);
        Product book = new Product("Book", 15.50f);
        book.setStockCount(50);

        // Add products to the store
        availableProducts.add(apple);
        availableProducts.add(laptop);
        availableProducts.add(book);
    }

    public ArrayList<Product> getAvailableProducts() {
        return availableProducts;
    }
    public ArrayList<Customer> getCustomers(){
        return customers;
    }
}
