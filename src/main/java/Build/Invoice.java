package Build;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private String customerName;
    private List<InvoiceItem> items;

    public Invoice(String customerName) {
        this.customerName = customerName;
        this.items = new ArrayList<>();
    }

    public void addItem(InvoiceItem item) {
        items.add(item);
    }

    public List<InvoiceItem> getItems() {
        return items;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTotalPrice() {
        return "";
    }


    public void applyDiscount() {
    }
}
