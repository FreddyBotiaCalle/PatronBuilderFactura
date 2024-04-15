package Product;
import Build.Invoice;
import Build.InvoiceItem;

import java.util.List;

public class SecondItemDiscountBuilder extends InvoiceBuilder {
    private int itemCount;
    private double secondItemDiscount;

    public SecondItemDiscountBuilder() {
        itemCount = 0;
        secondItemDiscount = 0.1; // 10% de descuento en el segundo ítem
    }

    @Override
    public void addItem(String productName, double price) {
        invoice.addItem(new InvoiceItem(productName, price));
        if (productName.equals("bufanda de seda")) {
            itemCount++;
        }
    }

    @Override
    public void applyDiscount() {
        if (itemCount >= 2) {
            List<InvoiceItem> items = invoice.getItems();
            double totalDiscount = 0;
            for (InvoiceItem item : items) {
                if (item.getProductName().equals("bufanda de seda")) {
                    totalDiscount += item.getPrice() * secondItemDiscount;
                    item.setPrice(item.getPrice() * (1 - secondItemDiscount)); // Aplicar descuento al segundo ítem
                }
            }
            System.out.println("Descuento aplicado: $" + totalDiscount);
        }
    }
}
