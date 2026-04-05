package pakMart;

import pakMart.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Customer extends User {
    protected String phoneNumber;
    protected int history;

    Customer() {
        super();
    }

    Customer(String fullName, String userName, Address address, int ssn, String phoneNumber, int history) {
        super(fullName, userName, address, ssn);
        this.phoneNumber = phoneNumber;
        this.history = history;
    }

    public void login(String userName, String password) {
        try {
            File customerDetails = new File("Customer.txt");
            Scanner reader = new Scanner(customerDetails);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] details = line.split(",");
                if (details[1].equals(userName) && details[2].equals(password)) {
                    System.out.println("Login successful. Welcome back, " + details[0] + "!");
                    Address address = new Address(details[3], details[4], details[5],
                            Integer.parseInt(details[6]), Integer.parseInt(details[7]));
                    Customer customer = new Customer(details[0], details[1], address,
                            Integer.parseInt(details[8]), details[9], Integer.parseInt(details[10]));
                    customer.menu();
                    break;
                } else {
                    System.out.println("Invalid username or password. Please try again.");
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("An error occurred while reading the file.");
        }
    }

    public static void signUp(String fullName, String newUserName, String newPassword, String country, String city,
                              String society, int streetNo, int houseNo, String phoneNumber) {
        try {
            File customerDetails = new File("Customer.txt");
            PrintWriter writer = new PrintWriter(new FileWriter(customerDetails, true));
            writer.println(fullName + "," + newUserName + "," + newPassword + "," + country + "," + city + ","
                    + society + "," + streetNo + "," + houseNo + "," + 0 + "," + phoneNumber + "," + 0);
            writer.close();
        } catch (Exception e) {
            System.out.println("An error occurred while writing to the file.");
        }
        Address address = new Address(country, city, society, streetNo, houseNo);
        Customer customer = new Customer(fullName, newUserName, address, 0, phoneNumber, 0);
        customer.menu();
    }

    @Override
    public void menu() {
        System.out.print("""
                menu :
                1. View Products
                2. Add Product to Cart
                3. Remove Product from Cart
                4. View Cart
                5. View Orderdetails
                6. Checkout
                7. Logout
                Enter Your choice : """);
        Cart cart = new Cart();
        int choice = SafeInputs.getInt();
        while (true) {
            switch (choice) {
                case (1):
                    Product.displayProducts();
                    break;
                case (2):
                    SafeInputs.getString();
                    System.out.print("Enter the Product ID : ");
                    String productId = SafeInputs.getString();
                    System.out.print("Enter the quantity : ");
                    int quantity = SafeInputs.getInt();
                    Product product = Product.getProductById(Integer.parseInt(productId));
                    CartItem item = new CartItem(product, quantity);
                    cart.addItem(item);
                    break;
                case (3):
                    SafeInputs.getString();
                    System.out.print("Enter the Product ID to remove from cart : ");
                    int productIdToRemove = SafeInputs.getInt();
                    cart.removeItemByProductId(productIdToRemove);
                    break;
                case (4):
                    cart.displayCart();
                    break;
                case (5):
                    // View Orderdetails
                    break;
                case (6):
                    // Checkout
                    break;
                case (7):
                    System.out.println("Logout successful. Goodbye!");
                    pakMart.Main(null);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.print("""
                    menu :
                    1. View Products
                    2. Add Product to Cart
                    3. Remove Product from Cart
                    4. View Cart
                    5. Checkout
                    6. Logout
                    Enter Your choice : """);
            choice = SafeInputs.getInt();
        }
    }
}