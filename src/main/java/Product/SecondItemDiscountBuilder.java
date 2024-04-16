package Product;
import Build.InvoiceItem;

import java.util.List;

public class SecondItemDiscountBuilder extends InvoiceBuilder {
    private double discountPercentage;

    public SecondItemDiscountBuilder(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public void addItem(String productName, double price) {
        invoice.addItem(new InvoiceItem(productName, price));
    }

    @Override
    public void applyDiscount() {
        List<InvoiceItem> items = invoice.getItems();
        double totalDiscount = 0;
        boolean secondItemFound = false; // Bandera para rastrear si se ha encontrado el segundo ítem igual
        for (int i = 0; i < items.size(); i++) {
            InvoiceItem currentItem = items.get(i);
            totalDiscount += currentItem.getPrice() * discountPercentage;

            // Verificar si es el segundo ítem igual y aplicar descuento
            if (!secondItemFound && i > 0 && currentItem.getProductName().equals(items.get(i - 1).getProductName())) {
                double discountedPrice = currentItem.getPrice() * (1 - discountPercentage);
                currentItem.setPrice(discountedPrice);
                secondItemFound = true;
            }
        }
        System.out.println("Descuento aplicado: $" + totalDiscount);
    }
}