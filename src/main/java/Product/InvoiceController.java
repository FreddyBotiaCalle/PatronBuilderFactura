package Product;
import Build.Invoice;
import java.util.List;

public class InvoiceController {
    private InvoiceDirector director;

    public InvoiceController(InvoiceDirector director) {
        this.director = director;
    }

    public Invoice createInvoice(String customerName, List<ShoppingCartItem> shoppingCartItems) {
        return director.constructInvoice(customerName, shoppingCartItems);
    }
}
