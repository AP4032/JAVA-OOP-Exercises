public class Customer {
    private String name;
    private Order order;

    public Customer(String name) {
        this.name = name;
        this.order = new Order();
    }
    public String getName (){
       return name;
    }
    public Order getOrder(){
        return order;
    }
    public void setOrder(Order order){
        this.order = order;
    }

    public Order placeOrder(MenuItem... items) {
        Order order = new Order();
        for (MenuItem item : items) {
            order.addItem(item);
        }
        order.calculateTotal();
        return order;
    }
}