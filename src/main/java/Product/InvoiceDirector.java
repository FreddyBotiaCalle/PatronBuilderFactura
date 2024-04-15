package Product;
import Build.Invoice;


import java.util.List;
public class InvoiceDirector {
    private InvoiceBuilder builder;

    public InvoiceDirector(InvoiceBuilder builder) {
        this.builder = builder;
    }

    public Invoice constructInvoice(String customerName, List<ShoppingCartItem> shoppingCartItems) {
        builder.createInvoice(customerName);
        for (ShoppingCartItem item : shoppingCartItems) {
            builder.addItem(item.getProductName(), item.getPrice());
        }
        builder.applyDiscount();
        return builder.getInvoice();
    }
}
