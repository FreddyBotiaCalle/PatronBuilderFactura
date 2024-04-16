package Product;

import Build.InvoiceItem;

import java.util.List;

public class FirstThreeItemsAndFourthDiscountBuilder extends InvoiceBuilder {
    private double firstThreeItemsDiscountPercentage;
    private double fourthItemDiscountPercentage;

    public FirstThreeItemsAndFourthDiscountBuilder(double firstThreeItemsDiscountPercentage, double fourthItemDiscountPercentage) {
        this.firstThreeItemsDiscountPercentage = firstThreeItemsDiscountPercentage;
        this.fourthItemDiscountPercentage = fourthItemDiscountPercentage;
    }

    @Override
    public void addItem(String productName, double price) {
        invoice.addItem(new InvoiceItem(productName, price));
    }

    @Override
    public void applyDiscount() {
        List<InvoiceItem> items = invoice.getItems();
        double totalDiscount = 0;

        // Aplicar descuento en los primeros tres ítems
        for (int i = 0; i < Math.min(3, items.size()); i++) {
            InvoiceItem currentItem = items.get(i);
            double discount = currentItem.getPrice() * firstThreeItemsDiscountPercentage;
            currentItem.setPrice(currentItem.getPrice() - discount);
            totalDiscount += discount;
        }

        // Aplicar descuento en el cuarto ítem
        if (items.size() >= 4) {
            InvoiceItem fourthItem = items.get(3);
            double discount = fourthItem.getPrice() * fourthItemDiscountPercentage;
            fourthItem.setPrice(fourthItem.getPrice() - discount);
            totalDiscount += discount;
        }

        System.out.println("Descuento aplicado: $" + totalDiscount);
    }
}