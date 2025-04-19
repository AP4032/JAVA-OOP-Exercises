import java.util.Random;

public class Product {
    private String productName;
    private int id;
    private float productPrice;
    private int stockCount;

    public Product (String name, float price){
        Random rand = new Random();
        this.id = rand.nextInt(50000) + 10000;
        this.productName = name;
        this.productPrice = price;
    }

    //----------------------------------------------------------------------------
    // GETTERS
    //----------------------------------------------------------------------------
    public int getId (){
        return id;
    }
    public String getProductName(){
        return productName;
    }
    public float getProductPrice(){
       return productPrice;
    }
    public int getStockCount(){
        return stockCount;
    }

    //----------------------------------------------------------------------------
    // SETTERS
    //----------------------------------------------------------------------------
    public void setStockCount (int count){
       this.stockCount = count;
    }

    public void chargeProduct (int n){
        this.stockCount += n;
    }
}
