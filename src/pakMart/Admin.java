package pakMart;

import java.util.Objects;

public class Admin extends User {
    private String adminId;
    private String post;
    private double salary;

    // adminId format = "A" + adminCount;
    private static int adminCount = 0;

    public Admin() {
        super();
        this.adminId = "A" + (++adminCount);
    }

    // used to intialize a completly new admin
    public Admin(String fullName, String userName,
            Address address, int ssn,
            String post, double salary) {
        super(fullName, userName, address, ssn);
        this.post = post;
        this.salary = salary;
        this.adminId = "A" + (++adminCount);
    }

    // used to intialize admin with already assigned id
    public Admin(String fullName, String userName,
            Address address, int ssn, String adminId,
            String post, double salary) {
        super(fullName, userName, address, ssn);
        this.adminId = adminId;
        this.post = post;
        this.salary = salary;
    }

    @Override
    public void menu() {
        System.out.println(Color.Cyan() + "=".repeat(20)
                + Color.Reset() + Color.Green() + "Admin Menu" + Color.Reset() + Color.Cyan() + "=".repeat(20)
                + Color.Reset());
        System.out.println(Color.Yellow() + """

                1.  Add new product \n
                2.  Remove a product\n
                3.  Edit a product\n
                4.  View all products\n
                5.  View all customers\n""" + Color.Reset());
        System.out.println(Color.Cyan() + "=".repeat(40) + Color.Reset());
        System.out.println("Enter your choice: ");
        int choice = SafeInputs.getInt();
        switch (choice) {
            case (1): {
                addProduct();
                break;
            }
            case (2): {
                removeProduct();
                break;
            }
            case (3): {
                editProduct();
                break;
            } 
            case (4): {
                viewAllProducts();
                break;
            }
            case (5): {
                viewAllCustomers();
                break;
            }
        }
    }

    private void viewAllProducts() {
        // InventoryManager.viewAllProducts();
        System.out.println("Viewing all products");
    }

    private void viewAllCustomers() {
        // FileManager.viewAllCustomers();
        System.out.println("Viewing all customers");
    }

    private void addProduct() {
        System.out.println("What type of product you want to add? ");
        System.out.println(Color.Yellow() + """
                1. Electronics
                2. Clothing
                3. Groceries
                """ + Color.Reset());
        int typeChoice = SafeInputs.getInt();
        switch (typeChoice) {
            case (1): {
                // InventoryManager.addElectronic();
                // the inventory manager method will ask for the details to be added and then
                // perform the addition
                System.out.println("Adding new electronic product");
                break;
            }
            case (2): {
                // InventoryManager.addClothing();
                // the inventory manager method will ask for the details to be added and then
                // perform the addition
                System.out.println("Adding new clothing product");
                break;
            }
            case (3): {
                // InventoryManager.addGrocery();
                // the inventory manager method will ask for the details to be added and then
                // perform the addition
                System.out.println("Adding new grocery product");
                break;
            }
            default: {
                System.out.println(Color.Red() + "Invalid choice" + Color.Reset());
            } // end of default case for product type choice
        }// end of switch case for product type choice
    }// end of addProduct method

    private void editProduct() {
        System.out.println("What type of product you want to edit? ");
        System.out.println(Color.Yellow() + """
                1. Electronics
                2. Clothing
                3. Groceries
                """ + Color.Reset());
        int typeChoice = SafeInputs.getInt();
        switch (typeChoice) {
            case (1): {
                System.out.println("Enter the id of the electronic product you want to edit: ");
                int id = SafeInputs.getInt();
                // InventoryManager.editElectronic(id);
                // the inventory manager method will ask for the details to be edited and then
                // perform the edit
                break;
            }
            case (2): {
                System.out.println("Enter the id of the clothing product you want to edit: ");
                int id = SafeInputs.getInt();
                // InventoryManager.editClothing(id);
                // the inventory manager method will ask for the details to be edited and then
                // perform the edit
                System.out.println("Editing clothing product with id: " + id);
                break;
            }
            case (3): {
                System.out.println("Enter the id of the grocery product you want to edit: ");
                int id = SafeInputs.getInt();
                // InventoryManager.editGrocery(id);
                // the inventory manager method will ask for the details to be edited and then
                // perform the edit
                System.out.println("Editing grocery product with id: " + id);
                break;
            }
            default: {
                System.out.println(Color.Red() + "Invalid choice" + Color.Reset());
            } // end of default case for product type choice
        }// end of switch case for product type choice
    }// end of editProduct method

    private void removeProduct() {
        System.out.println("What type of product you want to remove? ");
        System.out.println(Color.Yellow() + """
                1. Electronics
                2. Clothing
                3. Groceries
                """ + Color.Reset());
        int typeChoice = SafeInputs.getInt();
        switch (typeChoice) {
            case (1): {
                System.out.println("Enter the id of the electronic product you want to remove: ");
                int id = SafeInputs.getInt();
                // InventoryManager.removeElectronic(id);
                // the inventory manager method will perform the removal and also handle the
                // case if the product with given id is not found
                System.out.println("Removing electronic product with id: " + id);
                break;
            }
            case (2): {
                System.out.println("Enter the id of the clothing product you want to remove: ");
                int id = SafeInputs.getInt();
                // InventoryManager.removeClothing(id);
                // the inventory manager method will perform the removal and also handle the
                // case if the product with given id is not found
                System.out.println("Removing clothing product with id: " + id);
                break;
            }
            case (3): {
                System.out.println("Enter the id of the grocery product you want to remove: ");
                int id = SafeInputs.getInt();
                // InventoryManager.removeGrocery(id);
                // the inventory manager method will perform the removal and also handle the
                // case if the product with given id is not found
                System.out.println("Removing grocery product with id: " + id);
                break;
            }
            default: {
                System.out.println(Color.Red() + "Invalid choice" + Color.Reset());
            } // end of default case for product type choice
        }// end of switch case for product type choice
    }// end of removeProduct method

