public abstract class User {
    protected String fullName;
    protected String userName;
    protected Address address;
    protected int ssn;
    protected static  int userId = 0;

    User(){
        fullName =null;
        userName = null;
        ssn = 0;
        userId++;
    }

    // Note: Make sure that address recieved from the main class isnt null.

    User(String fullName, String userName, Address address, int ssn){
        this.fullName = fullName;
        this.userName = userName;
        this.address= new Address(address);
        this.ssn = ssn;
    }

}
