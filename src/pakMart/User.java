package pakMart;

import java.util.Objects;
import java.util.regex.Pattern;

public abstract class User {
    protected String fullName;
    protected String userName;
    protected String password;
    protected Address address;
    protected boolean signedUp;
    protected int ssn;

    User() {
        fullName = null;
        userName = null;
        ssn = 0;
    }

    // Note: Make sure that address received from the main class isn't null.

    User(String fullName, String userName, Address address, int ssn) {
        this.fullName = fullName;
        this.userName = userName;
        this.address = new Address(address);
        this.ssn = ssn;
    }


    abstract void login(String username, String password);
    abstract void menu();

    protected void copyObject(User other) {
        if (other != null) {
            this.fullName = other.fullName;
            this.userName = other.userName;
            this.password = other.password;
            this.address = other.address != null ? new Address(other.address) : null;
            this.signedUp = other.signedUp;
            this.ssn = other.ssn;
        }
    }

    public boolean  isSignedUp() {
        return fullName != null && userName != null && ssn != 0 && address != null;
    }

    // Method to validate SSN format
    protected boolean isValidSSN(String ssn) {
        // SSN format: XXX-XX-XXXX where X is a digit
        String ssnPattern = "^\\d{3}-\\d{2}-\\d{4}$";
        return Pattern.matches(ssnPattern, ssn);
    }

    // Method to convert formatted SSN string to integer
    protected int convertSSNToInt(String ssn) {
        // Remove hyphens and parse to integer
        String numbersOnly = ssn.replaceAll("-", "");
        return Integer.parseInt(numbersOnly);
    }


    // getters and setters


    public void setSignedUp(boolean signedUp) {
        this.signedUp = signedUp;
    }


    public boolean getSignedUp() {
        return signedUp;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {

        // To avoid  ClassCastException
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;

        return getSsn() == user.getSsn() && Objects.equals(getFullName(),
                user.getFullName()) && Objects.equals(getUserName(),
                user.getUserName()) && Objects.equals(getAddress(), user.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(ssn, fullName, userName, address);

    }
}
