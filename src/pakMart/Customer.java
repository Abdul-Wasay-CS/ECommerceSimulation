package pakMart;

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
        Customer loadedCustomer = CustomerFileManager.load(userName, password);

        if (loadedCustomer != null) {
            System.out.println(Color.Green() + """
                ╔══════════════════════════════════════════════════════════════╗
                ║                      Login Successful!                       ║
                ╚══════════════════════════════════════════════════════════════╝
                """ + Color.Reset());
            loadedCustomer.menu();
        } else {
            System.out.println(Color.Red() + """
                    ╔══════════════════════════════════════════════════════════════╗
                ║                    Invalid Credentials!                      ║
                ║ Please check your username and password and try again.       ║
                    ╚══════════════════════════════════════════════════════════════╝
                    """ + Color.Reset());
            Main.main(null);
        }
    }

    public static void signUp(String fullName, String newUserName, String newPassword, String country, String city,
                              String society, int streetNo, int houseNo, String phoneNumber) {
        Address address = new Address(country, city, society, streetNo, houseNo);
        Customer customer = new Customer(fullName, newUserName, address, 0, phoneNumber, 0);
        customer.password = newPassword;

        if (CustomerFileManager.saveData(customer)) {
            customer.menu();
        } else {
            Main.main(null);
        }
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