package Product;

import Build.Invoice;

public abstract class InvoiceBuilder {
    protected Invoice invoice;

    public Invoice getInvoice() {
        return invoice;
    }

    public void createInvoice(String customerName) {
        invoice = new Invoice(customerName);
    }

    public abstract void addItem(String productName, double price);

    public abstract void applyDiscount();
}

