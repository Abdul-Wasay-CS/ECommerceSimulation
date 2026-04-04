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
        this.adminId = adminId;
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
    protected void copyObject(User other) {
        super.copyObject(other);
        if (other instanceof Admin) {
            Admin adminOther = (Admin) other;
            this.adminId = adminOther.adminId;
            this.post = adminOther.post;
            this.salary = adminOther.salary;
        }
    }

    // signup
    @Override
    void signUp() {
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
    }


    @Override
    public void login(String username, String password) {

        // At this point the current object doesn't have loaded data

        Admin loadedAdmin = FileManager.loadAdmin(username, password);
        if (username.equals(userName) && password.equals(this.password)) {
            this.copyObject(loadedAdmin);
        } else {
            System.out.printf(
                    Color.Red() + "Wrong %s\n" + Color.Reset(),
                    password.equals(this.password) ? "username" : "password");
        }
    }
}
