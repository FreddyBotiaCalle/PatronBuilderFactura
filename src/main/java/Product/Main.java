package Product;
import Build.Invoice;
import Build.InvoiceItem;

import java.util.ArrayList;
import java.util.List;

//public class Main {
//    public static void main(String[] args) {
//        // Crear instancia de ShoppingCart y agregar ítems
//        ShoppingCart shoppingCart = new ShoppingCart();
//        shoppingCart.addItem(new ShoppingCartItem("vestido de seda", 2900000));
//        shoppingCart.addItem(new ShoppingCartItem("bufanda de seda", 100000));
//        shoppingCart.addItem(new ShoppingCartItem("bufanda de seda", 100000));
//
//        // Crear instancia de InvoiceDirector con SecondItemDiscountBuilder
//        InvoiceBuilder builder = new SecondItemDiscountBuilder();
//        InvoiceDirector director = new InvoiceDirector(builder);
//
//        // Crear factura con el director y los ítems del carrito
//        InvoiceController controller = new InvoiceController(director);
//        Invoice invoice = controller.createInvoice("Cliente Ejemplo", shoppingCart.getItems());
//
//        // Mostrar información de la factura
//        System.out.println("Cliente: " + invoice.getCustomerName());
//        List<InvoiceItem> items = invoice.getItems();
//        System.out.println("Ítems de la factura:");
//        for (InvoiceItem item : items) {
//            System.out.println("- " + item.getProductName() + ": $" + item.getPrice());
//        }
//    }
//}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear instancia de ShoppingCart y agregar ítems ingresados por el usuario
        ShoppingCart shoppingCart = new ShoppingCart();
        System.out.println("Ingrese los productos al carrito (Ingrese 'fin' para terminar):");
        while (true) {
            System.out.print("Nombre del producto: ");
            String productName = scanner.nextLine();
            if (productName.equalsIgnoreCase("fin")) {
                break;
            }
            System.out.print("Precio del producto: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer del scanner
            shoppingCart.addItem(new ShoppingCartItem(productName, price));
        }

        // Crear instancia de InvoiceDirector con SecondItemDiscountBuilder
        InvoiceBuilder builder = new SecondItemDiscountBuilder();
        InvoiceDirector director = new InvoiceDirector(builder);

        // Crear factura con el director y los ítems del carrito
        InvoiceController controller = new InvoiceController(director);
        Invoice invoice = controller.createInvoice("Cliente Ejemplo", shoppingCart.getItems());

        // Mostrar información de la factura
        System.out.println("\nFACTURA DE COMPRA");
        System.out.println("Cliente: " + invoice.getCustomerName());
        List<InvoiceItem> items = invoice.getItems();
        System.out.println("Ítems de la factura:");
        for (InvoiceItem item : items) {
            System.out.println("- " + item.getProductName() + ": $" + item.getPrice());
        }

        scanner.close();
    }
}
