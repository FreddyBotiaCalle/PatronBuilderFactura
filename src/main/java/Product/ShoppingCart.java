package Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<ShoppingCartItem> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(ShoppingCartItem item) {
        items.add(item);
    }

    public List<ShoppingCartItem> getItems() {
        return items;
    }
}
