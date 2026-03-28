import java.util.Objects;

public abstract class User {
    protected String fullName;
    protected String userName;
    protected Address address;
    protected int ssn;
    protected static int userId = 0;

    User() {
        fullName = null;
        userName = null;
        ssn = 0;
        userId++;
    }

    // Note: Make sure that address recieved from the main class isnt null.

    User(String fullName, String userName, Address address, int ssn) {
        this.fullName = fullName;
        this.userName = userName;
        this.address = new Address(address);
        this.ssn = ssn;
    }

    // getters

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

    // setters

    public void setAddress(Address address) {
        this.address = address;
    }

    public static int getUserId() {
        return userId;
    }

    public static void setUserId(int userId) {
        User.userId = userId;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    @Override
    public boolean equals(Object o) {

        // To avoid  ClassCastException
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;

        return getSsn() == user.getSsn() && Objects.equals(getFullName(), user.getFullName()) && Objects.equals(getUserName(), user.getUserName()) && Objects.equals(getAddress(), user.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(ssn, fullName,userName, userId,address);

    }
}
