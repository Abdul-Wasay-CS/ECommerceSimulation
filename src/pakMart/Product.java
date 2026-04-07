package pakMart;

import java.io.File;
import java.util.Scanner;

// import java.util.Objects;

class Product {
    private int productId;
    private String name;
    private double price;
    private int stock;

    public Product() {
        productId = 0;
        name = null;
        price = 0;
        stock = 0;
    }

    public Product(int productId, String name, double price, int stock) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public static void displayProducts() {
        try {
            File products = new File("Products.txt");
            Scanner reader = new Scanner(products);
            Color.Cyan();
            System.out.println("╔══════════════════════════════════════════════════════════════╗");
            System.out.println("║                      Available Products                      ║");
            System.out.println("╠══════════════════════════════════════════════════════════════╣");
            System.out.println("║ Product ID │ Name                 │ Price      │ Stock       ║");
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] details = line.split(",");
                System.out.printf("║ %-10s │ %-20s │ %-10.2f │ %-11d ║\n", details[0], details[1],
                        Double.parseDouble(details[2]), Integer.parseInt(details[3]));
            }
            System.out.println("╚══════════════════════════════════════════════════════════════╝");
            Color.Reset();
            reader.close();
        } catch (Exception e) {
            Color.Red();
            System.out.println("""
                    ╔══════════════════════════════════════════════════════════════╗
                    ║ An error occurred while reading the products file.           ║
                    ║ Please try again later.                                      ║
                    ╚══════════════════════════════════════════════════════════════╝
                    """);
        }
    }

    public static Product getProductById(String productId) {
        try {
            File products = new File("Products.txt");
            Scanner reader = new Scanner(products);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] details = line.split(",");
                if (details[0].equals(productId)) {
                    reader.close();
                    return new Product(Integer.parseInt(details[0]), details[1], Double.parseDouble(details[2]),
                            Integer.parseInt(details[3]));
                }
            }
            reader.close();
        } catch (Exception e) {
            Color.Red();
            System.out.println("""
                    ╔══════════════════════════════════════════════════════════════╗
                    ║ An error occurred while reading the products file.           ║
                    ║ Please try again later.                                      ║
                    ╚══════════════════════════════════════════════════════════════╝
                    """);
        }
        return null;
    }

    public void display() {
        System.out.println(this);
    }

    public void updatePrice(double price) {
        if (price > 0)
            this.price = price;
    }

    public boolean reduceStock(int quantity) {
        if (quantity <= stock && quantity > 0) {
            stock -= quantity;
            return true;
        }
        return false;
    }

    public void addStock(int quantity) {
        if (quantity > 0) {
            stock += quantity;
        }
    }

    public double getTotalPrice(int quantity) {
        if (quantity > 0)
            return price * quantity;
        return 0;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0)
            this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock >= 0)
            this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId +
                ", Name: " + name +
                ", Price: " + price +
                ", Stock: " + stock;
    }
}