    @Override
    protected void copyObject(User other) {
        super.copyObject(other);
        if (other instanceof Admin adminOther) {
            this.adminId = adminOther.adminId;
            this.post = adminOther.post;
            this.salary = adminOther.salary;
        }
    }

    public void signUp() {
        if (super.getSignedUp()) {
            System.out.println("You are already signed up.");
            return;
        }

        System.out.println("\n=== ADMIN SIGNUP ===");

        // Full Name
        System.out.print("Enter Full Name: ");
        this.fullName = SafeInputs.getString();
        while (this.fullName.isBlank() || !this.fullName.matches("[a-zA-Z\\s]+")) {
            System.out.print("Invalid name. Enter letters only: ");
            this.fullName = SafeInputs.getString();
        }

        // Username
        System.out.print("Enter Username: ");
        this.userName = SafeInputs.getString();
        while (this.userName.trim().isEmpty() || this.userName.length() < 3) {
            System.out.print("Username must be at least 3 characters: ");
            this.userName = SafeInputs.getString();
        }

        // Password
        System.out.print("Enter Password (min 6 chars): ");
        this.password = SafeInputs.getString();
        while (this.password.length() < 6) {
            System.out.print("Password too short (min 6): ");
            this.password = SafeInputs.getString();
        }

        // pakMart.Address
        Address addr = new Address();
        System.out.print("Enter Country: ");
        addr.setCountry(SafeInputs.getString());
        System.out.print("Enter City: ");
        addr.setCity(SafeInputs.getString());
        System.out.print("Enter Society: ");
        addr.setSociety(SafeInputs.getString());
        System.out.print("Enter Street No: ");
        addr.setStreetNo(SafeInputs.getInt());
        System.out.print("Enter House No: ");
        addr.setHouseNo(SafeInputs.getInt());
        this.address = addr;

        // SSN
        System.out.print("Enter SSN (XXX-XX-XXXX): ");
        String ssnInput = SafeInputs.getString();
        while (!isValidSSN(ssnInput)) {
            System.out.print("Invalid format. Use XXX-XX-XXXX: ");
            ssnInput = SafeInputs.getString();
        }
        this.ssn = convertSSNToInt(ssnInput);

        // pakMart.Admin specific
        System.out.print("Enter Post/Position: ");
        this.post = SafeInputs.getString();
        while (this.post.isBlank()) {
            System.out.print("Post cannot be empty: ");
            this.post = SafeInputs.getString();
        }

        System.out.print("Enter Salary: ");
        this.salary = SafeInputs.getDouble();
        while (this.salary < 0) {
            System.out.print("Salary cannot be negative: ");
            this.salary = SafeInputs.getDouble();
        }

        // Generate admin ID
        this.adminId = "A" + (++adminCount);
        this.signedUp = true;

        System.out.println(Color.Green() + "\nSignup Successful!" + Color.Reset());
        System.out.println("pakMart.Admin ID: " + adminId);

        // Save to file
        if (FileManager.saveAdminData(this)) {
            System.out.println("Admin data saved successfully.");
        } else {
            System.out.println("Failed to save admin data.");
        }
    }

    @Override
    public void login(String username, String password) {

        // At this point the current object doesn't have loaded data
        Admin loadedAdmin = FileManager.loadAdmin(username, password);

        if (loadedAdmin != null) {
            if (username.equals(loadedAdmin.getUserName()) && password.equals(loadedAdmin.getPassword())) {
                this.copyObject(loadedAdmin);
            } else {
                System.out.printf(
                        Color.Red() + "Wrong %s\n" + Color.Reset(),
                        password.equals(this.password) ? "username" : "password");
            }
        } else {
            System.out.println("Login failed, Admin not found.");
        }
    }

    // setters and getters

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Admin admin))
            return false;
        if (!super.equals(o))
            return false;
        return Double.compare(getSalary(), admin.getSalary()) == 0 && Objects.equals(getAdminId(), admin.getAdminId())
                && Objects.equals(getPost(), admin.getPost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAdminId(), getPost(), getSalary());
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId='" + adminId + '\'' +
                ", post='" + post + '\'' +
                ", salary=" + salary +
                ", fullName='" + fullName + '\'' +
                ", userName='" + userName + '\'' +
                ", address=" + address +
                ", password='" + password + '\'' +
                ", signedUp=" + signedUp +
                ", ssn=" + ssn +
                '}';
    }

    public static boolean exists(String username, String password) {
        if (FileManager.findAdmin(username, password)) {
            System.out.println("Admin found!");
            return true;
        } else {
            System.out.println("Admin doesnt exist");
            return false;
        }

    }
}
