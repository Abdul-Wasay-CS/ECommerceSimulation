package pakMart.frontEnd;

public class CustomerLoginWindow extends BasicLoginScreen {
    
    public CustomerLoginWindow(){
        super();
        super.setTitle("Customer Login");
    }
    public static void main(String[] args) {
        CustomerLoginWindow customerLoginWindow = new CustomerLoginWindow();
        customerLoginWindow.setLocationRelativeTo(null); // Center the frame on the screen
        customerLoginWindow.setVisible(true);
    }
}
