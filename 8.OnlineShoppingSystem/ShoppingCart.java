import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Product, Integer> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    public boolean addItem(Product product, int quantity) {
        if (product == null || quantity <= 0) {
            return false;
        }

        if (product.getStock() >= quantity) {
            if (product.decreaseStock(quantity)) {
                items.put(product, items.getOrDefault(product, 0) + quantity);
                System.out.printf("%d عدد %s به سبد خرید اضافه شد.\n", quantity, product.getName());
                return true;
            }
        }
        System.out.println("موجودی کافی نیست یا محصول نامعتبر است!");
        return false;
    }

    public boolean removeItem(Product product, int quantity) {
        if (product == null || quantity <= 0 || !items.containsKey(product)) {
            return false;
        }

        int currentQty = items.get(product);
        if (quantity >= currentQty) {
            items.remove(product);
            product.increaseStock(currentQty);
        } else {
            items.put(product, currentQty - quantity);
            product.increaseStock(quantity);
        }
        return true;
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("سبد خرید شما خالی است.");
            return;
        }

        System.out.println("\nمحصولات در سبد خرید:");
        items.forEach((product, quantity) ->
                System.out.printf("%s\nتعداد: %d | جمع: %.2f تومان\n\n",
                        product, quantity, product.getPrice() * quantity));

        System.out.printf("جمع کل سبد خرید: %.2f تومان\n", calculateTotal());
    }

    public boolean checkout() {
        if (items.isEmpty()) {
            System.out.println("سبد خرید شما خالی است!");
            return false;
        }

        System.out.println("\nسفارش شما با موفقیت ثبت شد!");
        System.out.printf("مبلغ قابل پرداخت: %.2f تومان\n", calculateTotal());
        items.clear();
        return true;
    }

    public Map<Product, Integer> getItems() {
        return new HashMap<>(items);
    }
}