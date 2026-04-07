package pakMart;

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

    Customer(Customer customer) {
        super(customer.fullName, customer.userName, customer.address, customer.ssn);
        this.phoneNumber = customer.phoneNumber;
        this.history = customer.history;
    }

    Customer(String fullName, String userName, Address address, int ssn, String phoneNumber, int history) {
        super(fullName, userName, address, ssn);
        this.phoneNumber = phoneNumber;
        this.history = history;
    }

    @Override
    public void login(String userName, String password) {
        try {
            File customerDetails = new File("Customer.txt");
            Scanner reader = new Scanner(customerDetails);
            boolean loginSuccessful = false;
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] details = line.split(",");
                if (details[1].equals(userName) && details[2].equals(password)) {
                    System.out.println(Color.Green() + """
                            ╔══════════════════════════════════════════════════════════════╗
                            ║                      Login Successful!                       ║
                            ╚══════════════════════════════════════════════════════════════╝
                            """ + Color.Reset());
                    Address address = new Address(details[3], details[4], details[5],
                            Integer.parseInt(details[6]), Integer.parseInt(details[7]));
                    Customer customer = new Customer(details[0], details[1], address,
                            Integer.parseInt(details[8]), details[9], Integer.parseInt(details[10]));
                    customer.menu();
                    loginSuccessful = true;
                    break;
                }
            }
            if (!loginSuccessful) {
                System.out.println(Color.Red() + """
                        ╔══════════════════════════════════════════════════════════════╗
                        ║                    Invalid Credentials!                      ║
                        ║ Please check your username and password and try again.       ║
                        ╚══════════════════════════════════════════════════════════════╝
                        """ + Color.Reset());
                Main.main(null);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(Color.Red() + """
                    ╔══════════════════════════════════════════════════════════════╗
                    ║ An error occurred while reading the login file.              ║
                    ║ Please try again later.                                      ║
                    ╚══════════════════════════════════════════════════════════════╝
                    """ + Color.Reset());
            Main.main(null);
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
            System.out.println(Color.Red() + """
                    ╔══════════════════════════════════════════════════════════════╗
                    ║ An error occurred while writing to the signup file.          ║
                    ║ Please try again later.                                      ║
                    ╚══════════════════════════════════════════════════════════════╝
                    """ + Color.Reset());
            Main.main(null);
        }
        Address address = new Address(country, city, society, streetNo, houseNo);
        Customer customer = new Customer(fullName, newUserName, address, 0, phoneNumber, 0);
        customer.menu();
    }

    @Override
    public void menu() {
        System.out.print(Color.Blue() + """
                ╔══════════════════════════════════════════════════════════════╗
                ║    Menu :                                                    ║
                ║    1. View Products                                          ║
                ║    2. Add Product to Cart                                    ║
                ║    3. Remove Product from Cart                               ║
                ║    4. View Cart                                              ║
                ║    5. View Orderdetails                                      ║
                ║    6. Checkout                                               ║
                ║    7. Logout                                                 ║
                ╚══════════════════════════════════════════════════════════════╝
                """ + Color.Reset());
        System.out.print("Enter Your choice : ");
        int choice = SafeInputs.getInt();
        Cart cart = new Order(this.fullName);
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
                    Product product = Product.getProductById(productId);
                    CartItem item = new CartItem(product, quantity);
                    cart.addItem(item);
                    System.out.println(Color.Green() + """
                            ╔══════════════════════════════════════════════════════════════╗
                            ║        Product added Successfully to cart!                   ║
                            ╚══════════════════════════════════════════════════════════════╝
                            """ + Color.Reset());
                    break;
                case (3):
                    SafeInputs.getString();
                    System.out.print("Enter the Product ID to remove from cart : ");
                    int productIdToRemove = SafeInputs.getInt();
                    cart.removeItemByProductId(productIdToRemove);
                    System.out.println(Color.Green() + """
                            ╔══════════════════════════════════════════════════════════════╗
                            ║      Product removed Successfully from cart!                 ║
                            ╚══════════════════════════════════════════════════════════════╝
                            """ + Color.Reset());
                    break;
                case (4):
                    cart.displayCart();
                    break;
                case (5):
                    cart.displayOrderDetails();
                    break;
                case (6):
                    cart.checkout();
                    break;
                case (7):
                    System.out.println(Color.Green() + """
                            ╔══════════════════════════════════════════════════════════════╗
                            ║                      Logout Successful!                      ║
                            ╚══════════════════════════════════════════════════════════════╝
                            """ + Color.Reset());
                    Main.main(null);
                    break;
                default:
                    System.out.println(Color.Red() + """
                            ╔════════════════════════════════════════════════════╗
                            ║                 Invalid Choice!                    ║
                            ║     Please enter a valid option from the menu.     ║
                            ╚════════════════════════════════════════════════════╝
                            """ + Color.Reset());
                    break;
            }
            System.out.print(Color.Blue() + """
                    ╔══════════════════════════════════════════════════════════════╗
                    ║    Menu :                                                    ║
                    ║    1. View Products                                          ║
                    ║    2. Add Product to Cart                                    ║
                    ║    3. Remove Product from Cart                               ║
                    ║    4. View Cart                                              ║
                    ║    5. View Orderdetails                                      ║
                    ║    6. Checkout                                               ║
                    ║    7. Logout                                                 ║
                    ╚══════════════════════════════════════════════════════════════╝
                    """ + Color.Reset());
            System.out.print("Enter Your choice : ");
            choice = SafeInputs.getInt();
        }
    }
}