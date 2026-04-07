package pakMart;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class Order extends Cart {
    private final int orderId;
    private String customerName;
    private Date orderDate;

    public Order(String customerName) {
        super();
        orderId = getOrderId();
        this.customerName = customerName;
        orderDate = new Date();
    }

    private int getOrderId() {
        try {
            File order = new File("Orders.txt");
            Scanner reader = new Scanner(order);
            int maxId = 0;
            while (reader.hasNextLine()) {
                reader.nextLine();
                maxId++;
            }
            reader.close();
            return maxId + 1;
        } catch (Exception e) {
            Color.Red();
            System.out.println("""
                    ╔══════════════════════════════════════════════════════════════╗
                    ║ An error occurred while generating the order ID.             ║
                    ║ Please try again later.                                      ║
                    ╚══════════════════════════════════════════════════════════════╝
                    """);
            return 0;
        }
    }

    @Override
    public void displayOrderDetails() {
        Color.Cyan();
        System.out.print("""
                ╔══════════════════════════════════════════════════════════════╗
                ║                      Order Details                           ║
                ╚══════════════════════════════════════════════════════════════╝
                """);
        System.out.printf("""
                ╔═════════════════════════════╗
                ║ Order ID: %-18d║
                ║ Customer: %-18s║
                ║ Date: %-22s║
                ╚═════════════════════════════╝
                        """, orderId, customerName, formatDate());
        this.displayCart();
        Color.Reset();
    }

    @Override
    public void checkout() {
        try {
            File orderFile = new File("Orders.txt");
            PrintWriter writer = new PrintWriter(new FileWriter(orderFile, true));
            writer.println(orderId + "," + customerName + "," + formatDate());
            for (CartItem item : items) {
                writer.println(item.getProduct().getProductId() + "," + item.getQuantity());
            }
            writer.close();
            Color.Green();
            System.out.println("""
                    ╔══════════════════════════════════════════════════════════════╗
                    ║ Order placed successfully! Thank you for shopping with us!   ║
                    ╚══════════════════════════════════════════════════════════════╝
                    """);
            Color.Reset();
        } catch (Exception e) {
            Color.Red();
            System.out.println("""
                    ╔══════════════════════════════════════════════════════════════╗
                    ║ An error occurred while processing your order.               ║
                    ║ Please try again later.                                      ║
                    ╚══════════════════════════════════════════════════════════════╝
                    """);
            Color.Reset();
        }
    }

    private String formatDate() {
        return String.format("%1$td-%1$tm-%1$tY %1$tH:%1$tM:%1$tS", orderDate);
    }
}