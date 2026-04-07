package pakMart;

import java.util.List;

public abstract class Cart {
    protected List<CartItem> items;

    public Cart() {
        items = new java.util.ArrayList<>();
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void addItem(CartItem item) {
        items.add(item);
    }

    public void removeItem(CartItem item) {
        items.remove(item);
    }

    public void clearCart() {
        items.clear();
    }

    public double getTotalPrice() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return total;
    }

    public void displayCart() {
        if (items.isEmpty()) {
            Color.Red();
            System.out.println("""
                    ╔══════════════════════════════════════════════════════════════╗
                    ║                      Your Cart is Empty                      ║
                    ╚══════════════════════════════════════════════════════════════╝
                    """);
            Color.Reset();
            return;
        }
        Color.Cyan();
        System.out.println("Your Cart:");
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║ Product Name         │ Quantity   │ Total Price              ║");
        System.out.println("╠══════════════════════════════════════════════════════════════╣");
        for (CartItem item : items) {
            System.out.printf("║ %-20s │ %-10d │ $%-23.2f ║\n", item.getProduct().getName(), item.getQuantity(),
                    item.getProduct().getPrice() * item.getQuantity());
        }
        System.out.printf("╚══════════════════════════════════════════════════════════════╝\n");
        System.out.printf("Total: $%.2f%n", getTotalPrice());
        Color.Reset();
    }

    public void removeItemByProductId(int productId) {
        for (int i = 0; i < items.size(); i++) {
            CartItem item = items.get(i);

            if (item.getProduct().getProductId() == productId) {
                items.remove(i);
                break;
            }
        }
    }

    public abstract void displayOrderDetails();

    public abstract void checkout();
}