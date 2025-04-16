package OnlineShoppingSystem;

public class Product
{
    private String name ;
    private double price , takhfif;
    private int number_inventory;

    public int getNumber_inventory() {
        return number_inventory;
    }

    public double getSell_price() {
        return sell_price;
    }

    private double sell_price;

    public Product(String name , double price , double takhfif  , int number_inventory){
        this.name = name;
        this.price = price;
        this.takhfif = takhfif;
        this.number_inventory = number_inventory;
        sell_price = price - price * takhfif / 100;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getTakhfif() {
        return takhfif;
    }

    public void change_number(int tedad){
        number_inventory -= tedad;
    }
}
